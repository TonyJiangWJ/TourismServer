package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;







import utils.DBUtil;
import utils.statics.UTools;
import model.Activities;
import dao.ActivityDao;

public class ActivityDaoImpl implements ActivityDao{
	private DBUtil dbu;
	private Connection conn;
	private void SetConnection(){
		dbu = new DBUtil();
		conn = dbu.getConnection();
	}
	
	@Override
	public boolean AddActivity(Activities act) {
		// TODO Auto-generated method stub
		SetConnection();
		String sql = "INSERT INTO t_activity (_acvitity_id,_activity_name,_age_range,_company_id"
				+ ",_content,_count,_destination,_pub_time) VALUES(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,UTools.getUniqueId(act.getActivity_name(), act.getPub_time()));
			ps.setString(2, act.getActivity_name());
			ps.setString(3, act.getAge_range());
			ps.setString(4, act.getCompany_id());
			ps.setString(5, act.getContent());
			ps.setInt(6, act.getCount());
			ps.setString(7, act.getDestination());
			ps.setString(8, act.getPub_time());
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
	public boolean DeleteActivity(Activities act) {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean DeleteActivity(String act_id) {
		SetConnection();
		String sql = "DELETE FROM t_activity WHERE _activity_id='"+act_id+"'";
		try{
			Statement stat = conn.createStatement();
			int i = stat.executeUpdate(sql);
			stat.close();
		}catch(SQLException e){
			dbu.setFlag(false);
			e.printStackTrace();
		}
		dbu.Commite();
		
		return dbu.getFlag();
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean AdjusetActivity(Activities act) {
		
		SetConnection();
		String sql = "UPDATE t_activity SET _acvitity_id=?,_activity_name=?,_age_range=?,_company_id=?"
				+ ",_content=?,_count=?,_destination=?,_pub_time=? WHERE _activity_id=?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,UTools.getUniqueId(act.getActivity_name(), act.getPub_time()));
			ps.setString(2, act.getActivity_name());
			ps.setString(3, act.getAge_range());
			ps.setString(4, act.getCompany_id());
			ps.setString(5, act.getContent());
			ps.setInt(6, act.getCount());
			ps.setString(7, act.getDestination());
			ps.setString(8, act.getPub_time());
			ps.setString(9, act.getActivity_id());
			int i = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			dbu.setFlag(false);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbu.Commite();
		return dbu.getFlag();
//		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Activities> ListActivities() {
		// TODO Auto-generated method stub
		SetConnection();
		ArrayList<Activities> act_list = new ArrayList<Activities>();
		String sql = "SELECT * FROM t_activity";
		try{
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()){
				Activities temp = new Activities();
				temp.setActivity_id(rs.getString("_activity_id"));
				temp.setActivity_name(rs.getString("_activity_name"));
				temp.setAge_range(rs.getString("_age_range"));
				temp.setCompany_id(rs.getString("_company_id"));
				temp.setContent(rs.getString("_content"));
				temp.setCount(rs.getInt("_count"));
				temp.setDestination(rs.getString("_destination"));
				temp.setPub_time(rs.getString("_pub_time"));
				act_list.add(temp);
			}
			rs.close();
			stat.close();
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		dbu.Close();
		return act_list;
//		return null;
	}

}
