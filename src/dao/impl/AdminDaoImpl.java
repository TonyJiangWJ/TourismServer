package dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.DBUtil;
import utils.statics.DateUtil;
import model.Administer;
import model.User;
import dao.*;
public class AdminDaoImpl implements AdminDao{
	public Administer Login(Administer admin){
		DBUtil dbu = new DBUtil();
		Connection conn = dbu.getConnection();
		String sql = "SELECT * FROM t_admin WHERE _username=? AND _password=?";
		try{
			Administer adm = new Administer();
			boolean flag = false;
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,admin.getUserName());
			ps.setString(2,admin.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				adm.setUserName(rs.getString("_username"));
				adm.setPassword(rs.getString("_password"));
				adm.setCreated_time(rs.getString("_created_time"));
				adm.setLast_login(rs.getString("_last_login"));
				flag=true;
			}
			rs.close();
			ps.close();
			if(flag==true){
				String sql2 = "UPDATE t_admin SET _last_login = ? WHERE _username=?";
				ps = conn.prepareStatement(sql2);
				ps.setString(1, DateUtil.GetDateString());
				ps.setString(2, admin.getUserName());
				int i = ps.executeUpdate();
				ps.close();
				dbu.Commite();
				return adm;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		dbu.Close();
		return null;
		
	}
}
