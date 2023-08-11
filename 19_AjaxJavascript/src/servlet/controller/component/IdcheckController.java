package servlet.controller.component;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.controller.Controller;
import servlet.controller.ModelAndView;
import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberVO;

/**
 * Servlet implementation class IdcheckServlet
 */
public class IdcheckController implements Controller {

   	
	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		
		MemberVO vo = MemberDAO.getInstance().findByIdMember(id);
		
		if(vo!=null) {
			out.print(id + " 중복된 아이디입니다.");
		}else {
			out.print(id + " 사용 가능한 아이디입니다.");
		}
		System.out.println(id);
		
		
		return null;
	}

}
