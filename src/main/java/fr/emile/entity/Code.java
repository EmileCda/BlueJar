package fr.emile.entity;

import fr.emile.common.IConstant;
import fr.emile.model.implement.ParamDao;
import fr.emile.model.interfaces.IParamDao;
import fr.emile.utils.Utils;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.spec.SecretKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;

//this class expose 4 public static methods
//1) ecrypte password
//2) ecrypte bankCard
//3) decrypte password
//4) decrypte bankcard

public final class Code implements IConstant {

	private static Param param = null;
	private static Key bcKey = null;
	private static Key passKey = null;

// this method is private for security purpose  
	private static Key generateKey(int keyLength, String algorythm) throws NoSuchAlgorithmException {

		KeyGenerator keyGen = KeyGenerator.getInstance(algorythm);
		SecureRandom secRandom = new SecureRandom();// Creating a SecureRandom object
		keyGen.init(secRandom); // : Initializing the KeyGenerator with random length

		return keyGen.generateKey(); // Creating/Generating a key

	}

// -------------------------------------------------------------------------------------------------

	private static Param getParamFromDB(int functionCode) {

		Param param = null;

		IParamDao myParamDao = new ParamDao();
		Utils.trace("getParamFromDB");
		try {
			param = myParamDao.readByFunctionCode(functionCode);

			if (param == null)
				Utils.trace("if (param == null ) ");

		} catch (Exception e) {

			Utils.trace("catch getKeyFromDB Exception " + e.toString());
		}

		return param;
	}

// -------------------------------------------------------------------------------------------------
	private static void saveParamToDB() {
		Utils.trace("saveParamToDB");

		IParamDao myParamDao = new ParamDao();
		try {

			if ((Code.bcKey != null) && (Code.passKey != null)) {
				Utils.trace("convert key to byte[]");
				byte[] blobKeyPass = Code.getKey(BC_KEY).getEncoded();
				byte[] blobKeyBC = Code.getKey(PASS_KEY).getEncoded();
				Param param = new Param(blobKeyPass, blobKeyBC, FUNCTION_KEY_DB, ALGORITHM, KEY_LENGTH);
				myParamDao.create(param);
			}

		} catch (Exception e) {
			Utils.trace("catch saveKeyToDB Exception " + e.toString());
		}

	}
	// -------------------------------------------------------------------------------------------------

	private static void setKey(Key key, int typeKey) {

		if (typeKey == PASS_KEY)
			Code.passKey = key;
		else if (typeKey == BC_KEY)
			Code.bcKey = key;
	}

// -------------------------------------------------------------------------------------------------
	// regular getter/setter
	private static Key getStaticKey(int typeKey) {

		if (typeKey == BC_KEY)
			return Code.bcKey;
		if (typeKey == PASS_KEY)
			return Code.passKey;
		else
			return null;

	}

	// -------------------------------------------------------------------------------------------------
	private static void initKey() {
		Param param = Code.getParamFromDB(FUNCTION_KEY_DB);
		Utils.trace("initKey() ");
		if (param == null) { // if null, generate new keys
			try {
				Utils.trace("param == null");

				Code.setKey(generateKey(KEY_LENGTH, ALGORITHM), PASS_KEY);
				Code.setKey(generateKey(KEY_LENGTH, ALGORITHM), BC_KEY);

				Code.saveParamToDB();

			} catch (NoSuchAlgorithmException e) {
				Utils.trace("catch initKey NoSuchAlgorithmException " + e.toString());
			}
		} else { // if keys exist in database
			Key key = new SecretKeySpec(param.getBankCardKey(), param.getAlgorythm());
			Code.setKey(key, BC_KEY);
			key = new SecretKeySpec(param.getPasswordKey(), param.getAlgorythm());
			Code.setKey(key, PASS_KEY);
		}
	}

	// -------------------------------------------------------------------------------------------------
	// looking for key if not exist locally then go get in database if not create a
	// new one
	private static Key getKey(int typeKey) {

		if (Code.getStaticKey(typeKey) == null) {
			Code.initKey();
		}
		return Code.getStaticKey(typeKey);

	}

	// -------------------------------------------------------------------------------------------------
	public static byte[] encrypt(String toEncrypt, int typeKey) {
		
		if ((toEncrypt != null) && (toEncrypt.length() > 0)) {

			byte[] messageByte = null;
			try {
				messageByte = toEncrypt.getBytes(CHARSET);
			} catch (UnsupportedEncodingException e) {
				Utils.trace("catch encryptBankCard :" + e.toString());
			}
			return encrypt(messageByte,typeKey);
		}
		return null ; 
	}

	// -------------------------------------------------------------------------------------------------
	public static byte[] encrypt(byte[] toEncrypt, int typeKey) {

		if (toEncrypt.length > 0) {
			try {
				Cipher cipher = Cipher.getInstance(ALGORITHM);
				cipher.init(Cipher.ENCRYPT_MODE, Code.getKey(typeKey));
				return cipher.doFinal(toEncrypt);
			} catch (InvalidKeyException e) {

				Utils.trace("catch encrypt InvalidKeyException " + e.toString());

			} catch (IllegalBlockSizeException e) {
				Utils.trace("catch encrypt IllegalBlockSizeException " + e.toString());
			} catch (BadPaddingException e) {
				Utils.trace("catch encrypt BadPaddingException " + e.toString());
			} catch (NoSuchAlgorithmException e) {
				Utils.trace("catch encrypt NoSuchAlgorithmException " + e.toString());
			} catch (NoSuchPaddingException e) {
				Utils.trace("catch encrypt NoSuchPaddingException " + e.toString());
			}
		}
		return null;

	}

	// -------------------------------------------------------------------------------------------------
public static String decrypt2String(byte[] toDecrypte, int typeKey) {
	
	return new String(Code.decrypt( toDecrypte,typeKey)) ;
		
}

// -------------------------------------------------------------------------------------------------
public static byte[] decrypt(byte[] toDecrypte, int typeKey) {

		Cipher cipher;
		byte[] result = null;
		try {
			cipher = Cipher.getInstance(ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, Code.getKey(typeKey));
			byte[] resultTemp = cipher.doFinal(toDecrypte);
			result = resultTemp;

		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			Utils.trace("catch decrypt NoSuchAlgorithmException | NoSuchPaddingException" + e.toString());
		} catch (InvalidKeyException e) {
			Utils.trace("catch encrypt InvalidKeyException " + e.toString());
		} catch (IllegalBlockSizeException e) {
			Utils.trace("catch encrypt IllegalBlockSizeException " + e.toString());
		} catch (BadPaddingException e) {
			Utils.trace("catch encrypt catch " + e.toString());
		}

		return result;
	}

	// -------------------------------------------------------------------------------------------------

}
