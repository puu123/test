package jp.co.foo.common.csv;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

import com.Ostermiller.util.ExcelCSVPrinter;

public class CsvOutputResultHandler<T> implements ResultHandler {
	
	protected ExcelCSVPrinter printer;
	 
	public CsvOutputResultHandler(ExcelCSVPrinter printer) {
		this.printer = printer;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void handleResult(ResultContext context) {
		T obj = (T)context.getResultObject();
		outputRow(obj);
	}
	
	public void outputRow(T obj) {
		printer.println();
	}
}
