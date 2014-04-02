package jp.co.foo.common.csv;

import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

import jp.co.foo.common.exception.ApplicationException;

import org.apache.commons.lang.NotImplementedException;

import com.Ostermiller.util.ExcelCSVParser;

@SuppressWarnings("unchecked")
public class CsvLineIterator<T> implements Iterator<T>, Closeable {
	
	protected ExcelCSVParser parser;
	
	protected CsvConverter converter = new CsvConverterImpl();
	
	protected Class<T> type;
	
	boolean close = false;
	
	
	CsvLineIterator(ExcelCSVParser parser, T... t) {
		this.parser = parser;
        Class<T> type = (Class<T>) t.getClass().getComponentType();
        this.type = type;
	}
	
	public CsvLineIterator(Reader reader) {
		this(new ExcelCSVParser(reader));
	}
	
	public CsvLineIterator(Reader reader, char delimiter) {
		this(new ExcelCSVParser(reader, delimiter));
	}
	
	public void close() throws IOException {
		if (!close) {
			parser.close();
		}	
	}	

	public boolean hasNext() {
		return false;
	}

	public void remove() {
		throw new NotImplementedException();
	}

	public T next() {
		
		T dto = null;
		try {
			
			String[] values = parser.getLine();
			dto = converter.to(values, type);
			
		} catch (IOException ioe) {
			try { parser.close(); } catch (Exception ioe2) {}
			throw new ApplicationException();
		}
		
		return dto;
	}

	/**
	 * @return the converter
	 */
	public CsvConverter getConverter() {
		return converter;
	}

	/**
	 * @param converter the converter to set
	 */
	public void setConverter(CsvConverter converter) {
		this.converter = converter;
	}
}