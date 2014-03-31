package jp.co.foo.common.dao;

import java.util.Date;

import jp.co.foo.common.dto.AbstractDto;
import jp.co.foo.common.exception.ApplicationException;

public abstract class AbstractDao<ID> {
	
	protected IdGenerator<ID> idGenerator;
	
	protected Mapper<ID, AbstractDto<ID>, ?> mapper;
		
	protected Date now;
	
	protected String account;
	
	protected void setInsertInfo(AbstractDto<ID> dto){
		
		ID id = idGenerator.generate();
		dto.setId(id);
		
		dto.setVersion(0L);
		dto.setCreatedAccount(account);
		dto.setCreatedAt(now);
		dto.setUpdatedAccount(account);
		dto.setUpdatedAt(now);
	}
	
	public int insert(AbstractDto<ID> dto) {
		
		this.setInsertInfo(dto);
		int updateCnt = mapper.insert(dto);
		
		return updateCnt;
	}
	
	public int insertSelective(AbstractDto<ID> dto) {
		
		this.setInsertInfo(dto);
		int updateCnt = mapper.insertSelective(dto);
		
		return updateCnt;
	}
	
	protected void setUpdateInfo(AbstractDto<ID> dto){
		
		AbstractDto<ID> oldDto = mapper.selectByPrimaryKey(dto.getId(), true);

		long version = oldDto.getVersion();
		if (oldDto == null || 
				dto.getVersion() != version ) {
			throw new ApplicationException();
		}
		
		dto.setVersion(version + 1L);
		dto.setCreatedAccount(oldDto.getCreatedAccount());
		dto.setUpdatedAt(oldDto.getCreatedAt());
		dto.setUpdatedAccount(account);
		dto.setUpdatedAt(now);
	}
	
	public int updateByPrimaryKey(AbstractDto<ID> dto) {

		this.setUpdateInfo(dto);
		int updateCnt = mapper.updateByPrimaryKey(dto);
		
		return updateCnt;
	}
	
	public int updateByPrimaryKeySelective(AbstractDto<ID> dto) {

		this.setUpdateInfo(dto);
		int updateCnt = mapper.updateByPrimaryKeySelective(dto);
		
		return updateCnt;
	}
	

}
