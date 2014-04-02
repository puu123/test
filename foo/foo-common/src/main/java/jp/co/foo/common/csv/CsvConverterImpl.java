package jp.co.foo.common.csv;

import java.util.List;

public class CsvConverterImpl implements CsvConverter {

	/* (non-Javadoc)
	 * @see jp.co.foo.common.csv.CsvConverter#to(java.lang.String[], java.lang.Class)
	 */
	@Override
	public <T> T to(String[] csvLine, Class<T> _cls) {	
		return null;
	}

	/* (non-Javadoc)
	 * @see jp.co.foo.common.csv.CsvConverter#getConvertErrors()
	 */
	@Override
	public List<String> getConvertErrors() {
		// TODO Auto-generated method stub
		return null;
	}

}
