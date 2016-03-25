package servlets.Knowledge;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factories.DaoFactory;
import model.HttpResult;
import model.Knowledge;
import utils.statics.EncodeUtil;
import utils.statics.JsonUtil;

/**
 * Servlet implementation class DeleteKnowledge
 */
@WebServlet("/DeleteKnowledge")
public class DeleteKnowledge extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteKnowledge() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		String str = request.getParameter("jsonKnowledge");
		boolean flag = false;
		if(str!=null){
			str = EncodeUtil.toUTF8(str);
			Knowledge nlg = (Knowledge)JsonUtil.jsonString2Object(str, Knowledge.class);
			if(DaoFactory.getKnowledgeDao().DeleteNLG(nlg)){
				flag=true;
			}
		}else{
			str = request.getParameter("nlgName");
			if(str!=null){
				str = EncodeUtil.toUTF8(str);
				Knowledge nlg = new Knowledge();
				nlg.setNlg_name(str);
				if(DaoFactory.getKnowledgeDao().DeleteNLG(nlg)){
					flag=true;
				}
			}else{
				flag=false;
			}
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
