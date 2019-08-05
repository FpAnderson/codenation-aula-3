package challenge;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/v1/quote/*")
public class QuoteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Quote quote;
			QuoteDao qDAO = new QuoteDao();
			String pathInfo = req.getPathInfo();
			if (pathInfo == null || pathInfo.equals("/")) {
				quote = qDAO.getQuote();
			} else {
				String actor = pathInfo.split("/")[1];
				quote = qDAO.getQuoteByActor(actor);
			}

			ObjectMapper Obj = new ObjectMapper();

			String jsonStr = Obj.writeValueAsString(quote);

			PrintWriter out = resp.getWriter();
			out.print(jsonStr);
			out.flush();

			resp.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}

}
