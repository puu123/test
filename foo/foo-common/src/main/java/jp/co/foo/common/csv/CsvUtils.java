package jp.co.foo.common.csv;

import java.util.Date;

import org.apache.commons.lang.time.FastDateFormat;

public class CsvUtils {

	public String f(Date date, String format){
		FastDateFormat fmt = FastDateFormat.getInstance(format);
		return fmt.format(date);
	} 

}
