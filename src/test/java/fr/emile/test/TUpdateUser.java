package fr.emile.test;

import fr.emile.common.IConstant;
import fr.emile.entity.Address;
import fr.emile.entity.BankCard;
import fr.emile.entity.Comment;
import fr.emile.entity.Item;
import fr.emile.entity.User;
import fr.emile.model.implement.UserDao;
import fr.emile.model.interfaces.IUserDao;
import fr.emile.utils.DataTest;
import fr.emile.utils.Utils;

//*************** test result *********************************************************************
//check create user + insert in database (ok)
//check encript password : ok 
//check 1 address ok
//check list address ok 
// check create bank card : ok
//check add bank card ok
//check add bank card + encrypt :ok

////*************** test result *********************************************************************
public class TUpdateUser implements IConstant {

	public static void main(String[] args) {

		Utils.trace("------------- start ----------------------");
		int idUser = 12;
		User user = getUser(idUser);
//		user = addOrder(user);
		
		
		
		Utils.trace("------------- End ----------------------");

	}

// -------------------------------------------------------------------------------------------------
	public static User addOrder(User user) {

//		Item item = 
		
		return user;

	}

// -------------------------------------------------------------------------------------------------
	public static User getUser(int Id) {

		User myUser = new User();

		IUserDao myUserDao = new UserDao();
		try {
			myUser = myUserDao.read(Id);
		} catch (Exception e) {
			Utils.trace("catch myUserDao.add(myUser) ");
			e.printStackTrace();
		} finally {
			if (myUser != null) {
				Utils.trace("\n" + myUser.toString());
			} else {
				Utils.trace("myUser is null");
			}
		}
		return myUser;
	}
//-------------------------------------------------------------------------------------------------

}
