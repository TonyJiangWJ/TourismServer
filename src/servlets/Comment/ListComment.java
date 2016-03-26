package servlets.Comment;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Comment;
import model.HttpResult;
import model.Plan;
import utils.statics.EncodeUtil;
import utils.statics.JsonUtil;
import factories.DaoFactory;

/**
 * Servlet implementation class ListComment
 */
@WebServlet("/ListComment")
public class ListComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListComment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String json = request.getParameter("jsonComm");
		if(json!=null){
			json = EncodeUtil.toUTF8(json);
			Comment comt = (Comment)JsonUtil.jsonString2Object(json, Comment.class);

			ArrayList<Comment> comt_list = DaoFactory.getCommentDao().ListComment(comt); 
			if(comt_list==null){
				HttpResult hResult = new HttpResult();
				hResult.setResult("fail");
				hResult.setStatus(202);
				out.write(JsonUtil.object2JsonString(hResult));
			}
			else{
				out.write(JsonUtil.javaList2JsonList(comt_list));
			}
		}else{
			HttpResult hResult = new HttpResult();
			hResult.setResult("fail");
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
