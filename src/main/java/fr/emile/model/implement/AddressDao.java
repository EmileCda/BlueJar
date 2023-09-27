package fr.emile.model.implement;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.emile.common.Common;
import fr.emile.entity.Address;
import fr.emile.entity.Address;
import fr.emile.model.connect.DBConnect;
import fr.emile.model.interfaces.IAddressDao;
import fr.emile.utils.Utils;

public  final  class AddressDao implements IAddressDao {

	public Address create(Address address) throws Exception {
		Session session = DBConnect.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(address);
			transaction.commit();


		} catch (Exception e) {

			Utils.trace("catch create "+ e.toString());
			if (transaction != null) {
				transaction.rollback();
			}

		} finally {
			Common.closeSession( session);


		}
		return address;
	}

	public Address read(int id) throws Exception {
		Session session = DBConnect.getSession();
		Address address = null;
		try {
			address= new Address();
			address = session.find(Address.class, id);
		} catch (Exception e) {
			Utils.trace("catch Read " +e.toString());

		} finally {
			Common.closeSession( session);

		}

		return address;
	}

	public int update(Address address) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete(Address address) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
}
