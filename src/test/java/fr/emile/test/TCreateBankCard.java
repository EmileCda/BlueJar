package fr.emile.test;

import fr.emile.common.IConstant;
import fr.emile.entity.BankCard;
import fr.emile.model.implement.BankCardDao;
import fr.emile.model.interfaces.IBankCardDao;
import fr.emile.utils.DataTest;
import fr.emile.utils.Utils;

//*************** test result *********************************************************************
// link to user desactivated
//check create bankcard + insert in database 
//check encript cardnumber + crypto : ok 
////*************** test result *********************************************************************
public class TCreateBankCard implements IConstant {

	public static void main(String[] args) {

		Utils.trace("------------- start ----------------------");


		IBankCardDao myBankCardDao = new BankCardDao();
		try {
			BankCard bankCard= DataTest.genBankCardNoName();
			Utils.trace(bankCard.toString());
			Utils.trace(String.format("%b", bankCard.isValid()));
			myBankCardDao.create(bankCard);
			if (bankCard != null )
				Utils.trace(bankCard.toString());

		} catch (Exception e) {
			Utils.trace("catch myBankCardDao.create(bankCard); "+e.toString());
			e.printStackTrace();
		} 
		
		Utils.trace("------------- End ----------------------");

	}

}
