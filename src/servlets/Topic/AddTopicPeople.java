package servlets.Topic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HttpResult;
import model.Topic;
import utils.statics.EncodeUtil;
import utils.statics.JsonUtil;
import factories.DaoFactory;

/**
 * Servlet implementation class AddTopicPeople
 */
@WebServlet("/AddTopicPeople")
public class AddTopicPeople extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTopicPeople() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String str = request.getParameter("jsonTopic");
		boolean flag = false;
		if(str!=null){
			str = EncodeUtil.toUTF8(str);
			Topic tpc = new Topic();
			tpc.setTpc_name(str);
			if(DaoFactory.getTopicDao().AddPeople(tpc)){
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
