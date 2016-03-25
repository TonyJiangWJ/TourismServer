package servlets.Plan;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HttpResult;
import model.Knowledge;
import model.Plan;
import utils.statics.JsonUtil;
import factories.DaoFactory;

/**
 * Servlet implementation class ListPlan
 */
@WebServlet("/ListPlan")
public class ListPlan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListPlan() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		ArrayList<Plan> pl_list = DaoFactory.getPlanDao().ListPlan(); 
		if(pl_list==null){
			HttpResult hResult = new HttpResult();
			hResult.setResult("fail");
			hResult.setStatus(202);
			out.write(JsonUtil.object2JsonString(hResult));
		}else{
			out.write(JsonUtil.javaList2JsonList(pl_list));
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
