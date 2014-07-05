package jp.co.foo.service.impl;

import jp.co.foo.datamapper.Zip2Mapper;
import jp.co.foo.dto.Zip2Dto;
import jp.co.foo.dto.Zip2Example;
import jp.co.foo.service.ZipService;

import org.springframework.beans.factory.annotation.Autowired;
import org.supercsv.io.dozer.CsvDozerBeanReader;


public class ZipServiceImpl implements ZipService {

	@Autowired
	private Zip2Mapper mapper;
	
	public void importFile(CsvDozerBeanReader reader) throws Exception {
		Zip2Dto dto = null;
		while ((dto = reader.read(Zip2Dto.class, Zip2Dto.PROCESSORS)) != null) {
			mapper.insert(dto);
		}
	}

	public int count() {
		Zip2Example example = new Zip2Example();
		return mapper.countByExample(example);
	}

}
