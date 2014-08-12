package jp.co.foo.common.log;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class BeanInjector implements ApplicationContextAware {

	private static ApplicationContext context;
	
	public static final String DEFALUT_CONFIG_XML = "spring/bean-injector-context.xml";
	
	private static final Logger log = LoggerFactory.getLogger(BeanInjector.class);

	@Resource
	private CommonAnnotationBeanPostProcessor commonProcessor;

	@Autowired
	private AutowiredAnnotationBeanPostProcessor autowiredProcessor;

	public static ApplicationContext getContext() {
		return context;
	}
	
	public static BeanInjector getInstance(Class<?> callClazz) {
		if (context == null) {
			log.warn("contextがセットされる前にBeanInjectorが呼ばれた. [%s]", callClazz.getName());
			context = new ClassPathXmlApplicationContext(DEFALUT_CONFIG_XML);
		}
		return context.getBean(BeanInjector.class);
	}

	public void inject(final Object unmanagedBean) {
		commonProcessor.postProcessPropertyValues(null, null, unmanagedBean,
				unmanagedBean.getClass().getSimpleName());
		autowiredProcessor.processInjection(unmanagedBean);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.context.ApplicationContextAware#setApplicationContext
	 * (org.springframework.context.ApplicationContext)
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		BeanInjector.context = applicationContext;
	}
}
