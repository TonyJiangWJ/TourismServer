package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.statics.JsonUtil;
import factories.DaoFactory;
import model.HttpResult;
import model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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

		String userName = request.getParameter("userName");
		if(userName!=null)
		{
			String last = userName.substring(11);
			if(last.equals("")){
				userName+="@tourism";
			}
			User loginUser = new User();
			loginUser.setUserName(userName);
			loginUser.setPassword(request.getParameter("password"));
			User result = DaoFactory.getUserDao().Login(loginUser);
			
			String jsonString = JsonUtil.object2JsonString(result);
			if(jsonString==null){
				HttpResult hResult = new HttpResult();
				hResult.setStatus(202);
				hResult.setResult("fail");
				out.write(JsonUtil.object2JsonString(hResult));
			}else{
				out.write(jsonString);
			}
			
		}else{
			HttpResult hResult = new HttpResult();
			hResult.setStatus(202);
			hResult.setResult("fail");
			out.write(JsonUtil.object2JsonString(hResult));
		}
		
	}

}
