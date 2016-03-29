package dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
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
		return false;
	}

	@Override
	public boolean AdjustPurchase(Purchase purchase) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Purchase> ListPurchases(User usr) {
		// TODO Auto-generated method stub
		return null;
	}

}
