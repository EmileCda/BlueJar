package fr.emile.model.implement;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.emile.common.Common;
import fr.emile.entity.Address;
import fr.emile.entity.Category;
import fr.emile.entity.Category;
import fr.emile.model.connect.DBConnect;
import fr.emile.model.interfaces.IAddressDao;
import fr.emile.model.interfaces.ICategoryDao;
import fr.emile.utils.Utils;

public final class CategoryDao implements ICategoryDao {

	@Override
	public Category create(Category category) throws Exception {
		Session session = DBConnect.getSession();
		Transaction transaction = null;
		try {
			
			transaction = session.beginTransaction();
			
			session.save(category);
			transaction.commit();


		} catch (Exception e) {

			Utils.trace("catch create "+ e.toString());
			if (transaction != null) {
				transaction.rollback();
			}

		} finally {
			Common.closeSession( session);

		}
		return category;
	}

	@Override
	public Category read(int id) throws Exception {
		Session session = DBConnect.getSession();
		Category category = null;
		try {
			category= new Category();
			category = session.find(Category.class, id);

		} catch (Exception e) {
			Utils.trace("catch Read " +e.toString());

		} finally {
			Common.closeSession( session);
		}

		return category;
	}

	@Override
	public int update(Category category) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Category category) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}



}
