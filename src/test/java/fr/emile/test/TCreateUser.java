package fr.emile.test;

import java.util.Arrays;

import fr.emile.common.IConstant;
import fr.emile.entity.Address;
import fr.emile.entity.Code;
import fr.emile.entity.User;
import fr.emile.model.implement.UserDao;
import fr.emile.model.interfaces.IUserDao;
import fr.emile.utils.DataTest;
import fr.emile.utils.Utils;

//*************** test result *********************************************************************
//check create user + insert in database (ok)
//check encript password : ok 
// check 1 address ok
// check list address ok 
////*************** test result *********************************************************************
public class TCreateUser implements IConstant {

	public static void main(String[] args) {

		Utils.trace("------------- start ----------------------");
		User myUser = new User();
		int maxUser = 10;

		IUserDao myUserDao = new UserDao();
		try {

			for (int index = 0 ; index < maxUser; index ++) {
				myUser = new User( DataTest.genUser());
				int maxAddress = Utils.randInt(0, 4);
				
				for (int indice = 1 ; indice <= maxAddress ; indice++)
				{
					Address address = DataTest.genAddress();
					myUser.addAddress(address);
				}
				String clearPass = myUser.getClearPass();
				myUser.encrypt();
				myUser.setClearPass("zapper");
				myUser = myUserDao.create(myUser);
				Code.deleteKey();
				myUser.decrypt();
				
				Utils.trace(clearPass.equals(myUser.getClearPass())?"ok" : "erreur*********************************" );

				Utils.trace(myUser.toString());
			}

		} catch (Exception e) {
			Utils.trace("catch myUserDao.add(myUser) " + e.toString());
		} 
		
		Utils.trace("------------- End ----------------------");

	}

}
