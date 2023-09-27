package fr.emile.test;

import fr.emile.entity.Order;
import fr.emile.model.implement.OrderDao;
import fr.emile.model.interfaces.IOrderDao;
import fr.emile.utils.DataTest;
import fr.emile.utils.Utils;

//*************** test result *********************************************************************
//check read order by id (ok)
//check decript password : ok 
////*************** test result *********************************************************************



public class TReadOrder {
public static void main(String[] args) {
	
	Utils.trace("------------- start ----------------------");
	int orderId = 1 ;
	Order myOrder = new Order();
	
	IOrderDao myOrderDao = new OrderDao();
	try {
		myOrder = myOrderDao.read(orderId);
	} catch (Exception e) {
		Utils.trace("catch myOrderDao.add(myOrder) ");
		e.printStackTrace();
	}finally {
		if (myOrder != null) {
		Utils.trace("\n"+myOrder.toString());
		}else{ 
			Utils.trace("myOrder is null");
		}
	}
	Utils.trace("------------- End ----------------------");

	}
}
