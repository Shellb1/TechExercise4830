import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TechExerciseServlet
 */
@WebServlet("/TechExerciseServlet")
public class TechExerciseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TechExerciseServlet() {
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
		String store = request.getParameter("store");
		String item = request.getParameter("item");
		Integer quantity = null;
		if (request.getParameter("quantity") != null && request.getParameter("quantity") != "") {
			quantity = Integer.valueOf(request.getParameter("quantity"));
		}
		String category = request.getParameter("category");
		if (store == null || item == null || quantity == null || category == null) {
			response.getWriter()
					.println("<h1> Error </h1><p> One of the input options was null. "
							+ "Please enter something into"
							+ " each of the input options. </p><br/n>"
			+ "<a href=/tech-exercise-Shellberg/Home.html>link</a> to return " + "to the previous page. </p>");
		} else {
			Util.createItem(store, item, quantity, category);
			response.getWriter().println("<h1>Successfully inserted! </h1><p>Please click this "
					+ "<a href=/tech-exercise-Shellberg/Home.html>link</a> to return " + "to the previous page. </p>");
		}
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
