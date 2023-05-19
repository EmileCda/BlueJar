package fr.emile.test;

import java.io.UnsupportedEncodingException;

import fr.emile.common.IConstant;
import fr.emile.entity.Code;
import fr.emile.utils.DataTest;
import fr.emile.utils.Utils;

//+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
// this test should validate :
// encryption and decrytpion 
// generate new key retreive key and save key in database
// exception if key is not correct 
// tested and validated
//+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+

public class TEncryptDecryptDB implements IConstant {

	public static void main(String[] args) throws UnsupportedEncodingException {

		byte[] byteEncodePass = Code.encrypt(DEFAULT_TEXT.getBytes(CHARSET),PASS_KEY);

		byte[] byteEncodePassResult = Code.decrypt(byteEncodePass,PASS_KEY);

		Utils.trace(DEFAULT_TEXT);
		Utils.trace(new String(byteEncodePassResult));

		
		
		byte[] byteEncodeBC = Code.encrypt(DEFAULT_TEXT.getBytes(CHARSET),BC_KEY);

		byte[] byteEncodeBCResult = Code.decrypt(byteEncodeBC,BC_KEY);

		Utils.trace(DEFAULT_TEXT);
		Utils.trace(new String(byteEncodeBCResult));

//	 tests below should generate an exception 
		try {
			Utils.trace(new String(Code.decrypt(byteEncodePass,BC_KEY)));
		} catch (Exception e) {
			Utils.trace("error swapping key " + e.toString());

		}
		try {
			Utils.trace(new String(Code.decrypt(byteEncodeBC,PASS_KEY)));

		} catch (Exception e) {
			Utils.trace("error swapping key " + e.toString());
		}

	}

}
