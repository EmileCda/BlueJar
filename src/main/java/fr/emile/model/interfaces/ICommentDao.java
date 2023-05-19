package fr.emile.model.interfaces;

import fr.emile.entity.Comment;

public interface ICommentDao {
	Comment create (Comment comment)  throws Exception;
	Comment read (int id)  throws Exception;
	int update (Comment comment)  throws Exception;
	int delete (Comment comment)  throws Exception;

}
