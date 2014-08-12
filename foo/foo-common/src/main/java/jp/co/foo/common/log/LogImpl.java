package jp.co.foo.common.log;

import jp.co.foo.common.constant.Code;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;


public class LogImpl implements Log {
	
	@Autowired
	MessageSource messageSource;
	
	Logger log;
	
	LogImpl(Class<?> clazz) {
		log = LoggerFactory.getLogger(clazz);
	}


	/* (non-Javadoc)
	 * @see jp.co.foo.common.log.Log#info(java.lang.String, java.lang.Object[])
	 */
	@Override
	public void info(Code code, Object... args) {
	System.out.println(messageSource);
	System.out.println(messageSource.getMessage("MESSAGE_CODE_FOR_SYSTEM_ERROR", null, null));
	}

	/* (non-Javadoc)
	 * @see jp.co.foo.common.log.Log#warn(java.lang.String, java.lang.Object[])
	 */
	@Override
	public void warn(Code code, Object... args) {
		
	}

	/* (non-Javadoc)
	 * @see jp.co.foo.common.log.Log#error(java.lang.Throwable)
	 */
	@Override
	public void error(Throwable t) {
	}

	/* (non-Javadoc)
	 * @see jp.co.foo.common.log.Log#error(java.lang.Throwable, java.lang.String, java.lang.Object[])
	 */
	@Override
	public void error(Throwable t, Code code, Object... args) {
	}

	/* (non-Javadoc)
	 * @see jp.co.foo.common.log.Log#error(java.lang.String, java.lang.Object[])
	 */
	@Override
	public void error(Code code, Object... args) {
	}

}
