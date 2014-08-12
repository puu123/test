package jp.co.foo.common.log;

import jp.co.foo.common.constant.Code;

public interface Log {


	/**
	 * 情報ログを出力します。
	 * 
	 * @param code メッセージのコード
	 * @param args メッセージ生成のためのパラメータ
	 */
	void info(Code code, Object... args);

	/**
	 * 警告ログを出力します。
	 * 
	 * @param code メッセージのコード
	 * @param args メッセージ生成のためのパラメータ
	 */
	void warn(Code code, Object... args);

	/**
	 * エラーログを出力します。
	 * <p>
	 * ログのメッセージは、
	 * <nl>
	 * <li>例外がApplicationExceptionの場合、そのMessageを使います
	 * <li>それ以外の例外の場合は、システムエラーのメッセージを使います
	 * </nl>
	 * 
	 * @param t
	 *            発生した例外（スタックトレースへ出力と、メッセージの取得）
	 */
	void error(Throwable t);

	/**
	 * エラーログを出力します。
	 * 
	 * @param t
	 *            例外（スタックトレースへ出力）
	 * @param code メッセージのコード
	 * @param args メッセージ生成のためのパラメータ
	 */
	void error(Throwable t, Code code, Object... args);

	/**
	 * エラーログを出力します。
	 * 
	 * @param code メッセージのコード
	 * @param args メッセージ生成のためのパラメータ
	 */
	void error(Code code, Object... args);
}
