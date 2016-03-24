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
		user.setSex("��");
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
			System.out.println("ע��ʧ��");
//			fail("Not yet implemented");
		}
	}

	@Test
	public void testCheck(){
		if(udi.Check(user)){
			System.out.println("�Ѵ���");
		}
		else
		{
			System.out.println("������");
		}
	}
	
	@Test
	public void testLogin(){
		User usr = udi.Login(user);
		if(usr!=null){
			System.out.println("��¼�ɹ����û�����"+usr.getUserName()+"����ʱ�䣺"+usr.getCreated_time());
		}else{
			System.out.println("��¼ʧ��");
		}
	}
}
