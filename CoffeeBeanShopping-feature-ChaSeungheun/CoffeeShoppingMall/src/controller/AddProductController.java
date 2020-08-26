package controller;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import product.service.proService;
import product.service.proServiceImpl;

@WebServlet("/addProduct.do")
public class AddProductController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		proService service = new proServiceImpl();

		String webpath = "/resources/img/products/";
		ServletContext application = request.getServletContext();
		String realPath = application.getRealPath(webpath);

		int maxSize = 1024 * 1024 * 10;
		
		MultipartRequest mr = new MultipartRequest(request, realPath, maxSize, "utf-8", new DefaultFileRenamePolicy());
		File file = mr.getFile("img");
	
		if(file != null) {
			String name = mr.getParameter("name");
			int price = Integer.parseInt(mr.getParameter("price"));
			String img = "/resources/img/products/" + file.getName();
			String region = mr.getParameter("region");
			String country = mr.getParameter("country");
			String description = mr.getParameter("description");
			
			service.addProduct(name, price, img, region, country, description);
		}
		
		request.setAttribute("products", service.getAllProduct());

		request.getRequestDispatcher("/admin/productControl.jsp").forward(request, response);
	}

}
