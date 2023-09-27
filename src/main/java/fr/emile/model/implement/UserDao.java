package fr.emile.model.implement;


import fr.emile.common.Common;
import fr.emile.entity.User;
import fr.emile.model.interfaces.IUserDao;
import fr.emile.utils.Utils;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import fr.emile.model.connect.DBConnect;

public final class UserDao implements IUserDao {

	@Override
	public User create(User user) throws Exception {
		Session session = DBConnect.getSession();
		Transaction transaction = null;
		try {
			
			if (user != null)
				user.encrypt();
			transaction = session.beginTransaction();
			
			session.save(user);
			transaction.commit();


		} catch (Exception e) {

			Utils.trace("catch create "+ e.toString());
			if (transaction != null) {
				transaction.rollback();
			}

		} finally {
			Common.closeSession( session);

		}
		return user;
	}
//-------------------------------------------------------------------------------------------------

	@Override
	public User read(int id) throws Exception {
		Session session = DBConnect.getSession();
		User user = null;
		try {
			user= new User();
			user = session.find(User.class, id);
			if (user != null)
				user.decrypt();

		} catch (Exception e) {
			Utils.trace("catch Read " +e.toString());

		} finally {
			Common.closeSession( session);
		}

		return user;
	}
//-------------------------------------------------------------------------------------------------
	@Override
	public int update(User user) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(User user) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	//-------------------------------------------------------------------------------------------------
	@Override
	public User read(String email) throws Exception {
		
		Utils.trace("read(String email) " + email);
		Session session = DBConnect.getSession();
		User user = null;
		try {
			user= new User();
			Query<User> query = session.createQuery("FROM User WHERE email = :email", User.class);
			query.setParameter("email", email);
			user = query.uniqueResult();
			if (user != null)
				user.decrypt();

		} catch (Exception e) {
			Utils.trace("catch Read " +e.toString());

		} finally {
			Common.closeSession( session);
		}

		return user;
	}

}
