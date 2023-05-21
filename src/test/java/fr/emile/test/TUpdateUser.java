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
		int userId = 1;
		User myUser = new User();

		IUserDao myUserDao = new UserDao();
		try {
			myUser = myUserDao.read(userId);
		} catch (Exception e) {
			Utils.trace("catch myUserDao.add(myUser) ");
			e.printStackTrace();
		} finally {
			if (myUser != null) {
				Utils.trace(myUser.toString());
				myUser.decrypt();
				Utils.trace(myUser.toString());
			} else {
				Utils.trace("myUser is null");
			}
		}
		Utils.trace("------------- End ----------------------");

	}
	//-------------------------------------------------------------------------------------------------

		//-------------------------------------------------------------------------------------------------
		public static User addAddress(User myUser) {
			
			int maxAddress = Utils.randInt(0, 4);
			
			for (int indice = 1 ; indice <= maxAddress ; indice++)
			{
				Address address = DataTest.genAddress();
				myUser.addAddress(address);
			}
			
			return myUser;
			
		}
	//-------------------------------------------------------------------------------------------------
	
}
