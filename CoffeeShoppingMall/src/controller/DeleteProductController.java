package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import product.service.proService;
import product.service.proServiceImpl;

@WebServlet("/delProduct.do")
public class DeleteProductController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		proService service = new proServiceImpl();
		int id = Integer.parseInt(request.getParameter("id"));
		Product product = service.getProduct(id);
		ServletContext application = request.getServletContext();
		String realPath = application.getRealPath(product.getPro_img());
		System.out.println("path : " + realPath);
		File file = new File(realPath);
		if (file.exists()) {
			file.delete();
		}
		service.delProduct(id);

		request.setAttribute("products", service.getAllProduct());

		request.getRequestDispatcher("/admin/productControl.jsp").forward(request, response);
	}

}
