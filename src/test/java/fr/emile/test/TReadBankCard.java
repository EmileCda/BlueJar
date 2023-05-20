package fr.emile.test;

import fr.emile.entity.BankCard;
import fr.emile.model.implement.BankCardDao;
import fr.emile.model.interfaces.IBankCardDao;
import fr.emile.utils.DataTest;
import fr.emile.utils.Utils;

//*************** test result *********************************************************************
//check read user by id (ok)
//check decript password : ok 
////*************** test result *********************************************************************



public class TReadBankCard {
public static void main(String[] args) {
	
	Utils.trace("------------- start ----------------------");
	int id = 2 ;
	BankCard bankCard=  new BankCard();
	
	IBankCardDao myBankCardDao = new BankCardDao();
	try {
		bankCard = myBankCardDao.read(id);
	} catch (Exception e) {
		Utils.trace("catch myUserDao.add(myUser) ");
		e.printStackTrace();
	}finally {
		Utils.trace(bankCard.toString());
		bankCard.decrypt();
		Utils.trace(bankCard.toString());
		
	}
	Utils.trace("------------- End ----------------------");

	}
}
