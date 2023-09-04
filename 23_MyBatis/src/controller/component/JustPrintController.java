package controller.component;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.service.StudentService;
import model.vo.StudentVO;

@WebServlet("/JustPrint")
public class JustPrintController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String word = request.getParameter("word");
		System.out.println("controller : "+word);
		List<StudentVO> list = new StudentService().showAllStudent(word);
		
		JSONObject json = new JSONObject();
		
		json.put("list", list);
		
		System.out.println("11" +list.get(0));
		
		PrintWriter out = response.getWriter();
		out.print(json);
		out.close();
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
