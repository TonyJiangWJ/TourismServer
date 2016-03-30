package dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;

import utils.DBUtil;
import utils.statics.UTools;
import model.Purchase;
import model.User;
import dao.PurchaseDao;

public class PurchaseDaoImpl implements PurchaseDao{
	private DBUtil dbu ;
	private Connection conn;
	private void SetConnection(){
		dbu = new DBUtil();
		conn = dbu.getConnection();
	}
	@Override
	public boolean AddPurchase(Purchase purchase) {
		SetConnection();
		String sql = "INSERT INTO t_purchase (_purchase_id,_username,_package_id,_count,_purchase_date,_status,_if_rate)"
				+ " VALUES(?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, UTools.getUniqueId(purchase.getUserame(), purchase.getPurchase_date()));
			ps.setString(2, purchase.getUserame());
			ps.setString(3, purchase.getPackage_id());
			ps.setInt(4, purchase.getCount());
			ps.setString(5, purchase.getPurchase_date());
			ps.setString(6, purchase.getStatus());
			ps.setBoolean(7, purchase.isIf_rate());
			int i = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			dbu.setFlag(false);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbu.Commite();
		// TODO Auto-generated method stub
		return dbu.getFlag();
	}

	@Override
	public boolean DeletePurchase(Purchase purchase) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean DeletePurchase(String purchase_id) {
		// TODO Auto-generated method stub
		SetConnection();
		String sql = "DELETE FROM t_purchase WHERE _purchase_id = '"+purchase_id+"'";
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
	public boolean AdjustPurchase(Purchase purchase) {
		// TODO Auto-generated method stub
		SetConnection();
		String sql = "UPDATE t_purchase SET _purchase_id=?,_username=?,_package_id=?,_count=?,_purchase_date=?,_status=?,_if_rate=?"
				+ " WHERE _purchase_id=?";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, purchase.getPurchase_id());
			ps.setString(2, purchase.getUserame());
			ps.setString(3, purchase.getPackage_id());
			ps.setInt(4, purchase.getCount());
			ps.setString(5, purchase.getPurchase_date());
			ps.setString(6, purchase.getStatus());
			ps.setBoolean(7, purchase.isIf_rate());
			int i = ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
			dbu.setFlag(false);
		}
		dbu.Commite();
		return dbu.getFlag();
	}

	@Override
	public ArrayList<Purchase> ListPurchases(User usr) {
		// TODO Auto-generated method stub
		ArrayList<Purchase> pList = new ArrayList<Purchase>();
		SetConnection();
		String sql = "SELECT * FROM t_purchase WHERE _username='"+usr.getUserName()+"'";
		try{
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()){
				Purchase temp = new Purchase();
				temp.setCount(rs.getInt("_count"));
				temp.setIf_rate(rs.getBoolean("_if_rate"));
				temp.setPackage_id(rs.getString("_package_id"));
				temp.setPurchase_date(rs.getString("_purchase_date"));
				temp.setStatus(rs.getString("_status"));
				temp.setUserame(rs.getString("_username"));
				pList.add(temp);
				
			}
			stat.close();
			rs.close();
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		dbu.Close();
		return pList;
	}

}
