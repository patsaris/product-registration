package registration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import registration.dao.productDao;
import registration.model.product;

/**
 * Servlet implementation class productServlet
 */
@WebServlet("/register")
public class productServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private productDao ProductDao;
	
	public void init() {
        ProductDao = new productDao();
    }
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/productregister.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
        String barcode = request.getParameter("barcode");
        String colour = request.getParameter("colour");
        String description = request.getParameter("description");
        

        product product = new product();
        product.setName(name);
        product.setBarcode(barcode);
        product.setColour(colour);
        product.setDescription(description);
        

        try {
            productDao.registerProduct(product);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/productdetails.jsp");
		dispatcher.forward(request, response);
	}

}
