package jutest_finish;

import static org.junit.Assert.*;

import java.util.ArrayList;

import model.Comment;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import utils.statics.DateUtil;
import utils.statics.UTools;
import dao.impl.CommentDaoImpl;

public class CommentDaoImplTest {
	private CommentDaoImpl cdi;
	private Comment comt;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		cdi = new CommentDaoImpl();
		comt = new Comment();
		comt.setType(UTools.NLG);
		comt.setUserName("17866476644@tourism");
		comt.setTo_user("17866476633@tourism");
		comt.setName("日本狗");
		comt.setPub_time(DateUtil.GetDateString());
		comt.setContent("我日你血妈");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() {
		if(cdi.AddComment(comt)){
			System.out.println("Add Success");
		}else{
			System.out.println("Add fail");
		}
		
	}
	
//	@Test
//	public void testDelete(){
//		if(cdi.DeleteComment(comt)){
//			System.out.println("Delete success");
//		}else{
//			System.out.println("Delete fail");
//		}
//	}
	
	@Test
	public void testList(){
		ArrayList<Comment> cmt_list = cdi.ListComment(comt);
		for(int i=0;i<cmt_list.size();i++){
			System.out.println("用户："+cmt_list.get(i).getUserName()+" 时间："
		+cmt_list.get(i).getPub_time()+" 回复："+cmt_list.get(i).getTo_user()
		+" 内容："+cmt_list.get(i).getContent());
		}
	}

}
