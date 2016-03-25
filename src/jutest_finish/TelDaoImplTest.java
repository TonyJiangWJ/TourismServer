package jutest_finish;

import static org.junit.Assert.*;

import java.util.ArrayList;

import model.Tel;
import model.User;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import utils.statics.JsonUtil;
import dao.impl.TelDaoImpl;

public class TelDaoImplTest {
	private TelDaoImpl tdi;
	private Tel tel;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		tdi = new TelDaoImpl();
		tel = new Tel();
		tel.setFriendName("17866476633@tourism");
		tel.setOwner("17866476644@tourism");
		System.out.println(JsonUtil.object2JsonString(tel));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() {
		if(tdi.AddFriend(tel)){
			System.out.println("add success");
		}else{
			System.out.println("add fail");
		}
//		fail("Not yet implemented");
	}
	
//	@Test
//	public void testDelete() {
//		if(tdi.DeleteFriend(tel)){
//			System.out.println("delete success");
//		}else{
//			System.out.println("delete fail");
//		}
////		fail("Not yet implemented");
//	}

	@Test
	public void testList() {
		ArrayList<User> user_list = tdi.ListAll(tel);
		
		for(int i=0;i<user_list.size();i++){
			if(i==0){
				System.out.println("Ыљгаеп"+tel.getOwner());
			}
			System.out.println(i+":"+user_list.get(i).getName()+" phone:"+user_list.get(i).getPhone());
		}
//	fail("Not yet implemented");
	}
}
