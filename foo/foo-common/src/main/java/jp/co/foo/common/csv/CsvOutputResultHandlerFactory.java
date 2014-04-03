package jp.co.foo.common.csv;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

public class CsvOutputResultHandlerFactory {
	
	protected char delimiter = ',';
	
	protected char quote = '"';
	
	protected String encoding = "Windows-31J"; 
	 
	public <T> CsvOutputResultHandler<T> create(OutputStream out) {
		
		Writer outWriter = new OutputStreamWriter(
				new BufferedOutputStream(out), Charset.forName(encoding));
		ICsvBeanWriter writer = 
				new CsvBeanWriter(outWriter, CsvPreference.STANDARD_PREFERENCE);
		
		CsvOutputResultHandler<T>
			handler = new CsvOutputResultHandler<T>(writer);
		
		return handler;
	}

}
