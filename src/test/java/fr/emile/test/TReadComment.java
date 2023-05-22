package fr.emile.test;

import fr.emile.entity.Comment;
import fr.emile.model.implement.CommentDao;
import fr.emile.model.interfaces.ICommentDao;
import fr.emile.utils.DataTest;
import fr.emile.utils.Utils;

//*************** test result *********************************************************************
//check read comment by id (ok)
//check decript password : ok 
////*************** test result *********************************************************************



public class TReadComment {
public static void main(String[] args) {
	
	Utils.trace("------------- start ----------------------");
	int commentId = 1 ;
	Comment myComment = new Comment();
	
	ICommentDao myCommentDao = new CommentDao();
	try {
		myComment = myCommentDao.read(commentId);
	} catch (Exception e) {
		Utils.trace("catch myCommentDao.add(myComment) ");
		e.printStackTrace();
	}finally {
		if (myComment != null) {
		Utils.trace("\n"+myComment.toString());
		}else{ 
			Utils.trace("myComment is null");
		}
	}
	Utils.trace("------------- End ----------------------");

	}
}
