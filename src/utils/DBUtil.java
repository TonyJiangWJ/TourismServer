package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private Connection conn = null;
	private final String DRIVER = "com.mysql.jdbc.Driver";
	private final String USER = SQL_INFO.getUsername();
	private final String PASSWORD = SQL_INFO.getPassword();
	private final String URL = "jdbc:mysql://localhost:3306/tourism?useSSL=true&useUnicode=true&characterEncoding=UTF-8";
	private boolean flag = true;
	public void setFlag(boolean flg){
		flag = flg;
	}
	public boolean getFlag(){
		return flag;
	}
	public Connection getConnection(){
		if(conn==null)
			openConnection();
		return conn;
	}
	private void openConnection(){
		try{
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
			conn.setAutoCommit(false);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public void Commite(){
		if(flag==true){
			try {
				conn.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				Close();
			}
		}else{
			try{
				conn.rollback();
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				Close();
			}
		}
	}
	
	public void Close(){
		try{
			if(conn!=null){
				conn.close();
				conn=null;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void RollBack(){
		try{
			conn.rollback();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			Close();
		}
	}
}
