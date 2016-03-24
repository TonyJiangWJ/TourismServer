package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utils.DBUtil;
import model.Topic;
import dao.TopicDao;

public class TopicDaoImpl implements TopicDao{

	@Override
	public boolean AddTopic(Topic tpc) {
		DBUtil dbu = new DBUtil();
		Connection conn = dbu.getConnection();
		String sql = "INSERT INTO t_topic (_tpc_name,_pub_time,_content,_people_num)"
				+ " VALUES (?,?,?,?)";
		
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, tpc.getTpc_name());
			ps.setString(2, tpc.getPub_time());
			ps.setString(3, tpc.getContent());
			ps.setInt(4, tpc.getPeople_num());
			int i = ps.executeUpdate();
			
		}catch(SQLException e){
			dbu.setFlag(false);
			e.printStackTrace();
		}
		dbu.Commite();
		return dbu.getFlag();
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean DeleteTopic(Topic tpc) {
		// TODO Auto-generated method stub
		DBUtil dbu = new DBUtil();
		Connection conn = dbu.getConnection();
		String sql = "DELETE FROM t_topic WHERE _tpc_name = ?";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, tpc.getTpc_name());
			int i = ps.executeUpdate();
		}catch(SQLException e){
			dbu.setFlag(false);
			e.printStackTrace();
		}
		dbu.Commite();
		return dbu.getFlag();
		
	}

	@Override
	public ArrayList<Topic> ListTopic() {
		// TODO Auto-generated method stub
		ArrayList<Topic> tpc_list = new ArrayList<Topic>();
		DBUtil dbu = new DBUtil();
		Connection conn = dbu.getConnection();
		String sql = "SELECT * FROM t_topic";
		try{
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()){
				Topic temp = new Topic();
				temp.setContent(rs.getString("_content"));
				temp.setPeople_num(rs.getInt("_people_num"));
				temp.setPub_time(rs.getString("_pub_time"));
				temp.setTpc_name(rs.getString("_tpc_name"));
				tpc_list.add(temp);
			}
			rs.close();
			stat.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		dbu.Close();
		return tpc_list;
	}

	@Override
	public boolean AddPeople(Topic tpc) {
		// TODO Auto-generated method stub
		DBUtil dbu = new DBUtil();
		Connection conn = dbu.getConnection();
		String sql = "UPDATE t_topic SET _people_num=_people_num+1 WHERE _tpc_name=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,tpc.getTpc_name());
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

}
