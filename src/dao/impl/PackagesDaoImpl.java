package dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;

import utils.DBUtil;
import utils.statics.UTools;
import model.Packages;
import dao.PackagesDao;

public class PackagesDaoImpl implements PackagesDao{
	private DBUtil dbu ;
	private Connection conn;
	private void SetConnection(){
		dbu = new DBUtil();
		conn = dbu.getConnection();
	}
	@Override
	public boolean AddPackage(Packages pkg) {
		// TODO Auto-generated method stub
		SetConnection();
		String sql = "INSERT INTO t_package (_pkg_name,_package_id,_activity_id,_pub_time,_active_time,_price,_content)"
				+ " VALUES(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pkg.getPkg_name());
			ps.setString(2, UTools.getUniqueId(pkg.getPkg_name(), pkg.getPub_time()));
			ps.setString(3, pkg.getActivity_id());
			ps.setString(4, pkg.getPub_time());
			ps.setString(5, pkg.getActive_time());
			ps.setDouble(6, pkg.getPrice());
			ps.setString(7, pkg.getContent());
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
	public boolean DeletePackage(Packages pkg) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean DeletePackage(String pkg_id) {
		// TODO Auto-generated method stub
		SetConnection();
		String sql = "DELETE FROM t_package WHERE _package_id='"+pkg_id+"'";
		try {
			Statement stat = conn.createStatement();
			int i = stat.executeUpdate(sql);
			stat.close();
		} catch (SQLException e) {
			dbu.setFlag(false);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbu.Commite();
		
		return dbu.getFlag();
	}

	@Override
	public ArrayList<Packages> ListPackages() {
		// TODO Auto-generated method stub
		ArrayList<Packages> pkg_list = new ArrayList<Packages>();
		SetConnection();
		String sql = "SELECT * FROM t_package";
		try{
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()){
				Packages temp = new Packages();
				temp.setActive_time(rs.getString("_active_time"));
				temp.setActivity_id(rs.getString("_activity_id"));
				temp.setContent(rs.getString("_content"));
				temp.setPackage_id(rs.getString("_package_id"));
				temp.setPkg_name(rs.getString("_pkg_name"));
				temp.setPrice(rs.getDouble("_price"));
				temp.setPub_time(rs.getString("_pub_time"));
				pkg_list.add(temp);
			}
			rs.close();
			stat.close();
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		dbu.Close();
		return pkg_list;
	}

}
