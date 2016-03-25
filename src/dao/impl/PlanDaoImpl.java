package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utils.DBUtil;
import model.Plan;
import dao.PlanDao;

public class PlanDaoImpl implements PlanDao{

	@Override
	public boolean AddPlan(Plan plan) {
		// TODO Auto-generated method stub
		DBUtil dbu = new DBUtil();
		Connection conn = dbu.getConnection();
		String sql = "INSERT INTO t_plan (_pl_name,_destination,_price,_people_num,_content,"
				+ "_created_time,_start_time,_end_time,_active_time) VALUES(?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, plan.getPl_name());
			ps.setString(2, plan.getDestination());
			ps.setDouble(3, plan.getPrice());
			ps.setInt(4, plan.getPeople_num());
			ps.setString(5, plan.getContent());
			ps.setString(6, plan.getCreated_time());
			ps.setString(7, plan.getStart_time());
			ps.setString(8, plan.getEnd_time());
			ps.setString(9, plan.getActive_time());
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
	public boolean DeletePlan(Plan plan) {
		// TODO Auto-generated method stub
		DBUtil dbu = new DBUtil();
		Connection conn = dbu.getConnection();
		String sql = "DELETE FROM t_plan WHERE _pl_name = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, plan.getPl_name());
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
	public ArrayList<Plan> ListPlan() {
		// TODO Auto-generated method stub
		ArrayList<Plan> pl_list = new ArrayList<Plan>();
		DBUtil dbu = new DBUtil();
		Connection conn = dbu.getConnection();
		String sql = "SELECT * FROM t_plan";
		try{
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()){
				Plan temp = new Plan();
				temp.setPl_name(rs.getString("_pl_name"));
				temp.setActive_time(rs.getString("_active_time"));
				temp.setCreated_time(rs.getString("_created_time"));
				temp.setContent(rs.getString("_content"));
				temp.setDestination(rs.getString("_destination"));
				temp.setEnd_time(rs.getString("_end_time"));
				temp.setPeople_num(rs.getInt("_people_num"));
				temp.setPrice(rs.getFloat("_price"));
				temp.setStart_time(rs.getString("_start_time"));
				pl_list.add(temp);
			}
			rs.close();
			stat.close();
			
		}catch(SQLException e){
			dbu.setFlag(false);
			e.printStackTrace();
		}
		dbu.Close();
		return pl_list;
	}

	@Override
	public boolean AddPeople(Plan plan) {
		// TODO Auto-generated method stub
		DBUtil dbu = new DBUtil();
		Connection conn = dbu.getConnection();
		String sql = "UPDATE t_plan SET _people_num = _people_num+1 WHERE _pl_name=?";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, plan.getPl_name());
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
	public boolean AdjustPlan(Plan plan) {
		// TODO Auto-generated method stub
		DBUtil dbu = new DBUtil();
		Connection conn = dbu.getConnection();
		String sql = "UPDATE t_plan SET _pl_name=?,_destination=?,_price=?,_people_num=?,_content=?,"
				+ "_created_time=?,_start_time=?,_end_time=?,_active_time=? WHERE _pl_name=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, plan.getPl_name());
			ps.setString(2, plan.getDestination());
			ps.setDouble(3, plan.getPrice());
			ps.setInt(4, plan.getPeople_num());
			ps.setString(5, plan.getContent());
			ps.setString(6, plan.getCreated_time());
			ps.setString(7, plan.getStart_time());
			ps.setString(8, plan.getEnd_time());
			ps.setString(9, plan.getActive_time());
			ps.setString(10, plan.getPl_name());
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
