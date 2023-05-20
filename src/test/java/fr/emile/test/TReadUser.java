package fr.emile.test;

import java.util.Arrays;

import fr.emile.entity.User;
import fr.emile.model.implement.UserDao;
import fr.emile.model.interfaces.IUserDao;
import fr.emile.utils.DataTest;
import fr.emile.utils.Utils;

//*************** test result *********************************************************************
//check read user by id (ok)
//check decript password : ok 
////*************** test result *********************************************************************



public class TReadUser {
public static void main(String[] args) {
	
	Utils.trace("------------- start ----------------------");
	int userId = 1 ;
	User myUser = new User();
	
	IUserDao myUserDao = new UserDao();
	try {
		myUser = myUserDao.read(userId);
	} catch (Exception e) {
		Utils.trace("catch myUserDao.add(myUser) ");
		e.printStackTrace();
	}finally {
//		Utils.trace(myUser.toString());
		if (myUser != null) {

			myUser.decrypt();
			Utils.trace(myUser.toString());

		}else {
			Utils.trace("pas de useru id : "+ userId);
		}
		
		
	}
	Utils.trace("------------- End ----------------------");

	}
}
