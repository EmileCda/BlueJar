package fr.emile.model.implement;


import fr.emile.entity.User;
import fr.emile.model.interfaces.IUserDao;
import fr.emile.utils.Utils;

import org.hibernate.Session;
import org.hibernate.Transaction;
import fr.emile.model.connect.DBConnect;

public class UserDao implements IUserDao {

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
			this.closeSession( session);

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
			this.closeSession( session);
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

	private void closeSession(Session session) {

		// session will be close by the end of the application		
//				if (session != null && session.isOpen())
//					session.close();
				
			}

}
