package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//import com.mysql.jdbc.PreparedStatement;






import utils.DBUtil;
import utils.statics.UTools;
import model.Company;
import dao.CompanyDao;

public class CompanyDaoImpl implements CompanyDao{
	private DBUtil dbu ;
	private Connection conn;
	private void SetConnection(){
		dbu = new DBUtil();
		conn = dbu.getConnection();
	}
	@Override
	public boolean AddCompany(Company company) {
		// TODO Auto-generated method stub
		SetConnection();
		String sql = "INSERT INTO t_company (_company_id,_company_name,_content) VALUES(?,?,?)";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, UTools.getUniqueId(company.getCompany_name(), company.getContent()));
			ps.setString(2, company.getCompany_name());
			ps.setString(3, company.getContent());
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
	public boolean DeleteCompany(Company company) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean DeleteCompany(String com_id) {
		// TODO Auto-generated method stub
		SetConnection();
		String sql = "DELETE FROM t_company WHERE _company_id='"+com_id+"'";
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
	}

	@Override
	public ArrayList<Company> ListCompanies() {
		// TODO Auto-generated method stub
		SetConnection();
		String sql = "SELECT * FROM t_company";
		ArrayList<Company> com_list = new ArrayList<Company>();
		try{
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()){
				Company temp = new Company();
				temp.setCompany_id(rs.getString("_company_id"));
				temp.setCompany_name(rs.getString("_company_name"));
				temp.setContent(rs.getString("_content"));
				com_list.add(temp);
			}
			rs.close();
			stat.close();
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		dbu.Close();
		return com_list;
	}

}
