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

		byte[] byteEncodePassFromByte = Code.encrypt(DEFAULT_TEXT.getBytes(CHARSET),PASS_KEY);
		byte[] byteEncodePass = Code.encrypt(DEFAULT_TEXT,PASS_KEY);

		byte[] byteEncodeBCFromByte = Code.encrypt(DEFAULT_TEXT.getBytes(CHARSET),BC_KEY);
		byte[] byteEncodeBC = Code.encrypt(DEFAULT_TEXT,BC_KEY);
		
		Code.deleteKey(); // delete key in order to force to get key from DB
		
		
		Utils.trace("------------------ using PASS encode ------------------------------");
		
		byte[] byteEncodePassResult = Code.decrypt(byteEncodePass,PASS_KEY);
		String stringPassResult= Code.decrypt2String(byteEncodePass,PASS_KEY);

		Utils.trace(DEFAULT_TEXT);
		Utils.trace(new String(byteEncodePassResult));
		Utils.trace(stringPassResult);
		byteEncodePassResult = Code.decrypt(byteEncodePassFromByte,PASS_KEY);
		stringPassResult= Code.decrypt2String(byteEncodePassFromByte,PASS_KEY);
		Utils.trace(new String(byteEncodePassResult));
		Utils.trace(stringPassResult);

		Utils.trace("------------------ using BC encode ------------------------------");

		byte[] byteEncodeBCResult = Code.decrypt(byteEncodeBC,BC_KEY);
		String stringBCResult= Code.decrypt2String(byteEncodeBC,BC_KEY);

		Utils.trace(DEFAULT_TEXT);
		Utils.trace(new String(byteEncodeBCResult));
		Utils.trace(stringBCResult);
		byteEncodeBCResult = Code.decrypt(byteEncodeBCFromByte,BC_KEY);
		stringBCResult= Code.decrypt2String(byteEncodeBCFromByte,BC_KEY);
		Utils.trace(new String(byteEncodeBCResult));
		Utils.trace(stringBCResult);

		Utils.trace(stringBCResult.equals(DEFAULT_TEXT) ? "bonne réponse" : "erreur code ");
		Utils.trace(stringPassResult.equals(DEFAULT_TEXT) ? "bonne réponse" : "erreur code ");
		
//	 tests below should generate exceptions 
		Code.deleteKey(); // delete key in order to force to get key from DB
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
