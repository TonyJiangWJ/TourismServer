package servlets.Plan;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HttpResult;
import model.Plan;
import factories.DaoFactory;
import utils.statics.EncodeUtil;
import utils.statics.JsonUtil;

/**
 * Servlet implementation class DeletePlan
 */
@WebServlet("/DeletePlan")
public class DeletePlan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePlan() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String str = request.getParameter("planName");
		boolean flag = false;
		if(str!=null){
			str = EncodeUtil.toUTF8(str);
			Plan plan = new Plan();
			plan.setPl_name(str);
			if(DaoFactory.getPlanDao().DeletePlan(plan)){
				flag=true;
			}
		}else{
			flag=false;
		}
		HttpResult hResult = new HttpResult();
		hResult.setStatus(flag?200:202);
		hResult.setResult(flag?"success":"fail");
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
