package jp.co.foo.common.exception;



/**
 * アプリケーション例外。
 *
 */
public class ApplicationException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    
    
    private String code;
    private Object[] arguments;
    private String defaultMessage;

    // =================================================
    // コンストラクタ
    // =================================================

    /**
     * コンストラクタ。
     * 
     * @param code メッセージコード
     * @param arguments 引数
     */
    public ApplicationException(String code, Object... arguments) {
	this.code = code;
	this.arguments = arguments;
    }

    /**
     * コンストラクタ
     * 
     * @param defaultMessage デフォルトメッセージ
     * @param code メッセージコード
     * @param arguments 引数
     */
    public ApplicationException(
            String defaultMessage, String code, Object... arguments) {
	super(defaultMessage);
	this.code = code;
	this.arguments = arguments;
    }

    /**
     * コンストラクタ。
     * 
     * @param cause 原因となった例外
     * @param code メッセージコード
     * @param arguments 引数
     */
    public ApplicationException(
            Throwable cause, String code, Object... arguments) {
	super(cause.getMessage(), cause);
	this.code = code;
	this.arguments = arguments;
    }

    /**
     * コンストラクタ。
     * 
     * @param defaultMessage デフォルトメッセージ
     * @param cause 原因となった例外
     * @param code メッセージコード
     * @param arguments 引数
     */
    public ApplicationException(
            String defaultMessage, Throwable cause,
            String code, Object... arguments) {
	super(defaultMessage ,cause);
	this.code = code;
	this.arguments = arguments;
    }

    public ApplicationException() {
    }

    // =================================================
    // プロパティ
    // =================================================


    /**
     * メッセージコードを返します。
     */
    public String getMessageCode() {
        return this.code;
    }
    /**
     * 
     */
    public Object[] getMessageArguments(){
	return this.arguments;
    }

}
