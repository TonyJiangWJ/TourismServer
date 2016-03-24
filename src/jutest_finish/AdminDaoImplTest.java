package jutest_finish;

import static org.junit.Assert.*;
import model.Administer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import utils.statics.DateUtil;
import utils.statics.ParseMD5;
import dao.impl.AdminDaoImpl;

public class AdminDaoImplTest {
	private AdminDaoImpl adi;
	private Administer admin;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		adi = new AdminDaoImpl();
		admin = new Administer();
		admin.setCreated_time(DateUtil.GetDateString());
		admin.setUserName("Faker");
		admin.setPassword(ParseMD5.parseStrToMd5U32("fucker"));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLogin() {
		Administer adm = adi.Login(admin);
		if(adm!=null){
			System.out.println("��¼�ɹ����û�����"+adm.getUserName()+"����ʱ�䣺"+adm.getCreated_time()+"�ϴε�¼:"+DateUtil.GetDateFromString(adm.getLast_login()));
		}else{
			System.out.println("��¼ʧ��");
		}
	}

}
