package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utils.DBUtil;
import model.Knowledge;
import dao.KnowledgeDao;

public class KnowledgeDaoImpl implements KnowledgeDao{

	@Override
	public boolean AddNLG(Knowledge nlg) {
		// TODO Auto-generated method stub
		DBUtil dbu = new DBUtil();
		Connection conn = dbu.getConnection();
		String sql = "INSERT INTO t_knowledge (_nlg_name,_pub_time,_content) VALUES(?,?,?)";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, nlg.getNlg_name());
			ps.setString(2, nlg.getPub_time());
			ps.setString(3, nlg.getContent());
			int i = ps.executeUpdate();
		}catch(SQLException e){
			dbu.setFlag(false);
			e.printStackTrace();
		}
		dbu.Commite();
		return dbu.getFlag();
		
	}

	@Override
	public boolean DeleteNLG(Knowledge nlg) {
		// TODO Auto-generated method stub
		DBUtil dbu = new DBUtil();
		Connection conn = dbu.getConnection();
		String sql = "DELETE FROM t_knowledge WHERE _nlg_name=?";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,nlg.getNlg_name());
			int i = ps.executeUpdate();
		}catch(SQLException e){
			dbu.setFlag(false);
			e.printStackTrace();
		}
		dbu.Commite();
		return dbu.getFlag();
	}

	@Override
	public ArrayList<Knowledge> listKnowledges() {
		// TODO Auto-generated method stub
		ArrayList<Knowledge> nlgList = new ArrayList<Knowledge>(); 
		DBUtil dbu = new DBUtil();
		Connection conn = dbu.getConnection();
		String sql = "SELECT * FROM t_knowledge";
		try{
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()){
				Knowledge temp = new Knowledge();
				temp.setContent(rs.getString("_content"));
				temp.setNlg_name(rs.getString("_nlg_name"));
				temp.setPub_time(rs.getString("_pub_time"));
				nlgList.add(temp);
			}
			rs.close();
			stat.close();
			return nlgList;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

}
