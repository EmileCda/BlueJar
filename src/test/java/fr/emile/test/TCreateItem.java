package fr.emile.test;

import fr.emile.common.IConstant;
import fr.emile.entity.Item;
import fr.emile.model.implement.ItemDao;
import fr.emile.model.interfaces.IItemDao;
import fr.emile.utils.DataTest;
import fr.emile.utils.Utils;

//*************** test result *********************************************************************
// link to catégory desactivated ** reminder **************  
//check create item + insert in database  : ok 
//
////*************** test result *********************************************************************
public class TCreateItem implements IConstant {

	public static void main(String[] args) {

		Utils.trace("------------- start ----------------------");

		IItemDao myItemDao = new ItemDao();
		try {
			Item item = myItemDao.create( DataTest.genItem());
			if (item != null )
				Utils.trace(item.toString());

		} catch (Exception e) {
			Utils.trace("catch myItemDao.create(item); "+e.toString());
			e.printStackTrace();
		} 
		
		Utils.trace("------------- End ----------------------");

	}

}
