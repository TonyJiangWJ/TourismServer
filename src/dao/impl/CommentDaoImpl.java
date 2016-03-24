package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utils.DBUtil;
import utils.statics.UTools;
import model.Comment;
import dao.CommentDao;

public class CommentDaoImpl implements CommentDao{
	private DBUtil dbu;
	private Connection conn;
	private String table;
	private String name;
	private void SetConnection(Comment comt){
		dbu = new DBUtil();
		conn = dbu.getConnection();
		if(comt.getType()==UTools.NLG){
			table="t_nlg_comment";
			name = "_nlg_name";
		}else{
			table="t_topic_comment";
			name = "_tpc_name";
		}
	}
	@Override
	public boolean AddComment(Comment comt) {
		// TODO Auto-generated method stub
		SetConnection(comt);
		String sql = "INSERT INTO "+table+" (_username,_content,_pub_time,"+name+",_to_user) VALUES"
				+ "(?,?,?,?,?)";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, comt.getUserName());
			ps.setString(2, comt.getContent());
			ps.setString(3, comt.getPub_time());
			ps.setString(4, comt.getName());
			ps.setString(5, comt.getTo_user());
			int i = ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			dbu.setFlag(false);
			e.printStackTrace();
		}
		dbu.Commite();
		return dbu.getFlag();
	}

	@Override
	public boolean DeleteComment(Comment comt) {
		// TODO Auto-generated method stub
		SetConnection(comt);
		String sql = "DELETE FROM "+table+" WHERE "+name+"=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, comt.getName());
			int i = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			dbu.setFlag(false);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbu.Commite();
		return dbu.getFlag();
	}

	@Override
	public ArrayList<Comment> ListComment(Comment comt) {
		// TODO Auto-generated method stub
		ArrayList<Comment> comt_list = new ArrayList<Comment>();
		SetConnection(comt);
		String sql = "SELECT * FROM "+table;
		try{
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()){
				Comment temp = new Comment();
				temp.setType(comt.getType());
				temp.setContent(rs.getString("_content"));
				temp.setName(rs.getString(name));
				temp.setPub_time(rs.getString("_pub_time"));
				temp.setUserName(rs.getString("_username"));
				temp.setTo_user(rs.getString("_to_user"));
				comt_list.add(temp);
			}
			rs.close();
			stat.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		dbu.Close();
		return comt_list;
	}

}
