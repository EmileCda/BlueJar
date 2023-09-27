package fr.emile.model.implement;

import fr.emile.common.Common;
import fr.emile.entity.Param ;
import fr.emile.model.connect.DBConnect;
import fr.emile.model.interfaces.IParamDao;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import fr.emile.utils.Utils;

public final class ParamDao implements IParamDao{

	@Override
	public Param  create(Param  param ) throws Exception {
		Session session = DBConnect.getSession();
		Transaction transaction = null;
		try {
			Utils.trace("create");

			transaction = session.beginTransaction();
			session.save(param);
			transaction.commit();

		} catch (Exception e) {

			Utils.trace("catch create " + e.toString());

			if (transaction != null) {
				transaction.rollback();
			}

		} finally {
			Common.closeSession( session);

		}
		return param;
	}

	@Override
	public Param  read(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Param readByFunctionCode(int functionCode) throws Exception{
		
		Session session = DBConnect.getSession();
		Param  myParam =  null ; 
		
		try {

			Query<Param > myQuery = session.createQuery(
					"FROM Param  WHERE functionCode = :functionCode", 
					Param .class);
			
			myQuery.setParameter("functionCode",functionCode );

			myParam  = myQuery.uniqueResult();

		} catch (Exception e) {
			Utils.trace("catch getByFunctionCode  :" + e.toString());
		} finally {
			Common.closeSession( session);
		}
		return myParam ;

		
	}

	@Override
	public int update(Param  param ) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Param  param ) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	


}
