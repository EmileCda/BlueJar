package fr.emile.model.implement;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.emile.common.Common;
import fr.emile.entity.Comment;
import fr.emile.model.connect.DBConnect;
import fr.emile.model.interfaces.ICommentDao;
import fr.emile.utils.Utils;

public class CommentDao implements ICommentDao {

	@Override
	public Comment create(Comment comment) throws Exception {
		Session session = DBConnect.getSession();
		Transaction transaction = null;
		try {
			
			transaction = session.beginTransaction();
			session.save(comment);
			transaction.commit();

		} catch (Exception e) {

			Utils.trace("catch create "+ e.toString());
			if (transaction != null) {
				transaction.rollback();
			}

		} finally {
			Common.closeSession( session);

		}
		return comment;
	}

	@Override
	public Comment read(int id) throws Exception {
		Session session = DBConnect.getSession();
		Comment comment = null;
		try {
			comment= new Comment();
			comment = session.find(Comment.class, id);

		} catch (Exception e) {
			Utils.trace("catch Read " +e.toString());

		} finally {
			Common.closeSession( session);
		}

		return comment;
	}

	@Override
	public int update(Comment comment) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Comment comment) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
