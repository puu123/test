package jp.co.foo.common.csv;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

import com.Ostermiller.util.ExcelCSVPrinter;

public abstract class AbstractCsvView extends AbstractView {

	protected String fileName;
	
	protected ExcelCSVPrinter printer;

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	@Override
	protected void prepareResponse(HttpServletRequest req,
			HttpServletResponse res) {
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"", fileName);
		res.setContentType("text/csv");
		res.setHeader(headerKey, headerValue);
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest req, HttpServletResponse res)
			throws Exception {
//        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
//                CsvPreference.STANDARD_PREFERENCE);
// 
//        buildCsvDocument(csvWriter, model);
//        csvWriter.close();
		
	}
	
	/**
     * The concrete view must implement this method.
     */
    protected abstract void buildCsvDocument(ExcelCSVPrinter printer,
            Map<String, Object> model) throws IOException;
}
