package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Member;
import model.MemberDAO;
/**
 * 회원과 관련된 요청을 받고 처리하는 controller 서블릿
 */
public class MemberServ extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			process(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			process(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		request.setCharacterEncoding("EUC-KR");
		String command = request.getParameter("command");
		MemberDAO mbd = MemberDAO.getIntance();
		PrintWriter out = response.getWriter();
		
		if (command.equals("insert")) {
			insert(request, response);
		} else if (command.equals("delete")) {
			delete(request, response);
		} else if (command.equals("update")) {
			update(request, response);
		} else if (command.equals("login")) {
			Member mem = mbd.checkMember(request.getParameter("id"), request.getParameter("password"));
			if (mem != null) {
				request.getSession().setAttribute("mem", mem);
				out.println("<script>alert('Welcome to Movie Gallery' , (function(){location.href='loginSuccess.jsp';})());</script>");
			} else {
				response.sendRedirect("loginFail.jsp");
			}
		} else if (command.equals("logout")) {
			HttpSession session = request.getSession();
			session.invalidate();
			session = null;
			response.sendRedirect("index.jsp");
		}
	} // end of process()

	public void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		response.setContentType("text/html;charset=EUC-KR");
		String id = request.getParameter("id").trim();
		String password = request.getParameter("password").trim();
		String name = request.getParameter("name").trim();
		String phone = request.getParameter("phone").trim();
		String email = request.getParameter("email").trim();
		Member mem = new Member(id, password, name, phone, email);
		MemberDAO md = MemberDAO.getIntance();
		PrintWriter out = response.getWriter();
		
		try {
			md.joinMemeber(mem);
		} catch (SQLException e) {
			response.sendRedirect("error.jsp");
			e.printStackTrace();
		}
		out.println("<script>alert('Member Join Success' , (function(){location.href='index.jsp';})());</script>");
	} // end of insert()

	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			MemberDAO.deleteMemeber(id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			HttpSession session = request.getSession();
			session.invalidate();
			session = null;
			response.sendRedirect("afterResign.jsp");
		}
	} // end of delete()

	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		String id = request.getParameter("id").trim();
		String password = request.getParameter("password").trim();
		String name = request.getParameter("name").trim();
		String phone = request.getParameter("phone").trim();
		String email = request.getParameter("email").trim();
		
		try {
			Member mem = new Member(id, password, name, phone, email);
			MemberDAO.updateMemeber(mem);
			request.getSession().setAttribute("mem", mem);
			response.sendRedirect("afterUpdate.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // end of update()
} // end of class