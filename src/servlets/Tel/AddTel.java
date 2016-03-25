package servlets.Tel;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.statics.EncodeUtil;
import utils.statics.JsonUtil;
import factories.DaoFactory;
import model.HttpResult;
import model.Tel;

/**
 * Servlet implementation class AddTel
 */
@WebServlet("/AddTel")
public class AddTel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String jsonString = EncodeUtil.toUTF8(request.getParameter("telJson"));
		HttpResult hResult = new HttpResult();
		if(jsonString!=null){
			if(DaoFactory.getTelDao().AddFriend((Tel)JsonUtil.jsonString2Object(jsonString, Tel.class))){
				hResult.setResult("success");
				hResult.setStatus(200);
			}
			else{
				hResult.setResult("fail friend exists");
				hResult.setStatus(202);
			}
		}else{
			hResult.setResult("fail");
			hResult.setStatus(202);
		}
		out.write(JsonUtil.object2JsonString(hResult));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
