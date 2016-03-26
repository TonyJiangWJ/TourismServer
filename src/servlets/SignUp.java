package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import factories.DaoFactory;
import utils.statics.DateUtil;
import utils.statics.EncodeUtil;
import utils.statics.JsonUtil;
import model.User;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String jsonString = request.getParameter("SignUpInfo");
		if(jsonString!=null){
			jsonString = EncodeUtil.toUTF8(jsonString);
			User signUser = (User)JsonUtil.jsonString2Object(jsonString, User.class);
			if(DaoFactory.getUserDao().SignUp(signUser)){
				JSONObject json = new JSONObject();
				json.put("status", 200);
				json.put("result", "success");
				out.write(json.toString());
			}else{
				JSONObject json = new JSONObject();
				json.put("status", 202);
				json.put("result", "fail");
				out.write(json.toString());
			}
		}else{
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			if(userName!=null&&password!=null){
				User signUser = new User();
				signUser.setCreated_time(DateUtil.GetDateString());
				signUser.setImage("default");
				signUser.setName("null");
				signUser.setNickName("null");
				signUser.setPassword(password);
				signUser.setSex("ÄÐ");
				signUser.setPhone(userName);
				signUser.setUserName(userName+"@tourism");
				
				if(userName!=null&&DaoFactory.getUserDao().SignUp(signUser)){
					JSONObject json = new JSONObject();
					json.put("status", 200);
					json.put("result", "success");
					out.write(json.toString());
				}else{
					JSONObject json = new JSONObject();
					json.put("status", 202);
					json.put("result", "fail");
					out.write(json.toString());
				}
			}else{
				JSONObject json = new JSONObject();
				json.put("status", 202);
				json.put("result", "fail");
				out.write(json.toString());
			}
		}
	}

}
