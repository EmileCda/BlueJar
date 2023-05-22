package fr.emile.model.implement;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.emile.common.Common;
import fr.emile.entity.Order;
import fr.emile.model.connect.DBConnect;
import fr.emile.model.interfaces.IOrderDao;
import fr.emile.utils.Utils;

public class OrderDao implements IOrderDao {

	@Override
	public Order create(Order order) throws Exception {
		Session session = DBConnect.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			order.encode();
			session.save(order);
			transaction.commit();


		} catch (Exception e) {

			Utils.trace("catch create "+ e.toString());
			if (transaction != null) {
				transaction.rollback();
			}

		} finally {
			Common.closeSession( session);


		}
		return order;
	}

	@Override
	public Order read(int id) throws Exception {
		Session session = DBConnect.getSession();
		Order order = null;
		try {
			order= new Order();
			order = session.find(Order.class, id);
			order.decode();

		} catch (Exception e) {
			Utils.trace("catch Read " +e.toString());

		} finally {
			Common.closeSession( session);

		}

		return order;
	}

	@Override
	public int update(Order order) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Order order) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
