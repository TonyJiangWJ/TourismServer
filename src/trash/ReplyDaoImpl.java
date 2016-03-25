package trash;

import java.sql.Connection;
import java.util.ArrayList;

import utils.DBUtil;
import model.Comment;

public class ReplyDaoImpl implements ReplyDao{
	private DBUtil dbu;
	private Connection conn;
	private void SetConnection(){
		
	}
	@Override
	public boolean AddReply(Reply rpy) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean DeleteReply(Reply rpy) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Reply> ListReply(Comment comt) {
		// TODO Auto-generated method stub
		return null;
	}

}
