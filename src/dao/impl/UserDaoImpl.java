package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utils.DBUtil;
import utils.statics.DateUtil;
import model.User;
import dao.UserDao;

public class UserDaoImpl implements UserDao{

	@Override
	public boolean SignUp(User usr) {
		// TODO Auto-generated method stub
		DBUtil dbu = new DBUtil();
		Connection conn = dbu.getConnection();
		String sql = "INSERT INTO t_user (_username,_password,_nickname,_created_time,"
				+ "_image,_phone,_sex,_name) values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, usr.getUserName());
			ps.setString(2, usr.getPassword());
			ps.setString(3, usr.getNickName());
			ps.setString(4, usr.getCreated_time());
			ps.setString(5, usr.getImage());
			ps.setString(6, usr.getPhone());
			ps.setString(7, usr.getSex());
			ps.setString(8, usr.getName());
			//System.out.println(sql);
			int i = ps.executeUpdate();
			System.out.println("更新了"+i+"条信息");
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
	public boolean Check(User usr) {
		// TODO Auto-generated method stub
		DBUtil dbu = new DBUtil();
		Connection conn = dbu.getConnection();
		String sql = "SELECT _username,_created_time FROM t_user WHERE _username=?";
		try{
			boolean flag = false;
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,usr.getUserName());
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				String _username = rs.getString("_username");
				String _created_time = rs.getString("_created_time");
				System.out.println("用户名："+_username+" 创建日期:"+_created_time);
				flag=true;
			}
			rs.close();
			ps.close();
			dbu.Close();
			return flag;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User Login(User usr) {
		// TODO Auto-generated method stub
		DBUtil dbu = new DBUtil();
		Connection conn = dbu.getConnection();
		String sql = "SELECT * FROM t_user WHERE _username=? AND _password=?";
		User user = new User();
		boolean flag = false;
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, usr.getUserName());
			ps.setString(2, usr.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				user.setUserName(rs.getString("_username"));
				user.setImage(rs.getString("_image"));
				user.setCreated_time(rs.getString("_created_time"));
				user.setLast_login(rs.getString("_last_login"));
				user.setName(rs.getString("_name"));
				user.setNickName(rs.getString("_nickname"));
				user.setPhone(rs.getString("_phone"));
				user.setSex(rs.getString("_sex"));
				user.setPassword(rs.getString("_password"));
				flag=true;
			}
			
			rs.close();
			ps.close();
			if(flag==true){
				String sql2 = "UPDATE t_user SET _last_login = ? WHERE _username = ? AND _password = ? ";
				ps = conn.prepareStatement(sql2);
				ps.setString(1, DateUtil.GetDateString());
				ps.setString(2, usr.getUserName());
				ps.setString(3, usr.getPassword());
				
				int i = ps.executeUpdate();
				ps.close();
				dbu.Commite();
				
				return user;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		dbu.Close();
		return null;
	}

	@Override
	public User GetUserInfo(User usr) {
		// TODO Auto-generated method stub
		DBUtil dbUtil = new DBUtil();
		User user = new User();
		Connection conn = dbUtil.getConnection();
		String sql = "SELECT * FROM t_user WHERE _username='"+usr.getUserName()+"'";
		try {
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			if(rs.next()){
				user.setNickName(rs.getString("_nickname"));
				user.setName(rs.getString("_name"));
				user.setPhone(rs.getString("_phone"));
				user.setSex(rs.getString("_sex"));
				user.setUserName(rs.getString("_username"));
				user.setImage(rs.getString("_image"));
			}
			stat.close();
			rs.close();
		} catch (SQLException e) {
			dbUtil.setFlag(false);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbUtil.Close();
		return user;
	}

	@Override
	public boolean UpdateInfo(User usr) {
		// TODO Auto-generated method stub
		DBUtil dbu = new DBUtil();
		Connection conn = dbu.getConnection();
		String sql = "UPDATE t_user SET _username=?,_password=?,_nickname=?,_created_time=?,"
				+ "_image=?,_phone=?,_sex=?,_name=? WHERE _username=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, usr.getUserName());
			ps.setString(2, usr.getPassword());
			ps.setString(3, usr.getNickName());
			ps.setString(4, usr.getImage());
			ps.setString(5, usr.getPhone());
			ps.setString(6, usr.getSex());
			ps.setString(7, usr.getName());
			ps.setString(8, usr.getUserName());
			//System.out.println(sql);
			int i = ps.executeUpdate();
			System.out.println("更新了"+i+"条信息");
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			dbu.setFlag(false);
			e.printStackTrace();
			
		}
		dbu.Commite();
		return dbu.getFlag();
	
	}
	
}
