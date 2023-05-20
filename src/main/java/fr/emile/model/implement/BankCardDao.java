package fr.emile.model.implement;

import fr.emile.entity.BankCard;
import fr.emile.model.interfaces.IBankCardDao;
import fr.emile.utils.Utils;

import org.hibernate.Session;
import org.hibernate.Transaction;
import fr.emile.model.connect.DBConnect;

public class BankCardDao implements IBankCardDao {

	@Override
	public BankCard create(BankCard bankCard) throws Exception {
		Session session = DBConnect.getSession();
		Transaction transaction = null;
		try {
			bankCard.encrypt();
			transaction = session.beginTransaction();
			session.save(bankCard);
			transaction.commit();


		} catch (Exception e) {

			Utils.trace("catch create "+ e.toString());
			if (transaction != null) {
				transaction.rollback();
			}

		} finally {
			this.closeSession( session);

		}
		return bankCard;
	}

	@Override
	public BankCard read(int id) throws Exception {
		Session session = DBConnect.getSession();
		BankCard bankCard = null;
		try {
			bankCard= new BankCard();
			bankCard = session.find(BankCard.class, id);
			if (bankCard != null) {
				Utils.trace(bankCard.toString());
				bankCard.decrypt();
				Utils.trace(bankCard.toString());
			}else Utils.trace("bankCard null");


		} catch (Exception e) {
			Utils.trace("catch Read " +e.toString());

		} finally {
			this.closeSession( session);
		}

		return bankCard;
	}

	@Override
	public int update(BankCard bankCard) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(BankCard bankCard) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	private void closeSession(Session session) {

		// session will be close by the end of the application		
//				if (session != null && session.isOpen())
//					session.close();
				
			}


}
