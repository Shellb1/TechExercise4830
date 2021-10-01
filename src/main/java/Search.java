
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Search() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.getWriter().println("<h1>Results:</h1>");
		String store = request.getParameter("store");
		String item = request.getParameter("item");
		String category = request.getParameter("category");
		List<ItemModel> items = new ArrayList<ItemModel>();
		if (store == "") {
			store = null;
		}
		if (item == "") {
			item = null;
		}
		if (category == "") {
			category = null;
		}
		if (store == null && item == null && category == null) {
			items = Util.getAll();
		} else {
			items = Util.query(store, item, category);
		}
		items.forEach(itemModel -> {
			try {
				response.getWriter().println("<li>" + itemModel.toString() + "</li>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		response.getWriter().println("<p>Please click this "
				+ "<a href=/tech-exercise-Shellberg/Search.html>link</a> to return " + "to the previous page. </p>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
