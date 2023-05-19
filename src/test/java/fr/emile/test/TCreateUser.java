package fr.emile.test;

import fr.emile.common.IConstant;
import fr.emile.entity.User;
import fr.emile.model.implement.UserDao;
import fr.emile.model.interfaces.IUserDao;
import fr.emile.utils.DataTest;
import fr.emile.utils.Utils;

//*************** test result *********************************************************************
//check create user + insert in database (ok)
//check encript password : ok 
////*************** test result *********************************************************************
public class TCreateUser implements IConstant {

	public static void main(String[] args) {

		Utils.trace("------------- start ----------------------");
		User myUser = new User();


		IUserDao myUserDao = new UserDao();
		try {

			for (int index = 0 ; index < 10; index ++) {
				myUser = DataTest.genUser();
				myUser.encrypt();
				myUser = myUserDao.create(myUser);
			}

		} catch (Exception e) {
			Utils.trace("catch myUserDao.add(myUser) ");
			e.printStackTrace();
		} 
		
		Utils.trace("------------- End ----------------------");

	}

}
