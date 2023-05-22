package fr.emile.model.implement;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.emile.common.Common;
import fr.emile.entity.CartItem;
import fr.emile.model.connect.DBConnect;
import fr.emile.model.interfaces.ICartItemDao;
import fr.emile.utils.Utils;

public final class CartItemDao implements ICartItemDao {

	@Override
	public CartItem create (CartItem cartItem)  throws Exception{
		Utils.trace("ici");
		Session session = DBConnect.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(cartItem);
			transaction.commit();


		} catch (Exception e) {

			Utils.trace("catch create "+ e.toString());
			if (transaction != null) {
				transaction.rollback();
			}

		} finally {
			Common.closeSession( session);

		}
		return cartItem;
	}
//------------------------------------------------------------------------------------------------
	@Override
	public CartItem read(int id) throws Exception {
		Session session = DBConnect.getSession();
		CartItem cartItem = null;
		try {
			cartItem= new CartItem();
			cartItem = session.find(CartItem.class, id);

		} catch (Exception e) {
			Utils.trace("catch Read " +e.toString());

		} finally {
			Common.closeSession( session);
		}

		return cartItem;
	}

	@Override
	public int update(CartItem cartItem) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(CartItem cartItem) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}


}
