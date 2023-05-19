package fr.emile.model.interfaces;

import fr.emile.entity.Item;

public interface ICartItemDao {
	Item create (Item item)  throws Exception;
	Item read (int id)  throws Exception;
	int update (Item item)  throws Exception;
	int delete (Item item)  throws Exception;

}
