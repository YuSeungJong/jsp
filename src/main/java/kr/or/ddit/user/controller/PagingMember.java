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
import kr.or.ddit.user.model.MemberVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

@WebServlet("/pagingMember")
public class PagingMember extends HttpServlet{
	UserServiceI userService = new UserService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int page = req.getParameter("page") == null ? 1 : Integer.parseInt(req.getParameter("page"));
		int pageSize = req.getParameter("pageSize") == null ? 1 : Integer.parseInt(req.getParameter("pageSize"));
		
		PageVo pageVo = new PageVo(page, pageSize);
		
		Map<String, Object> map = userService.selectPagingMember(pageVo);
		
		List<MemberVo> memList = (List<MemberVo>)map.get("memList");
		
		int memberCnt = (int)map.get("memberCnt");
		int pagination = (int)Math.ceil((double) memberCnt/ pageSize);
		
		req.setAttribute("memList", memList);
		req.setAttribute("pagination", pagination);
		req.setAttribute("pageVo", pageVo);
		
		req.getRequestDispatcher("/member/pagingMember.jsp").forward(req, resp);
	}
}















