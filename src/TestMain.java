import java.sql.Connection;

import model.Administer;
import model.User;
import dao.impl.AdminDaoImpl;
import dao.impl.UserDaoImpl;
import utils.DBUtil;
import utils.statics.DateUtil;
import utils.statics.ParseMD5;


public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		User user = new User();
//		UserDaoImpl udi = new UserDaoImpl();
//		user.setCreated_time(DateUtil.GetDateString());
//		user.setImage("default");
//		user.setName("Tom");
//		user.setNickName("Jery");
//		user.setPassword(ParseMD5.parseStrToMd5U32("123456"));
//		user.setSex("男");
//		String phone = "17866476644";
//		user.setPhone(phone);
//		user.setUserName(phone+"@tourism");
//		
//		if(udi.SignUp(user)){
//			System.out.println("success");
//		}else{
//			System.out.println("fail");
//		}
//		System.out.println(ParseMD5.parseStrToMd5U32("fucker"));
//		AdminDaoImpl adi = new AdminDaoImpl();
//		Administer admin = new Administer();
//		admin.setCreated_time(DateUtil.GetDateString());
//		admin.setUserName("Faker");
//		admin.setPassword(ParseMD5.parseStrToMd5U32("fucker"));
//		Administer adm = adi.Login(admin);
//		if(adm!=null){
//			System.out.println("登录成功，用户名："+adm.getUserName()+"创建时间："+adm.getCreated_time()+"上次登录:"+adm.getLast_login());
//		}else{
//			System.out.println("登录失败");
//		}
	}

}
