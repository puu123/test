package jp.co.foo.common.constant;

public enum MessageCode implements Code {
	E_0001("");
	private String code;
	private MessageCode(String code){}
	
	public String toCode(){
		return code;
	}
}
