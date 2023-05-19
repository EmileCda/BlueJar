package fr.emile.control;

import fr.emile.entity.User;

public interface IAdminCtrl {
	
	public int create(User user);
	public User read(int id);
	public int update(User user);
	public int delete(int id);
	

}
