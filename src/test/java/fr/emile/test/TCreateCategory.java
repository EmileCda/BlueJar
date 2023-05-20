package fr.emile.test;

import fr.emile.common.IConstant;
import fr.emile.entity.Category;
import fr.emile.entity.User;
import fr.emile.model.implement.CategoryDao;
import fr.emile.model.implement.UserDao;
import fr.emile.model.interfaces.ICategoryDao;
import fr.emile.model.interfaces.IUserDao;
import fr.emile.utils.DataTest;
import fr.emile.utils.Utils;

//*************** test result *********************************************************************
//check create category  + insert in database (ok)
////*************** test result *********************************************************************
public class TCreateCategory implements IConstant {

	public static void main(String[] args) {
		int maxIndex = 1;
		Utils.trace("------------- start ----------------------");

		ICategoryDao myCategoryDao = new CategoryDao();
		try {
			for (int index = 0; index < maxIndex; index++) {
				Category category = new Category(); 
				
//				DataTest.genCategory();
				myCategoryDao.create(category);
			}

		} catch (Exception e) {
			Utils.trace("catch myCategoryDao.create(category); " + e.toString());
		}

		Utils.trace("------------- End ----------------------");

	}

}
