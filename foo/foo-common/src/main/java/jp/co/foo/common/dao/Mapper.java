package jp.co.foo.common.dao;

import java.util.List;

import jp.co.foo.common.dto.AbstractDto;

public interface Mapper<ID, DTO extends AbstractDto<ID>, EXAMPLE> {

    int countByExample(EXAMPLE example);

    int deleteByExample(EXAMPLE example);

    int deleteByPrimaryKey(ID id);

    int insert(DTO record);

    int insertSelective(DTO record);

    List<DTO> selectByExample(EXAMPLE example);

    DTO selectByPrimaryKey(ID id, boolean forUpdate);

    int updateByExampleSelective(DTO record, EXAMPLE example);

    int updateByExample(DTO record, EXAMPLE example);

    int updateByPrimaryKeySelective(DTO record);

    int updateByPrimaryKey(DTO record);
}
