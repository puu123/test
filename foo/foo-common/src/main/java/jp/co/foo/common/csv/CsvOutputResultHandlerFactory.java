package jp.co.foo.common.csv;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

import com.Ostermiller.util.ExcelCSVPrinter;

public class CsvOutputResultHandlerFactory {
	
	protected char delimiter = ',';
	
	protected char quote = '"';
	
	protected String encoding = "Windows-31J"; 
	 
	public <T> CsvOutputResultHandler<T> create(OutputStream out) {
		
		Writer writer = new OutputStreamWriter(
				new BufferedOutputStream(out), Charset.forName(encoding));
		ExcelCSVPrinter printer = new ExcelCSVPrinter(writer, quote, delimiter);
		
		CsvOutputResultHandler<T>
			handler = new CsvOutputResultHandler<T>(printer);
		
		return handler;
	}

}
