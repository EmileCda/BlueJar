package fr.emile.model.implement;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.emile.common.Common;
import fr.emile.entity.Address;
import fr.emile.entity.OrderLine;
import fr.emile.model.connect.DBConnect;
import fr.emile.model.interfaces.IOrderLineDao;
import fr.emile.utils.Utils;

public class OrderLineDao implements IOrderLineDao {

	@Override
	public OrderLine create(OrderLine orderLine) throws Exception {
		Session session = DBConnect.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(orderLine);
			transaction.commit();


		} catch (Exception e) {

			Utils.trace("catch create "+ e.toString());
			if (transaction != null) {
				transaction.rollback();
			}

		} finally {
			Common.closeSession( session);

		}
		return orderLine;
	}

	@Override
	public OrderLine read(int id) throws Exception {
		Session session = DBConnect.getSession();
		OrderLine orderLine = null;
		try {
			orderLine= new OrderLine();
			orderLine = session.find(OrderLine.class, id);
		} catch (Exception e) {
			Utils.trace("catch Read " +e.toString());

		} finally {
			Common.closeSession( session);
		}

		return orderLine;
	}

	@Override
	public int update(OrderLine orderLine) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(OrderLine orderLine) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
