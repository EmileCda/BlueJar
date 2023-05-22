package fr.emile.test;

import fr.emile.entity.Item;
import fr.emile.entity.User;
import fr.emile.model.implement.ItemDao;
import fr.emile.model.implement.UserDao;
import fr.emile.model.interfaces.IItemDao;
import fr.emile.model.interfaces.IUserDao;
import fr.emile.utils.DataTest;
import fr.emile.utils.Utils;

//*************** test result *********************************************************************
//check read user by id (ok)
//check decript password : ok 
////*************** test result *********************************************************************

public class TReadItem {
	public static void main(String[] args) {

		Utils.trace("------------- start ----------------------");
		int itemId = 1;
		Item myItem = new Item();

		IItemDao myItemDao = new ItemDao();
		try {
			myItem = myItemDao.read(itemId);
		} catch (Exception e) {
			Utils.trace("catch myItemDao.read(myItem) ");
			e.printStackTrace();
		} finally {
			if (myItem != null) {
				Utils.trace(myItem.toString());
			} else {
				Utils.trace("myItem is null");
			}
		}
		Utils.trace("------------- End ----------------------");

	}

}
