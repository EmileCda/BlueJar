package fr.emile.model.interfaces;

import fr.emile.entity.OrderLine;

public interface IOrderLineDao {
	OrderLine create (OrderLine orderLine)  throws Exception;
	OrderLine read (int id)  throws Exception;
	int update (OrderLine orderLine)  throws Exception;
	int delete (OrderLine orderLine)  throws Exception;

}
