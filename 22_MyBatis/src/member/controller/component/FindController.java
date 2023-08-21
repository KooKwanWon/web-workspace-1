package member.controller.component;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.controller.Controller;
import member.controller.ModelAndView;
import member.model.dao.MemberDAO;
import member.model.service.MemberService;
import member.model.vo.MemberVO;

public class FindController implements Controller {

	public FindController() {}

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "views/find_fail.jsp";
	
		String id = request.getParameter("id");
		String address = request.getParameter("address");
		
		
		MemberVO vo = new MemberVO();
		if(id!="") {
			vo.setId(id);
		}
		if(address!=""){
			vo.setAddress(address);
		}
		
		List<MemberVO> list = new MemberService().findByIdMember(vo);
		
//		System.out.println(vo.getId());
		
		if(list!=null) {
			request.setAttribute("list", list);
			path = "views/allShow.jsp";
		}
//		System.out.println(path);
		
		return new ModelAndView(path);
	}
	
	
	
}
