package dao;

import java.util.ArrayList;

import model.Comment;

public interface CommentDao {
	public boolean AddComment(Comment comt);
	public boolean DeleteComment(Comment comt);
	public ArrayList<Comment> ListComment(Comment comt);
}
