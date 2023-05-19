package fr.emile.model.interfaces;

import fr.emile.entity.Address;

public interface IAddressDao  {
	
	
	Address create (Address address)  throws Exception;
	Address read (int id)  throws Exception;
	int update (Address address)  throws Exception;
	int delete (Address address)  throws Exception;
	
	
	

}
