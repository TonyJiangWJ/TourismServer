package servlets.Package;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factories.DaoFactory;
import model.HttpResult;
import model.Packages;
import utils.statics.EncodeUtil;
import utils.statics.JsonUtil;

/**
 * Servlet implementation class AdjustPackage
 */
@WebServlet("/AdjustPackage")
public class AdjustPackage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdjustPackage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean flag = true;
		PrintWriter out  = response.getWriter();
		String jsonPkg = request.getParameter("jsonPkg");
		if(jsonPkg!=null){
			jsonPkg = EncodeUtil.toUTF8(jsonPkg);
			Packages pkg = (Packages) JsonUtil.jsonString2Object(jsonPkg, Packages.class);
			flag = DaoFactory.getPackagesDao().AdjustPackage(pkg);
		}else
			flag = false;
		HttpResult hResult	= new HttpResult(flag);
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
