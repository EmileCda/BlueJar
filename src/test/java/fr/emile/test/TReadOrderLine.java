package fr.emile.test;

import fr.emile.entity.OrderLine;
import fr.emile.model.implement.OrderLineDao;
import fr.emile.model.interfaces.IOrderLineDao;
import fr.emile.utils.DataTest;
import fr.emile.utils.Utils;

//*************** test result *********************************************************************
//check read order by id (ok)
//check decript password : ok 
////*************** test result *********************************************************************

public class TReadOrderLine {
	public static void main(String[] args) {

		Utils.trace("------------- start ----------------------");
		int orderLineId = 2;
		OrderLine myOrderLine = new OrderLine();

		IOrderLineDao myOrderLineDao = new OrderLineDao();
		try {
			myOrderLine = myOrderLineDao.read(orderLineId);
		} catch (Exception e) {
			Utils.trace("catch myOrderLineDao.add(myOrderLine) ");
			e.printStackTrace();
		} finally {
			if (myOrderLine != null) {
				Utils.trace("\n" + myOrderLine.toString());
			} else {
				Utils.trace("myOrderLine is null");
			}
		}
		Utils.trace("------------- End ----------------------");

	}
}
