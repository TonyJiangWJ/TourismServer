package jutest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import model.Tel;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
		tel.setFriendName("17866476644@tourism");
		tel.setOwner("asdf");
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
		ArrayList<Tel> tel_list = tdi.ListFriend(tel);
		
		for(int i=0;i<tel_list.size();i++){
			if(i==0){
				System.out.println("Ыљгаеп"+tel.getOwner());
			}
			System.out.println(i+":"+tel_list.get(i).getFriendName());
		}
//	fail("Not yet implemented");
	}
}
