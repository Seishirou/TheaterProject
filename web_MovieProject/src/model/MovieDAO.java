package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import util.DBUtil;
/**
 * 영화 검색을 처리하는 클래스
 */
public class MovieDAO {
	private static MovieDAO mDao;
	
	private MovieDAO() {}

	public static MovieDAO getInstance(){
		
		if(mDao == null){
			mDao = new MovieDAO();
		}
		return mDao;
	}
	
	public List<Movie> searchReservable() throws SQLException{
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Movie m = null;
		List<Movie> list = new ArrayList<>();
		
		String sql = "SELECT MOVIE_CD, "
				+    "       MOVIE_NM, "
				+    "       MOVIE_GENRE, "
				+    "       NATION_NM, "
				+    "       DIRECTOR, "
				+    "       MOVIE_RUNTIME, "
				+    "       OPEN_DT, "
				+    "       IMG, "
				+    "       (SELECT COUNT(*) "
				+    " 		  FROM THTR_MOVIE "
				+    "		  WHERE M.MOVIE_CD = THTR_MOVIE.MOVIE_CD) THTR_CNT "
				+ 	 "FROM   MOVIE M "
				+    "WHERE EXISTS( "
				+    " 	    SELECT  *	"
				+    "      FROM THTR_MOVIE TM	"
				+    "      WHERE PLAY_END_DT >= TO_CHAR(SYSDATE,'YYYYMMDD') "
				+    "	      AND M.MOVIE_CD = TM.MOVIE_CD) ";
		try {
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			
			while(rs.next()){
				m = new Movie();
				m.setMovieCd(rs.getString("MOVIE_CD"));
				m.setMovieNm(rs.getString("MOVIE_NM"));
				m.setRepGenreNm(rs.getString("MOVIE_GENRE"));
				m.setRepNationNm(rs.getString("NATION_NM"));
				m.setDirector(rs.getString("DIRECTOR"));
				m.setMovieRuntime(rs.getInt("MOVIE_RUNTIME"));
				m.setOpenDt(rs.getString("OPEN_DT"));
				m.setThtrCnt(rs.getInt("THTR_CNT"));
				m.setmovieImg(rs.getString("IMG"));
				
				list.add(m);
			} 
			
		} catch (SQLException e) {
				e.printStackTrace();
		} finally {
			DBUtil.close(conn, pstmt, rs);
		}
		
		return list;
	} // end of searchByPlayPeriod()
	
