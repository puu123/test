package jp.co.foo.common.csv;

import java.util.List;

public interface CsvConverter {
	
	<T> T to(String[] source, Class<T> destinationClass);
	
	List<String> getConvertErrors();
}
