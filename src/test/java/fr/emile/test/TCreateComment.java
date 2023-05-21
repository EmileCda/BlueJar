package fr.emile.test;

import fr.emile.common.IConstant;
import fr.emile.entity.Comment;
import fr.emile.model.implement.CommentDao;
import fr.emile.model.interfaces.ICommentDao;
import fr.emile.utils.DataTest;
import fr.emile.utils.Utils;

//*************** test result *********************************************************************
// link to catégory desactivated ** reminder **************  
//check create comment + insert in database  : ok 
//
////*************** test result *********************************************************************
public class TCreateComment implements IConstant {

	public static void main(String[] args) {

		Utils.trace("------------- start ----------------------");

		ICommentDao myCommentDao = new CommentDao();
		try {
			Comment comment = myCommentDao.create( DataTest.genComment());
			if (comment != null )
				Utils.trace(comment.toString());

		} catch (Exception e) {
			Utils.trace("catch myCommentDao.create(comment); "+e.toString());
			e.printStackTrace();
		} 
		
		Utils.trace("------------- End ----------------------");

	}

}
