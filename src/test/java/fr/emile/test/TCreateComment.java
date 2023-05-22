package fr.emile.test;

import fr.emile.common.IConstant;
import fr.emile.entity.Comment;
import fr.emile.entity.Item;
import fr.emile.entity.User;
import fr.emile.model.implement.CommentDao;
import fr.emile.model.implement.ItemDao;
import fr.emile.model.implement.UserDao;
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
public class TCreateComment implements IConstant {

	public static void main(String[] args) {

		Utils.trace("------------- start ----------------------");
		int maxIndex = 30;
		int maxUserId = 10;
		int maxItemId = 10;
		
		ICommentDao myCommentDao = new CommentDao();
		try {

			for (int index = 1 ; index < maxIndex; index ++) {
				Comment comment = DataTest.genComment();
				
				
				User user = getUser(Utils.randInt(1, maxUserId));
				Item item = getItem(Utils.randInt(1, maxItemId));
				
				comment.setUser(user);
				comment.setItem(item);

				comment = myCommentDao.create(comment);
				if (comment != null)
					Utils.trace(comment.toString());
				
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
				Utils.trace("catch myItemDao.add(myItem) ");
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
