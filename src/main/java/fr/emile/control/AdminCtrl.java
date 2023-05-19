package fr.emile.control;

import fr.emile.entity.User;
import fr.emile.model.implement.UserDao;
import fr.emile.model.interfaces.IUserDao;

public class AdminCtrl implements IAdminCtrl{
	
	

	@Override
	public int create(User user) {
		
		IUserDao myUserDao = new UserDao();
		user.encrypte();
		user= myUserDao.create(user);
		if (user.getId() >0 )
			return 1;
		return 0 ; 
	}

	@Override
	public User read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
