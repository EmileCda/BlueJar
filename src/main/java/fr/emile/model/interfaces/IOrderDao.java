package fr.emile.model.interfaces;

import fr.emile.entity.Order;

public interface IOrderDao {
	Order create (Order order)  throws Exception;
	Order read (int id)  throws Exception;
	int update (Order order)  throws Exception;
	int delete (Order order)  throws Exception;

}
