package fr.emile.model.interfaces;

import fr.emile.entity.BankCard;

public interface IBankCardDao {
	BankCard create (BankCard bankCard)  throws Exception;
	BankCard read (int id)  throws Exception;
	int update (BankCard bankCard)  throws Exception;
	int delete (BankCard bankCard)  throws Exception;

}
