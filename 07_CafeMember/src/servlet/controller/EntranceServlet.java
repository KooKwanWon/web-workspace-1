package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberVO;

/**
 * 회원 가입하면.. 정보를 바탕으로 MemberVO를 생성..ArrayList에 추가
 * ArrayList를 통째로 ServletContext에 바인딩
 * 출력 결과는 viewMember.jsp 페이지에서 
 */

public class EntranceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext context;
	List<MemberVO> list = Collections.synchronizedList(new ArrayList());
	
	public void init(ServletConfig config) throws ServletException {
		
//		context = config.getServletContext();
//		context.setAttribute("list", list);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("list", list);
		
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		int age = request.getParameter("age")!=null ? Integer.parseInt(request.getParameter("age")) : 0;
		String addr = request.getParameter("addr");
		
		
		if(name!=null) {	
			MemberVO vo = new MemberVO(name, age, addr);
			list.add(vo);
		}
		
		// 내비게이션
		RequestDispatcher rdp = request.getRequestDispatcher("viewMember.jsp");
		// PrintWriter out = response.getWriter(); 대신 설정
		rdp.forward(request, response); // 이때 위에 설정한 페이지로 이동됨 result.jsp
		
//		out.println("<a href='viewMember.jsp'>회원정보 출력</a>");
		
		out.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
