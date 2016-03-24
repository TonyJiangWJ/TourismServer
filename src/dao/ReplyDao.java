package dao;

import java.util.ArrayList;

import model.Comment;
import model.Reply;

public interface ReplyDao {
	public boolean AddReply(Reply rpy);
	public boolean DeleteReply(Reply rpy);
	//public ArrayList<Reply> ListReply(Reply rpy);
	public ArrayList<Reply> ListReply(Comment comt);
}
