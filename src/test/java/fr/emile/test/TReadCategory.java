package fr.emile.test;

import fr.emile.entity.Category;
import fr.emile.model.implement.CategoryDao;
import fr.emile.model.interfaces.ICategoryDao;
import fr.emile.utils.DataTest;
import fr.emile.utils.Utils;

//*************** test result *********************************************************************
//check read catégoryby id (ok)
 
////*************** test result *********************************************************************



public class TReadCategory {
public static void main(String[] args) {
	
	Utils.trace("------------- start ----------------------");
	int userId = 1 ;
	Category myCategory = new Category();
	
	ICategoryDao myCategoryDao = new CategoryDao();
	try {
		myCategory = myCategoryDao.read(userId);
	} catch (Exception e) {
		Utils.trace("catch myCategoryDao.add(myCategory) " + e.toString());
	}finally {
		if (myCategory == null) {
			Utils.trace("myCategory is null");
		}else {
			Utils.trace("\n"+myCategory.toString());
		}
	}
	Utils.trace("------------- End ----------------------");

	}
}
