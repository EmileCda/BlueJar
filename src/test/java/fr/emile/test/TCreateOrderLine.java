package fr.emile.test;

import fr.emile.common.IConstant;
import fr.emile.entity.OrderLine;
import fr.emile.entity.Comment;
import fr.emile.entity.Item;
import fr.emile.entity.Order;
import fr.emile.entity.User;
import fr.emile.model.implement.OrderLineDao;
import fr.emile.model.implement.CommentDao;
import fr.emile.model.implement.ItemDao;
import fr.emile.model.implement.OrderDao;
import fr.emile.model.implement.UserDao;
import fr.emile.model.interfaces.IOrderLineDao;
import fr.emile.model.interfaces.ICommentDao;
import fr.emile.model.interfaces.IItemDao;
import fr.emile.model.interfaces.IOrderDao;
import fr.emile.model.interfaces.IUserDao;
import fr.emile.utils.DataTest;
import fr.emile.utils.Utils;

//*************** test result *********************************************************************
// link to catégory desactivated ** reminder **************  
//check create comment + insert in database  : ok 
//
////*************** test result *********************************************************************
public class TCreateOrderLine implements IConstant {

	public static void main(String[] args) {

		Utils.trace("------------- start ----------------------");
		int maxIndex = 10;
		int maxUserId = 10;
		int maxItemId = 10;
		int maxQuantity = 10;

		IOrderLineDao myOrderLineDao = new OrderLineDao();
		try {

			for (int index = 0; index < maxIndex; index++) {

				Order order = getOrder(Utils.randInt(1, maxUserId));
//				Item item = getItem(1);
				Item item = getItem(Utils.randInt(1, maxItemId));

				OrderLine orderLine = new OrderLine(Utils.randInt(1, maxQuantity), order, item);

				orderLine = myOrderLineDao.create(orderLine);
				if (orderLine != null)
					Utils.trace(orderLine.toString());

			}

		} catch (Exception e) {
			Utils.trace("catch myCommentDao.create(comment); " + e.toString());
			e.printStackTrace();
		}

		Utils.trace("------------- End ----------------------");

	}

	// -------------------------------------------------------------------------------------------------
	public static Order getOrderZ(int userId) {

		User user = getUser(userId);

		int orderCount = user.getOrderList().size();

		return user.getOrderList().get(Utils.randInt(0, orderCount));

	}

	// -------------------------------------------------------------------------------------------------
	public static Order getOrder(int id) {
		Order myOrder = new Order();

		IOrderDao myOrderDao = new OrderDao();
		try {
			myOrder = myOrderDao.read(id);
		} catch (Exception e) {
			Utils.trace("catch myOrderDao.read(myItem) ");
			e.printStackTrace();
		}
		return myOrder;
	}

	// -------------------------------------------------------------------------------------------------
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

	// -------------------------------------------------------------------------------------------------
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
