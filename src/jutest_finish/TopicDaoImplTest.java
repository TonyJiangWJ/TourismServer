package jutest_finish;

import static org.junit.Assert.*;

import java.util.ArrayList;

import model.Topic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.impl.TopicDaoImpl;

public class TopicDaoImplTest {
	private TopicDaoImpl tdi;
	private Topic tpc;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		tdi = new TopicDaoImpl();
		tpc = new Topic();
		tpc.setContent("大到小日本鬼子，草饭他们的娘萌");
		tpc.setPeople_num(2333);
		tpc.setPub_time("2016-12-11");
		tpc.setTpc_name("操日本");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() {
		if(tdi.AddTopic(tpc)){
			System.out.println("ADD　ＳＵＣＣＥＳＳ");
		}else{
			System.out.println("ADD ＦＡＩＬ");
		}
	}
	 
	@Test
	public void testDelete(){
		if(tdi.DeleteTopic(tpc)){
			System.out.println("删除成功");
		}else{
			System.out.println("删除失败");
		}
	}
	
	@Test
	public void testList(){
		ArrayList<Topic> tpc_list = tdi.ListTopic();
		if(tpc_list!=null){
			for(int i=0;i<tpc_list.size();i++){
				System.out.println("话题名字："+tpc_list.get(i).getTpc_name()+" 话题人气："+tpc_list.get(i).getPeople_num()+" 话题内容："+tpc_list.get(i).getContent()+" 话题创建时间："+tpc_list.get(i).getPub_time());
			}
		}else{
			System.out.println("EMPTY");
		}
	}

}
