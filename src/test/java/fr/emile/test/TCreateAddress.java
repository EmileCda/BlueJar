package fr.emile.test;

import fr.emile.common.IConstant;
import fr.emile.entity.Address;
import fr.emile.entity.User;
import fr.emile.model.implement.AddressDao;
import fr.emile.model.implement.UserDao;
import fr.emile.model.interfaces.IAddressDao;
import fr.emile.model.interfaces.IUserDao;
import fr.emile.utils.DataTest;
import fr.emile.utils.Utils;

//*************** test result *********************************************************************
//check create user + insert in database (ok)
//check encript password : ok 
////*************** test result *********************************************************************
public class TCreateAddress implements IConstant {

	public static void main(String[] args) {

		Utils.trace("------------- start ----------------------");


		IAddressDao myAddressDao = new AddressDao();
		try {

			Address address = DataTest.genAddress();
			myAddressDao.create(address);

		} catch (Exception e) {
			Utils.trace("catch myAddressDao.create(address); ");
			e.printStackTrace();
		} 
		
		Utils.trace("------------- End ----------------------");

	}

}
