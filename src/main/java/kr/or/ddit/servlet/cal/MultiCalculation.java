package kr.or.ddit.servlet.cal;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/multiCalculation")
public class MultiCalculation extends HttpServlet{
	private static final Logger logger = LoggerFactory.getLogger(MultiCalculation.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/jsp/multi.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int scopeParameter1 = Integer.parseInt(req.getParameter("start"));
		int scopeParameter2 = Integer.parseInt(req.getParameter("end"));
		
		int result = 1;
		
		for(int i = scopeParameter1; i<=scopeParameter2; i++ ) {
			result *= i;
		}
		
		HttpSession session = req.getSession();
		session.setAttribute("session", result);
		
		req.getRequestDispatcher("/jsp/multiResult.jsp").forward(req, resp);
	
	}
}