	public Movie searchByMovieCD(String movieCd) throws SQLException{
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Movie m = null;
		List<Movie> list = new ArrayList<>();
		
		String sql = "SELECT * "
				+ 	 "FROM            MOVIE "
				+    "WHERE MOVIE_CD LIKE = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, movieCd);

			rs = pstmt.executeQuery();
			
			while(rs.next()){
				m = new Movie();
				m.setMovieCd(rs.getString("MOVIE_CD"));
				m.setMovieNm(rs.getString("MOVIE_NM"));
				m.setRepGenreNm(rs.getString("MOVIE_GENRE"));
				m.setRepNationNm(rs.getString("NATION_NM"));
				m.setDirector(rs.getString("DIRECTOR"));
				m.setMovieRuntime(rs.getInt("MOVIE_RUNTIME"));
				m.setOpenDt(rs.getString("OPEN_DT"));
				
				list.add(m);
			} 
		} catch (SQLException e) {
				e.printStackTrace();
		} finally {
			DBUtil.close(conn, pstmt, rs);
		}
		return null;
	}
	
	public List<Movie> searchByMovieNm(String movieNm) throws SQLException{
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Movie m = null;
		List<Movie> list = new ArrayList<>();
		
		String sql = "SELECT * "
				+ 	 "FROM            MOVIE "
				+    "WHERE MOVIE_NM LIKE ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, movieNm+"%");

			rs = pstmt.executeQuery();
			
			while(rs.next()){
				m = new Movie();
				m.setMovieCd(rs.getString("MOVIE_CD"));
				m.setMovieNm(rs.getString("MOVIE_NM"));
				m.setRepGenreNm(rs.getString("MOVIE_GENRE"));
				m.setRepNationNm(rs.getString("NATION_NM"));
				m.setDirector(rs.getString("DIRECTOR"));
				m.setMovieRuntime(rs.getInt("MOVIE_RUNTIME"));
				m.setOpenDt(rs.getString("OPEN_DT"));
				
				list.add(m);
			} 
		} catch (SQLException e) {
				e.printStackTrace();
		} finally {
			DBUtil.close(conn, pstmt, rs);
		}
		return list;
	} // end of searchByMovieNm()
	
	public List<Movie> searchByPlayPeriod(String playStrtDt, String playEndDt) throws SQLException{
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Movie m = null;
		List<Movie> list = new ArrayList<>();
		
		String sql = "SELECT MOVIE_CD, "
				+    "       MOVIE_NM, "
				+    "       MOVIE_GENRE, "
				+    "       NATION_NM, "
				+    "       DIRECTOR, "
				+    "       MOVIE_RUNTIME, "
				+    "       OPEN_DT, "
				+    "       (SELECT COUNT(*) "
				+    " 		  FROM THTR_MOVIE "
				+    "		  WHERE M.MOVIE_CD = THTR_MOVIE.MOVIE_CD) THTR_CNT "
				+ 	 "FROM   MOVIE M "
				+    "WHERE EXISTS( "
				+    " 	    SELECT  *	"
				+    "      FROM THTR_MOVIE TM	"
				+    "      WHERE PLAY_STRT_DT >= ? "
				+    "        AND PLAY_END_DT <= ? "
				+    "	      AND M.MOVIE_CD = TM.MOVIE_CD) ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			if(playStrtDt == null) playStrtDt = "00000000";
			if(playEndDt == null) playEndDt = "99999999";
			
			pstmt.setString(1,playStrtDt);
			pstmt.setString(2,playEndDt);

			rs = pstmt.executeQuery();
			
			while(rs.next()){
				m = new Movie();
				m.setMovieCd(rs.getString("MOVIE_CD"));
				m.setMovieNm(rs.getString("MOVIE_NM"));
				m.setRepGenreNm(rs.getString("MOVIE_GENRE"));
				m.setRepNationNm(rs.getString("NATION_NM"));
				m.setDirector(rs.getString("DIRECTOR"));
				m.setMovieRuntime(rs.getInt("MOVIE_RUNTIME"));
				m.setOpenDt(rs.getString("OPEN_DT"));
				m.setThtrCnt(rs.getInt("THTR_CNT"));

				list.add(m);
			} 
		} catch (SQLException e) {
				e.printStackTrace();
		} finally {
			DBUtil.close(conn, pstmt, rs);
		}
		return list;
	} // end of searchByPlayPeriod()
	
	public int insert(Movie m) throws SQLException{
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO MOVIE VALUES(?, ?, ?, ?, ?, ?, ?)";
		
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getMovieCd());
			pstmt.setString(2, m.getMovieNm());
			pstmt.setString(3, m.getRepGenreNm());
			pstmt.setString(4, m.getRepNationNm());
			pstmt.setString(5, m.getDirector());
			pstmt.setInt(6, 120);
			pstmt.setString(7, m.getOpenDt());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, pstmt);
		}
		return result;
	} // end of method insert()
	
	public int insert(LinkedList<Movie> list) throws SQLException{
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "MERGE INTO MOVIE "
				+ "        USING DUAL "
				+ "        ON (MOVIE_CD = ?) "
				+ "        WHEN MATCHED THEN "
				+ "            UPDATE SET MOVIE_NM = ? "
				+ "        WHEN NOT MATCHED THEN "
				+ "            INSERT VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		int result = 0;
		try {
			Iterator<Movie> it = list.iterator();
			pstmt = conn.prepareStatement(sql);
			Movie m = null;
			int i = 0;
			while(it.hasNext()){
				m = it.next();
				i++;
				pstmt.setString(1, m.getMovieCd());
				pstmt.setString(2, m.getMovieNm());
				pstmt.setString(3, m.getMovieCd());
				pstmt.setString(4, m.getMovieNm());
				pstmt.setString(5, m.getRepGenreNm());
				pstmt.setString(6, m.getRepNationNm());
				pstmt.setString(7, m.getDirector());
				pstmt.setInt(8, 120);
				pstmt.setString(9, m.getOpenDt());
				
				result = pstmt.executeUpdate();
			}
		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
		} catch (SQLException e) {
				e.printStackTrace();
		} finally {
			DBUtil.close(conn, pstmt);
		}
		return result;
	} // end of method insert()
} // end of class
