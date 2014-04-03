package jp.co.foo.common.csv;

import java.io.IOException;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.ICsvBeanWriter;

import com.Ostermiller.util.ExcelCSVPrinter;

public class CsvOutputResultHandler<T> implements ResultHandler {
	
	ICsvBeanWriter writer;
	
	String[] header;
	
	CellProcessor[] cellProcessors;
	
	 
	public CsvOutputResultHandler(ICsvBeanWriter writer) {
		this.writer = writer;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void handleResult(ResultContext context) {
		T rowData = (T)context.getResultObject();
		outputRow(rowData);
	}
	
	public void outputRow(T rowData) {
		try {
			writer.write(rowData, header, cellProcessors);
		} catch (IOException ex){
			throw new RuntimeException(ex);
		}
	}
}
