package fr.emile.test;

import org.hibernate.Session;

import fr.emile.model.connect.DBConnect;
import fr.emile.utils.Utils;

public class TConnect {
	public static void main(String[] args) {

		Utils.trace("--------------- début -----------------------------------");
		Session session = DBConnect.getSession();
		
		Utils.trace("--------------- fin -----------------------------------");
	}

}
