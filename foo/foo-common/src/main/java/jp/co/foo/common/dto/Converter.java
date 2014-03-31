/**
 * 
 */
package jp.co.foo.common.dto;

public interface Converter {
	<T> T to(Object source, Class<?> sourceClass, Class<T> destinationClass);
}
