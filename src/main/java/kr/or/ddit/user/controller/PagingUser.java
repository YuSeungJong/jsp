package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

@WebServlet("/pagingUser")
public class PagingUser extends HttpServlet{
	private UserServiceI userService = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//left.jsp : /pagingUser?page=1&pageSize=5
		//	===>	 /pagingUser
		
		//doGet 메소드에서 page, pageSize 파라미터가 request 객체에 존재 하지 않을 때
		// page는 1로, pageSize 5로 생각을 코드를 작성
		// 파라미터가 존재하면 해당 파라미터를 이용
		
		// primitive Type ==> class(Wrapper) Integer
		//refactoring : 코드를 (깔끔하게) 바꾸는데 기존 동작방식을 유진한채로 변경하는 기법
		
		int page = req.getParameter("page") == null ? 1: Integer.parseInt(req.getParameter("page"));
		int pageSize = req.getParameter("pageSize") == null ? 5: Integer.parseInt(req.getParameter("pageSize"));
		
		/*
		 * request객체에서 제공하는 파라미터 관련 메소드
		 * 
		 */
		
		PageVo pageVo = new PageVo(page, pageSize);
		
		Map<String, Object> map = userService.selectPagingUser(pageVo);
		
		List<UserVO> userList = (List<UserVO>)map.get("userList");
		
		int userCnt = (int)map.get("userCnt");
		int pagination = (int)Math.ceil((double) userCnt/ pageSize);
		
		req.setAttribute("userList", userList);
		req.setAttribute("pagination", pagination);
		req.setAttribute("pageVo", pageVo);
		
		req.getRequestDispatcher("/user/pagingUser.jsp").forward(req, resp);
	}
}















