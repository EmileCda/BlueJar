package fr.emile.model.interfaces;

import fr.emile.entity.Category;

public interface ICategoryDao {
	Category create (Category category)  throws Exception;
	Category read (int id)  throws Exception;
	int update (Category category)  throws Exception;
	int delete (Category category)  throws Exception;

}
