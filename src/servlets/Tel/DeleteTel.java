package servlets.Tel;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.util.JSONUtils;
import factories.DaoFactory;
import utils.statics.EncodeUtil;
import utils.statics.JsonUtil;
import model.HttpResult;
import model.Tel;

/**
 * Servlet implementation class DeleteTel
 */
@WebServlet("/DeleteTel")
public class DeleteTel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTel() {
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
			Tel tel = (Tel)JsonUtil.jsonString2Object(jsonString, Tel.class);
			if(DaoFactory.getTelDao().DeleteFriend(tel)){
				hResult.setResult("success");
				hResult.setStatus(200);
			}else{
				hResult.setResult("fail wrong info");
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
