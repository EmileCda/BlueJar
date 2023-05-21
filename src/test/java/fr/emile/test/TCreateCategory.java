package fr.emile.test;

import fr.emile.common.IConstant;
import fr.emile.entity.Category;
import fr.emile.entity.Item;
import fr.emile.entity.User;
import fr.emile.model.implement.CategoryDao;
import fr.emile.model.implement.UserDao;
import fr.emile.model.interfaces.ICategoryDao;
import fr.emile.model.interfaces.IUserDao;
import fr.emile.utils.DataTest;
import fr.emile.utils.Utils;

//*************** test result *********************************************************************
//check create category  + insert in database (ok)
// check create catégoru + item intsert database ok 
////*************** test result *********************************************************************
public class TCreateCategory implements IConstant {

	public static void main(String[] args) {
		int MAX_CATEGORY = 10; 
		Utils.trace("------------- start ----------------------");

		ICategoryDao myCategoryDao = new CategoryDao();
		try {
			for (int index = 0; index < MAX_CATEGORY; index++) {
				Category category = DataTest.genCategory();
				int maxItem = Utils.randInt(0,10);
				
				for (int nbItem = 0 ; nbItem < maxItem; nbItem++) {
					Item item = DataTest.genItem();
					int maxComment = Utils.randInt(0,10);
					for (int nbComment = 0 ; nbComment < maxComment ; nbComment++) {
						item.addComment(DataTest.genComment());
					}
					
					category.addItem(item);
					
				}
				myCategoryDao.create(category);
			}

		} catch (Exception e) {
			Utils.trace("catch myCategoryDao.create(category); " + e.toString());
		}

		Utils.trace("------------- End ----------------------");

	}

}
