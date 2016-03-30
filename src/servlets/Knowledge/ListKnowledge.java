package servlets.Knowledge;

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
import utils.statics.JsonUtil;
import model.HttpResult;
import model.Knowledge;

/**
 * Servlet implementation class ListKnowledge
 */
@WebServlet("/ListKnowledge")
public class ListKnowledge extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListKnowledge() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		ArrayList<Knowledge> nlg_list = DaoFactory.getKnowledgeDao().listKnowledges(); 
		if(nlg_list==null){
			HttpResult hResult = new HttpResult(false);
//			hResult.setResult("fail");
//			hResult.setStatus(202);
			out.write(JsonUtil.object2JsonString(hResult));
		}else{
//			JSONArray jsonArray = new JSONArray();
//			for(int i=0;i<nlg_list.size();i++){
//				JSONObject jsonObj = JsonUtil.object2JsonObj(nlg_list.get(i));
//				jsonArray.add(jsonObj);
//			}
//			out.write(jsonArray.toString());
			out.write(JsonUtil.javaList2JsonList(nlg_list));
		}
//		out.write("finish");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
