package jp.co.foo.common.log;

public final class LogFactory {
		
	private LogFactory(){}
	
	public static Log getLog(Class<?> clazz) {
		
		LogImpl log = new LogImpl(clazz);
		BeanInjector.getInstance(clazz).inject(log);
		
		return log;
	}
}
