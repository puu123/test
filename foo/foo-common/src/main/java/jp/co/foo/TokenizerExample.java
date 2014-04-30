package jp.co.foo;

import org.atilika.kuromoji.Token;
import org.atilika.kuromoji.Tokenizer;

public class TokenizerExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        Tokenizer tokenizer = Tokenizer.builder().build();
        for (Token token : tokenizer.tokenize("株式会社東京UFJ三菱システム 本橋聡")) {
            System.out.println(token.getSurfaceForm() + "\t" + token.getAllFeatures());
        }

	}

}
