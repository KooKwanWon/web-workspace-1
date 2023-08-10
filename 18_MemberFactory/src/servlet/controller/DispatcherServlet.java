package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberVO;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String requestURI = request.getRequestURI();
		System.out.println("RequestURI :: " + requestURI);
		
		String[] requestURIList = requestURI.split("/");
		System.out.println("RequestURIList :: " + Arrays.toString(requestURIList));
		
		String command = requestURIList[requestURIList.length-1];
		System.out.println("Command :: " + command);
		
		Controller controller = HandlerMapping.getInstance().createController(command);
		
		try {
			ModelAndView mv = controller.handle(request, response);
		
			if(mv!=null) {
				if(mv.isRedirect()) {
					response.sendRedirect(mv.getPath());
				}else {
					request.getRequestDispatcher(mv.getPath()).forward(request, response);
				}
				
			}
		} catch (Exception e) {}
		
					
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

//	protected String register(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException, SQLException {
//		// 1. 폼값 가져온다.
//		String id = request.getParameter("id");
//		String password = request.getParameter("password");
//		String name = request.getParameter("name");
//		String address = request.getParameter("address");
//
//		// 2. 객체 생성 - 폼 값 담기
//		MemberVO vo = new MemberVO(id, password, name, address);
//
//		// 3. DAO와 연결
////					MemberDAO dao = new MemberDAO();
//		MemberDAO.getInstance().registerMember(vo);
//
//		// 4. 데이터 바인딩 - session 생략
////			HttpSession session = request.getSession();
////			session.setAttribute("vo", vo);
//
//		return "index.jsp";
//	}
//
//	protected String login(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException, SQLException {
//
//		// 1. 폼 값 받는다.
//		String id = request.getParameter("id");
//		String password = request.getParameter("password");
//
//		MemberVO vo = MemberDAO.getInstance().login(id, password);
//
//		HttpSession session = request.getSession();
//		session.setAttribute("vo", vo);
//
//		return "views/login_result.jsp";
//	}
//
//	protected String allShow(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException, SQLException {
//
//		ArrayList<MemberVO> list = MemberDAO.getInstance().showAllMember();
//		request.setAttribute("list", list);
//
//		return "views/allShow.jsp";
//	}
//
//	protected String findMember(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException, SQLException {
//
//		String id = request.getParameter("id");
//
//		MemberVO vo = MemberDAO.getInstance().findByIdMember(id);
//
//		if (vo != null) {
//			request.setAttribute("vo", vo);
//			return "views/find_ok.jsp";
//		} else {
//			return "views/find_fail.jsp";
//		}
//	}
//
//	protected String update(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException, SQLException {
//
//		HttpSession session = request.getSession();
//
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
//		String name = request.getParameter("name");
//		String addr = request.getParameter("addr");
//
//		System.out.println(pw);
//		MemberVO vo = new MemberVO(id, pw, name, addr);
//
//		session.setAttribute("vo", vo);
//
//		if (MemberDAO.getInstance().update(vo) == 1) {
//			System.out.println("수정성공");
//			return "views/update_result.jsp";
//		} else {
//			System.out.println("수정실패!!");
//			return "views/login_result.jsp";
//		}
//
//	}

}
