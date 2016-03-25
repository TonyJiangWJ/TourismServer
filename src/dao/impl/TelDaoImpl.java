package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.commons.collections.Factory;

import utils.DBUtil;
import model.Tel;
import model.User;
import dao.TelDao;
import factories.DaoFactory;

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
			ArrayList<Tel> tel_list_exist = ListFriend(tel);
			if(!checkInTelArray(tel.getOwner(), tel.getFriendName(), tel_list_exist)){
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, tel.getOwner());
				ps.setString(2, tel.getFriendName());
				int i = ps.executeUpdate();
				ps.close();
			}else{
				dbu.setFlag(false);
			}
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


	private ArrayList<Tel> ListFriend(Tel tel) {
		// TODO Auto-generated method stub
		SetConnection();
		ArrayList<Tel> tel_list = new ArrayList<Tel>(); 
		String sql = "SELECT * FROM t_tel WHERE _owner='"+tel.getOwner()+"'";
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
		//dbu.Close();
		return tel_list;
	}
	@Override
	public ArrayList<User> ListAll(Tel tel) {
		// TODO Auto-generated method stub
		ArrayList<Tel> tel_list = ListFriend(tel); 
		ArrayList<User> resultArrayList = new ArrayList<User>();
		if(tel_list!=null){
			for(int i=0;i<tel_list.size();i++){
				if(!checkInUserArray(tel_list.get(i).getFriendName(), resultArrayList))
				{
					User temp = new User();
					temp.setUserName(tel_list.get(i).getFriendName());
					resultArrayList.add(DaoFactory.getUserDao().GetUserInfo(temp));
				}
			}
			return resultArrayList;
		}
		return null;
	}
	private boolean checkInUserArray(String userName,ArrayList<User> result){
		for(int i=0;i<result.size();i++){
			if(userName.equals(result.get(i).getUserName())){
				System.out.println(userName+result.get(i).getUserName());
				return true;
			}
			else{
				//System.out.println(userName+result.get(i).getUserName());
			}
		}
		return false;
	}
	private boolean checkInTelArray(String owner,String userName,ArrayList<Tel> telList){
		for(int i=0;i<telList.size();i++){
			if(owner.equals(telList.get(i).getOwner())&&userName.equals(telList.get(i).getFriendName())){
				System.out.println(userName+telList.get(i).getFriendName());
				return true;
			}
			else{
				//System.out.println(userName+result.get(i).getUserName());
			}
		}
		return false;
	}

}
