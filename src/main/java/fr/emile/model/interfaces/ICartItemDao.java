package fr.emile.model.interfaces;

import fr.emile.entity.CartItem;

public interface ICartItemDao {
	CartItem create (CartItem cartItem)  throws Exception;
	CartItem read (int id)  throws Exception;
	int update (CartItem cartItem)  throws Exception;
	int delete (CartItem cartItem)  throws Exception;

}
