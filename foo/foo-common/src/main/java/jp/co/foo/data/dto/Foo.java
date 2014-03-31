package jp.co.foo.data.dto;

import jp.co.foo.common.dto.AbstractDto;

public class Foo extends AbstractDto {
	
	protected String name;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
