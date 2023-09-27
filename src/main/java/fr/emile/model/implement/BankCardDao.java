package fr.emile.model.implement;

import fr.emile.common.Common;
import fr.emile.entity.BankCard;
import fr.emile.model.interfaces.IBankCardDao;
import fr.emile.utils.Utils;

import org.hibernate.Session;
import org.hibernate.Transaction;
import fr.emile.model.connect.DBConnect;

public  final class BankCardDao implements IBankCardDao {

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
			Common.closeSession( session);

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
				bankCard.decrypt();
			}


		} catch (Exception e) {
			Utils.trace("catch Read " +e.toString());

		} finally {
			Common.closeSession( session);
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


}
