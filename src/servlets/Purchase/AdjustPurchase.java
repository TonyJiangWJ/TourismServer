package servlets.Purchase;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HttpResult;
import model.Purchase;
import utils.statics.EncodeUtil;
import utils.statics.JsonUtil;
import factories.DaoFactory;

/**
 * Servlet implementation class AdjustPurchase
 */
@WebServlet("/AdjustPurchase")
public class AdjustPurchase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdjustPurchase() {
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
		String jsonPsh = request.getParameter("jsonPsh");
		if(jsonPsh!=null){
			jsonPsh = EncodeUtil.toUTF8(jsonPsh);
			Purchase psh = (Purchase) JsonUtil.jsonString2Object(jsonPsh, Purchase.class);
			flag = DaoFactory.getPurchaseDao().AdjustPurchase(psh);
		}else{
			flag = false;  
		}
		HttpResult hResult = new HttpResult(flag);
		out.write(JsonUtil.object2JsonString(hResult));
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
