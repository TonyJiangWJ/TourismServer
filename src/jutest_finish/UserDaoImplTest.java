package jutest_finish;

import static org.junit.Assert.*;
import model.User;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import utils.statics.DateUtil;
import utils.statics.ParseMD5;
import dao.impl.UserDaoImpl;

public class UserDaoImplTest {
	private User user;
	private UserDaoImpl udi;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		user = new User();
		udi = new UserDaoImpl();
		user.setCreated_time(DateUtil.GetDateString());
		user.setImage("default");
		user.setName("Tony");
		user.setNickName("Jery");
		user.setPassword(ParseMD5.parseStrToMd5U32("123456"));
		user.setSex("男");
		String phone = "17866476633";
		user.setPhone(phone);
		user.setUserName(phone+"@tourism");
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSignUp() {
		if(udi.SignUp(user)==true){
			System.out.println("success");
		}else{
			System.out.println("注册失败");
//			fail("Not yet implemented");
		}
	}

	@Test
	public void testCheck(){
		if(udi.Check(user)){
			System.out.println("已存在");
		}
		else
		{
			System.out.println("不存在");
		}
	}
	
	@Test
	public void testLogin(){
		User usr = udi.Login(user);
		if(usr!=null){
			System.out.println("登录成功：用户名："+usr.getUserName()+"创建时间："+usr.getCreated_time());
		}else{
			System.out.println("登录失败");
		}
	}
}
