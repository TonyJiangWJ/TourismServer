package jutest_finish;

import static org.junit.Assert.*;

import java.util.ArrayList;

import model.Plan;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import utils.statics.DateUtil;
import dao.impl.PlanDaoImpl;

public class PlanDaoImplTest {
	private PlanDaoImpl pdi;
	private Plan plan;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		pdi = new PlanDaoImpl();
		plan = new Plan();
		plan.setActive_time("2016-12-11");
		plan.setCreated_time(DateUtil.GetDateString());
		plan.setStart_time("2016-11-01");
		plan.setEnd_time("2016-12-10");
		plan.setContent("xixihaha才此次");
		plan.setDestination("杭州");
		plan.setPl_name("xixi啊adfs");
		plan.setPeople_num(12);
		plan.setPrice(123.45);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() {
		if(pdi.AddPlan(plan)){
			System.out.println("add success");
		}else{
			System.out.println("add fail");
		}
	}
	
	@Test
	public void testList() {
		ArrayList<Plan> plan_list = pdi.ListPlan();
		for(int i=0;i<plan_list.size();i++){
			System.out.println("方案名称"+plan_list.get(i).getPl_name()
					+" 创建时间 "+plan_list.get(i).getCreated_time()+"人数"+plan_list.get(i).getPeople_num());
		}
	}
	
	@Test
	public void testDelete() {
		if(pdi.DeletePlan(plan)){
			System.out.println("delete success");
		}else{
			System.out.println("delete fail");
		}
	}

}
