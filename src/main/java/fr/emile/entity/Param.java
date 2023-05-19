package fr.emile.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;

import fr.emile.common.IConstant;

@Entity
@Table(name = "param")
public final class Param implements IConstant, Serializable {

	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id; 
	@Column(name = "password_key",nullable = false)
	private byte[] passwordKey ;
	@Column(name = "bankcard_key",nullable = false)
	private byte[] bankCardKey ;
	@Column(name = "function_code",nullable = false, unique = true)
	private int	functionCode;
	@Column(name = "key_length",nullable = false)
	private int	keyLength;
	private String algorythm;
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_modification",nullable = false)
	private Date lastModification;

	
	
	public Param() {
		this(DEFAULT_ID, null, null,DEFAULT_FUNCTION_CODE,DEFAULT_ALGORYTHM,KEY_LENGTH);
		
	}
	
	public Param( byte[] passwordKey, byte[] bankCardKey, int functionCode, String algorythm , int keyLength) {
		
		this (DEFAULT_ID,passwordKey, bankCardKey, functionCode, algorythm , keyLength);
	}

	public Param(int id, byte[] passwordKey, byte[] bankCardKey, int functionCode, String algorythm , int keyLength) {
		this.setId ( id);
		this.setPasswordKey(passwordKey);
		this.setBankCardKey(bankCardKey); 
		this.setFunctionCode(functionCode);
		this.setAlgorythm ( algorythm);
		this.setKeyLength(keyLength);
	}


	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public byte[] getPasswordKey() {
		return this.passwordKey;
	}
	public void setPasswordKey(byte[] passwordKey) {
		this.passwordKey = passwordKey;
	}
	public byte[] getBankCardKey() {
		return this.bankCardKey;
	}
	public void setBankCardKey(byte[] bankCardKey) {
		this.bankCardKey = bankCardKey;
	}


	public int getFunctionCode() {
		return this.functionCode;
	}


	public void setFunctionCode(int functionCode) {
		this.functionCode = functionCode;
	}


	public String getAlgorythm() {
		return this.algorythm;
	}


	public void setAlgorythm(String algorythm) {
		this.algorythm = algorythm;
	}


	public int getKeyLength() {
		return keyLength;
	}


	public void setKeyLength(int keyLength) {
		this.keyLength = keyLength;
	}
	
	
	
}
