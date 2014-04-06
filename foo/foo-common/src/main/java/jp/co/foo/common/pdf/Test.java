package jp.co.foo.common.pdf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfSignatureAppearance;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

public class Test {

	public static void main(String[] args) {
		try {
			exec2();
		} catch (UnrecoverableKeyException e) {
			e.printStackTrace();
		} catch (KeyStoreException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (CertificateException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	public static void exec2() throws KeyStoreException,
			NoSuchAlgorithmException, CertificateException,
			FileNotFoundException, IOException, UnrecoverableKeyException,
			DocumentException {

		KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
		ks.load(new FileInputStream(
				"C:\\Program Files\\Java\\jdk1.6.0_45\\bin\\keystore.ks"),
				"mokemoke".toCharArray());
		String alias = (String) ks.aliases().nextElement();
		PrivateKey key = (PrivateKey) ks.getKey(alias, "password".toCharArray());
		Certificate[] chain = ks.getCertificateChain(alias);

		PdfReader reader = new PdfReader("c:\\dev\\test.pdf");
		FileOutputStream fout = new FileOutputStream("c:\\dev\\signed.pdf");
		PdfStamper stp = PdfStamper.createSignature(reader, fout, '\0');
		//stp.s
		PdfSignatureAppearance sap = stp.getSignatureAppearance();
		stp.setEncryption(true,null,"password",PdfWriter.AllowPrinting);
		//sap.setCertificate(chain[0]);
		//sap.setCrypto(privKey, certChain, crlList, filter);
		sap.setCrypto(key, chain, null, PdfSignatureAppearance.SELF_SIGNED);
		sap.setReason("I'm the author");
		sap.setLocation("Tokyo");
		// comment next line to have an invisible signature
		sap.setVisibleSignature(new Rectangle(100, 100, 200, 200), 1, null);
		stp.close();
	}
}
