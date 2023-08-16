package servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import servlet.model.Member;

/**
 * Servlet implementation class JsonAjax
 */
@WebServlet("/JsonAjax")
public class JsonAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		JSONObject json = new JSONObject();
	
//		json.put("name", "Jason");
//		json.put("age", 20);
//		json.put("addr", "Texas");
		
		Member member = new Member("Jason", 20, "Texas");
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(member);
		
		json.put("result", result);
		
		PrintWriter out = response.getWriter();
		out.print(json);
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
