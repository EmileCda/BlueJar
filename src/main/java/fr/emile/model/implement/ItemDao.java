package fr.emile.model.implement;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.emile.common.Common;
import fr.emile.entity.Item;
import fr.emile.entity.Item;
import fr.emile.model.connect.DBConnect;
import fr.emile.model.interfaces.IItemDao;
import fr.emile.utils.Utils;

public final class ItemDao implements IItemDao {


	@Override
	public Item create(Item item) throws Exception {
		Session session = DBConnect.getSession();
		Transaction transaction = null;
		try {
			
			transaction = session.beginTransaction();
			session.save(item);
			transaction.commit();


		} catch (Exception e) {

			Utils.trace("catch create "+ e.toString());
			if (transaction != null) {
				transaction.rollback();
			}

		} finally {
			Common.closeSession( session);

		}
		return item;
	
	}

	@Override
	public Item read(int id) throws Exception {
		Session session = DBConnect.getSession();
		Item item = null;
		try {
			item= new Item();
			item = session.find(Item.class, id);

		} catch (Exception e) {
			Utils.trace("catch Read " +e.toString());

		} finally {
			Common.closeSession( session);
		}

		return item;
	}

	@Override
	public int update(Item item) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Item item) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
