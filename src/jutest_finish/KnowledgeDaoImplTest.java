package jutest_finish;

import static org.junit.Assert.*;

import java.util.ArrayList;

import model.Knowledge;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import utils.statics.DateUtil;
import dao.impl.KnowledgeDaoImpl;

public class KnowledgeDaoImplTest {
	private KnowledgeDaoImpl kdi;
	private Knowledge nlg;
	private ArrayList<Knowledge> nlg_list;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		kdi = new KnowledgeDaoImpl();
		nlg = new Knowledge();
		nlg.setContent("今天是日本大热吧从他们的基本原理中走出来修 修个几把今天是日本大热吧从他们的基本原理中走出来修 修个几把今天是日本大热吧从他们的基本原理中走出来修 修个几把今天是日本大热吧从他们的基本原理中走出来修 修个几把今天是日本大热吧从他们的基本原理中走出来修 修个几把今天是日本大热吧从他们的基本原理中走出来修 修个几把今天是日本大热吧从他"
				+ "们的基本原理中走出来修 修个几把今天是日本大热吧从他们的基本原理中走出来修 修个几把今天是日本大热吧从他们的基本原理中走出来修 修个几把");
		nlg.setPub_time(DateUtil.GetDateString());
		nlg.setNlg_name("日本狗");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() {
		if(kdi.AddNLG(nlg)){
			System.out.println("ADD SUCCESS");
		}else{
			System.out.println("ADD FAIL");
		}
	}
	
	@Test
	public void testDelete(){
		if(kdi.DeleteNLG(nlg)){
			System.out.println("Delete SUCCESS");
		}else{
			System.out.println("Delete FAIL");
		}
	}
	
	@Test
	public void testList(){
		nlg_list = kdi.listKnowledges();
		if(nlg_list!=null){
			for(int i=0;i<nlg_list.size();i++){
				System.out.println("名称："+nlg_list.get(i).getNlg_name()+" 创建时间："+nlg_list.get(i).getNlg_name()
						+" 内容："+nlg_list.get(i).getContent());
			}
		}else{
			System.out.println("EMPTY");
		}
	}

}
