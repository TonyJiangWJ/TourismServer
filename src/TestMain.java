import java.sql.Connection;
import java.util.Date;

import net.sf.json.JSONObject;
import model.Administer;
import model.HttpResult;
import model.Topic;
import model.User;
import dao.impl.AdminDaoImpl;
import dao.impl.UserDaoImpl;
import utils.DBUtil;
import utils.statics.DateUtil;
import utils.statics.JsonTool;
import utils.statics.JsonUtil;
import utils.statics.ParseMD5;
import utils.statics.UTools;


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
//		user.setSex("��");
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
//			System.out.println("��¼�ɹ����û�����"+adm.getUserName()+"����ʱ�䣺"+adm.getCreated_time()+"�ϴε�¼:"+adm.getLast_login());
//		}else{
//			System.out.println("��¼ʧ��");
//		}
//		Topic tpc = new Topic();
//		tpc.setContent("��С�ձ����ӣ��ݷ����ǵ�����");
//		tpc.setPeople_num(2333);
//		tpc.setPub_time("2016-12-11");
//		tpc.setTpc_name("���ձ�");
//		JSONObject json = JsonUtil.object2JsonObj(tpc);
//		
//		HttpResult httpResult = new HttpResult();
//		httpResult.setResult("success");
//		httpResult.setStatus(200);
//		
//		JSONObject json2 = JSONObject.fromObject(httpResult);
//		System.out.println(json.toString());
//		System.out.println(json2.toString());
//		Topic tpcTopic = (Topic) JsonUtil.jsonString2Object(json.toString(),Topic.class);
//		Topic tpcTopic3 = (Topic) JsonUtil.jsonString2Object(json2.toString(), Topic.class);
//		Topic tpcTopic2 = JsonTool.toBean(json2.toString(), Topic.class);
//		boolean flag = tpcTopic.getClass() != null;
//		System.out.println("flag:"+flag+" tcp2:"+tpcTopic2+" content:"+tpcTopic2.getContent()+","+tpcTopic2.getPub_time());
		String name = "fuckerasfdasdfasdfasdfasdfasdfasf";
		
//		String dString = String.valueOf(date);
		String createDateString = "2016-03-24 09:06:19";
		String createDateString2 = "2016-03-24 09:06:20";
		Date date = DateUtil.GetDateFromString(createDateString);
		Date date2 = DateUtil.GetDateFromString(createDateString2);
		String Id = UTools.getUniqueId("faker1faker1faker1faker1faker1faker1faker1faker1faker1faker1faker1faker1",date.toString());
		String id2 = UTools.getUniqueId("faker1faker1faker1faker1faker1faker1faker1faker1faker1faker1faker1faker1",date2.toString());
		System.out.println(Id);
		System.out.println(id2);
	
	}

}
