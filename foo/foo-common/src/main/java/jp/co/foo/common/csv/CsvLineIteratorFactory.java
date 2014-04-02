package jp.co.foo.common.csv;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

public class CsvLineIteratorFactory {
	
	protected char delimiter = ',';
	
	protected String encoding = "Windows-31J"; 
	
	protected long limitSize;

	public <T> CsvLineIterator<T> create(InputStream in) {
		
		Reader reader = new InputStreamReader(new BufferedInputStream(in), Charset.forName(encoding));
		return new CsvLineIterator<T>(reader, delimiter);
	}
	
	public <T> CsvLineIterator<T> create(MultipartFile file) throws IOException {
		
		if (file.getSize() > this.limitSize) {
			throw new MaxUploadSizeExceededException(limitSize);
		}
		InputStream in = file.getInputStream();
		
		return create(in);
	}
	
	public <T> CsvLineIterator<T> create(File file) throws IOException {
		
		if (file.length() > this.limitSize) {
			throw new MaxUploadSizeExceededException(limitSize);
		}
		
		InputStream in = FileUtils.openInputStream(file);
		
		return create(in);
	}	
}
