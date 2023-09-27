package fr.emile.test;

import fr.emile.common.IConstant;
import fr.emile.entity.Address;
//import fr.emile.entity.Address;
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
public class TCreateUser implements IConstant {

	public static void main(String[] args) {

		Utils.trace("------------- start ----------------------");
		User myUser = new User();


		IUserDao myUserDao = new UserDao();
		try {

			for (int index = 0 ; index < 10; index ++) {
				myUser = new User( DataTest.genUser());
				
				myUser = addAddress(myUser );
				myUser = addBankCard(myUser );
					
				myUser = myUserDao.create(myUser);
			}

		} catch (Exception e) {
			Utils.trace("catch myUserDao.add(myUser) ");
			e.printStackTrace();
		} 
		
		Utils.trace("------------- End ----------------------");

	}
	//-------------------------------------------------------------------------------------------------
		public static User addBankCard(User myUser) {
			
			int max = Utils.randInt(1, 4);
			
			for (int indice = 1 ; indice <= max ; indice++)
			{
				BankCard bankCard= DataTest.genBankCardNoName();
				myUser.addBankCard (bankCard);
				Utils.trace(bankCard.toString());
			}
			
			return myUser;
			
		}
		//-------------------------------------------------------------------------------------------------
		public static User addComment(User myUser, Item myItem) {
			
				Comment comment= DataTest.genComment();
				myUser.addComment(comment);
				myItem.addComment(comment);
			
			return myUser;
			
		}
		//-------------------------------------------------------------------------------------------------
		public static User addAddress(User myUser) {
			
			int maxAddress = Utils.randInt(1, 4);
			
			for (int indice = 1 ; indice <= maxAddress ; indice++)
			{
				Address address = DataTest.genAddress();
				myUser.addAddress(address);
			}
			
			return myUser;
			
		}
	//-------------------------------------------------------------------------------------------------
	
}
