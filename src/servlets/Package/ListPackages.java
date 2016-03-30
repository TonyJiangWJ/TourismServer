package servlets.Package;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HttpResult;
import model.Packages;
import factories.DaoFactory;
import utils.statics.EncodeUtil;
import utils.statics.JsonUtil;

/**
 * Servlet implementation class ListPackages
 */
@WebServlet("/ListPackages")
public class ListPackages extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListPackages() {
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
		String jsonPkg = request.getParameter("jsonPkg");
		if(jsonPkg!=null){
			jsonPkg = EncodeUtil.toUTF8(jsonPkg);
			ArrayList<Packages> pkg_list = DaoFactory.getPackagesDao().ListPackages();
			if(pkg_list==null)
				flag=false;
			else {
				out.write(JsonUtil.javaList2JsonList(pkg_list));
			}
		}else{
			flag=false;
		}
		if(flag==false)
		{
			HttpResult httpResult = new HttpResult(false);
			out.write(JsonUtil.object2JsonString(httpResult));
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
