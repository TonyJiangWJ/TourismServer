package servlets.Tel;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import factories.DaoFactory;
import utils.statics.EncodeUtil;
import utils.statics.JsonUtil;
import model.HttpResult;
import model.Tel;
import model.User;

/**
 * Servlet implementation class ListTel
 */
@WebServlet("/ListTel")
public class ListTel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListTel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String userName = EncodeUtil.toUTF8(request.getParameter("userName"));
		
		if(userName!=null){
			Tel tel = new Tel();
			tel.setOwner(userName);
			ArrayList<User> userList = DaoFactory.getTelDao().ListAll(tel);
			JSONArray jsonArray = new JSONArray();
			for(int i=0;i<userList.size();i++){
				JSONObject jsonObject = JSONObject.fromObject(userList.get(i));
				jsonArray.add(jsonObject);
			}
			
			out.write(jsonArray.toString());
		}else{
			HttpResult hResult = new HttpResult();
			hResult.setResult("»ñÈ¡Ê§°Ü");
			hResult.setStatus(202);
			out.write(JsonUtil.object2JsonString(hResult));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
