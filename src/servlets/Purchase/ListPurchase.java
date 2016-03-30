package servlets.Purchase;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factories.DaoFactory;
import model.HttpResult;
import model.Purchase;
import model.User;
import utils.statics.EncodeUtil;
import utils.statics.JsonUtil;

/**
 * Servlet implementation class ListPurchase
 */
@WebServlet("/ListPurchase")
public class ListPurchase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListPurchase() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		boolean flag = true;
		String jsonUser = request.getParameter("jsonUser");
		if(jsonUser!=null){
			jsonUser = EncodeUtil.toUTF8(jsonUser);
			User usr = (User) JsonUtil.jsonString2Object(jsonUser, User.class);
			ArrayList<Purchase> psh_list = new ArrayList<Purchase>();
			psh_list = DaoFactory.getPurchaseDao().ListPurchases(usr);
			if(psh_list!=null){
				out.write(JsonUtil.javaList2JsonList(psh_list));
			}else{
				flag = false;
			}
		}else{
			flag = false;
		}
		if(flag == false){
			HttpResult hResult = new HttpResult(false);
			out.write(JsonUtil.object2JsonString(hResult));
		}
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


}
