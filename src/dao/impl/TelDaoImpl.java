package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utils.DBUtil;
import model.Tel;
import dao.TelDao;

public class TelDaoImpl implements TelDao{
	private DBUtil dbu;
	private Connection conn;
	private void SetConnection(){
		dbu = new DBUtil();
		conn = dbu.getConnection();
	}
	@Override
	public boolean AddFriend(Tel tel) {
		// TODO Auto-generated method stub
		SetConnection();
		String sql = "INSERT INTO t_tel (_owner,_friend_name) VALUES (?,?)";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, tel.getOwner());
			ps.setString(2, tel.getFriendName());
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
	public boolean DeleteFriend(Tel tel) {
		// TODO Auto-generated method stub
		SetConnection();
		String sql = "DELETE FROM t_tel WHERE _owner=? AND _friend_name=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, tel.getOwner());
			ps.setString(2, tel.getFriendName());
			int i = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			dbu.setFlag(false);
			e.printStackTrace();
		}
		dbu.Commite();
		return dbu.getFlag();
	}

	@Override
	public ArrayList<Tel> ListFriend(Tel tel) {
		// TODO Auto-generated method stub
		SetConnection();
		ArrayList<Tel> tel_list = new ArrayList<Tel>(); 
		String sql = "SELECT * FROM t_tel";
		try{
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()){
				Tel temp = new Tel();
				temp.setOwner(rs.getString("_owner"));
				temp.setFriendName(rs.getString("_friend_name"));
				tel_list.add(temp);
			}
			rs.close();
			stat.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return tel_list;
	}

}
