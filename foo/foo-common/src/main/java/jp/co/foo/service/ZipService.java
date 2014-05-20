package jp.co.foo.service;

import org.supercsv.io.dozer.CsvDozerBeanReader;

public interface ZipService {
	public void importFile(CsvDozerBeanReader reader) throws Exception;
}
