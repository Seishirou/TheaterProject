package controller;

import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Movie;
import model.MovieDAO;
import model.Reserve;
import model.ReserveDAO;
import model.Theater;
import model.TheaterDAO;
import model.ThtrPlaySeq;
import model.ThtrPlaySeqDAO;
import util.DBUtil;
/**
 * 영화검색, 극장검색, 예매와 관련된 요청을 받고 처리하는 controller 서블릿
 */
public class TheaterServ extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		String command = request.getParameter("command");
		List<Movie> list = new ArrayList<>();
		MovieDAO md = MovieDAO.getInstance();
		
		if(command.equals("searchByThtrNm")){
			searchByThtrNm(request, response);
		} else if(command.equals("searchByMovieNm")){
			try {
				searchByMovieNm(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if(command.equals("searchTheaterByMovie")){
			try {
				searchTheaterByMovie(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if(command.equals("displayTimeTable")){
			try {
				displayTimeTable(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if(command.equals("reserveMovie")){
			try {
				reserveMovie(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if(command.equals("searchByTitle")){
			try {
				list = md.searchByMovieNm(request.getParameter("title"));
				request.getSession().setAttribute("list", list);
				response.sendRedirect("movieList.jsp");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if(command.equals("searchByPeriod")){
			try {
				list = md.searchByPlayPeriod(request.getParameter("periodStart"), request.getParameter("periodEnd"));
				request.getSession().setAttribute("list", list);
				response.sendRedirect("movieList.jsp");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if(command.equals("reserve")){
			try {
				list = md.searchReservable();
				request.setAttribute("list", list);
				request.getSession().setAttribute("FOR_RESERVE", true);
				request.getRequestDispatcher("reserveMovieList.jsp").forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}								
	} // end of process()
	
	private void reserveMovie(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		ReserveDAO rDao = ReserveDAO.getInstance();
		HttpSession session = request.getSession();
		Reserve r = (Reserve) session.getAttribute("reserve");
		String thtrCd = r.getThtrCd();
		String watchDate = r.getWatchDate();
		int playSeq = Integer.parseInt(request.getParameter("seq"));
		int qntty = Integer.parseInt(request.getParameter("qntty"));
		int result = 0;
		int cnt = 0;

		for (int i = 0; i < qntty; i++) {
			Reserve r2 = rDao.selectLastSeatNo(thtrCd, watchDate, playSeq);
			int seatNo = r2.getSeatNo();	
			r.setPlaySeq(playSeq);
			r.setSeatNo(seatNo + 1);
			result = rDao.insertReserve(r);
			cnt += result;
		}
		List<Reserve> list = rDao.selectReserveList("user9", thtrCd, watchDate, playSeq);
		if(result != 0){
			request.setAttribute("list", list);
			request.getRequestDispatcher("reserveSuccess.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("reserveFail.jsp").forward(request, response);
		}
	} // end of reserveMovie()

	public void displayTimeTable(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		ThtrPlaySeqDAO tpsDao = ThtrPlaySeqDAO.getInstance();
		String movieCd = request.getParameter("movieCd");
		String thtrCd = request.getParameter("thtrCd");
		String userdate = request.getParameter("userDate");	
		List<ThtrPlaySeq> list = tpsDao.displayTimeTable(thtrCd, movieCd);
		request.setAttribute("list", list);
		String url = null;
		url = "displayTimeTable.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	} // end of displayTimeTable()
	
	public void searchTheaterByMovie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		TheaterDAO tDao = TheaterDAO.getInstance();
		String url = null;
		String movieCd = request.getParameter("movieCd");
		List<Theater> list = tDao.searchTheaterByMovie(movieCd, DBUtil.ON_SCREEN);
		request.setAttribute("list", list);
		request.setAttribute("title", "상영중인 영화로 검색");
		url = "theaterList.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	} // end of searchTheaterByMovie()
	
	public void searchByThtrNm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TheaterDAO tDao = TheaterDAO.getInstance();
		String url = null;
		String thtrNm = request.getParameter("thtrNm");
		String loc1 = request.getParameter("loc1");
		String loc2 = request.getParameter("loc2");
		List<Theater> list = tDao.searchByTheaterName(thtrNm, loc1, loc2);
		request.setAttribute("title", "극장명/지역으로 검색");
		request.setAttribute("list", list);
		url = "theaterList.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	} // end of searchTheaterByMovie()
	
	public void searchByMovieNm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		MovieDAO mDao = MovieDAO.getInstance();
		String url = null;
		String movieNm = request.getParameter("movieNm");
		List<Movie> list = mDao.searchByMovieNm(movieNm);
		request.setAttribute("list", list);
		url = "movieList.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	} // end of searchByMovieNm()
} // end of class
