package fr.emile.test;

import fr.emile.common.IConstant;
import fr.emile.entity.CartItem;
import fr.emile.entity.Comment;
import fr.emile.entity.Item;
import fr.emile.entity.User;
import fr.emile.model.implement.CartItemDao;
import fr.emile.model.implement.CommentDao;
import fr.emile.model.implement.ItemDao;
import fr.emile.model.implement.UserDao;
import fr.emile.model.interfaces.ICartItemDao;
import fr.emile.model.interfaces.ICommentDao;
import fr.emile.model.interfaces.IItemDao;
import fr.emile.model.interfaces.IUserDao;
import fr.emile.utils.DataTest;
import fr.emile.utils.Utils;

//*************** test result *********************************************************************
// link to catégory desactivated ** reminder **************  
//check create comment + insert in database  : ok 
//
////*************** test result *********************************************************************
public class TCreateCartItem implements IConstant {

	public static void main(String[] args) {

		Utils.trace("------------- start ----------------------");
		int maxIndex = 30;
		int maxUserId = 10;
		int maxItemId = 10;
		int maxQuantity= 10;
		
		
		ICartItemDao myCartItemDao = new CartItemDao();
		try {

			for (int index = 0 ; index < maxIndex; index ++) {
				Utils.trace("------------- start ----------------------");
				CartItem cartItem = new CartItem(Utils.randInt(1, maxQuantity));
				
				
				User user = getUser(Utils.randInt(1, maxUserId));
				Item item = getItem(Utils.randInt(1, maxItemId));
				
				cartItem .setUser(user);
				cartItem .setItem(item);

				cartItem  = myCartItemDao.create(cartItem );
				if (cartItem != null)
					Utils.trace(cartItem.toString());
				
			}

		} catch (Exception e) {
			Utils.trace("catch myCommentDao.create(comment); " + e.toString());
			e.printStackTrace();
		}

		Utils.trace("------------- End ----------------------");

	}
	//-------------------------------------------------------------------------------------------------
		public static Item getItem(int id) {
			Item myItem = new Item();

			IItemDao myItemDao = new ItemDao();
			try {
				myItem = myItemDao.read(id);
			} catch (Exception e) {
				Utils.trace("catch myItemDao.read(myItem) ");
				e.printStackTrace();
			} 
			return myItem;
		}
		//-------------------------------------------------------------------------------------------------
			public static User getUser(int id) {

		User myUser = new User();

		IUserDao myUserDao = new UserDao();
		try {
			myUser = myUserDao.read(id);
		} catch (Exception e) {
			Utils.trace("catch myUserDao.add(myUser) ");
			e.printStackTrace();
		} 
		
		return myUser;

	}
//-------------------------------------------------------------------------------------------------

}
