package servlets.Plan;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factories.DaoFactory;
import utils.statics.EncodeUtil;
import utils.statics.JsonUtil;
import model.HttpResult;
import model.Plan;

/**
 * Servlet implementation class AddPlan
 */
@WebServlet("/AddPlan")
public class AddPlan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPlan() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String json = request.getParameter("jsonPlan");
		boolean flag = false;
		if(json!=null){
			json = EncodeUtil.toUTF8(json);
			Plan plan = (Plan)JsonUtil.jsonString2Object(json, Plan.class);
			if(DaoFactory.getPlanDao().AddPlan(plan)){
				flag=true;
			}
		}else{
			flag=false;
		}
		HttpResult hResult = new HttpResult();
		hResult.setResult(flag?"success":"fail");
		hResult.setStatus(flag?200:202);
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
