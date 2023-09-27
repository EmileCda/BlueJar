package fr.emile.model.interfaces;

import fr.emile.entity.User;

public interface IUserDao {
	User create (User user)  throws Exception;
	User read (int id)  throws Exception;
	User read (String email)  throws Exception;
	int update (User user)  throws Exception;
	int delete (User user)  throws Exception;

}
