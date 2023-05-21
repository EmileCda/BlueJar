package fr.emile.common;

import org.hibernate.Session;

public class Common implements IConstant{

	
	public static void closeSession(Session session) {

			// session will be close by the end of the application		
//					if (session != null && session.isOpen())
//						session.close();
					
	}
}
