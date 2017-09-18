package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
/**
 * 상영중인 영화정보를 검색하는 클래스
 */
public class ThtrMovieDAO {
	private static ThtrMovieDAO tmDao;
	
	private ThtrMovieDAO() {}
	
	public static ThtrMovieDAO getInstance(){
		if(tmDao == null){
			tmDao = new ThtrMovieDAO();
		}
		return tmDao;
	}
	
	public ThtrMovie displaySchedule(String thtrCd, String movieCd) throws SQLException{
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ThtrMovie tm = null;
		List<ThtrMovie> list = new ArrayList<>();
		int i = 0;
		
		String sql = " SELECT TM.MOVIE_CD MOVIE_CD, "
				+ "			  TM.THTR_CD THTR_CD, "
				+ "			  THTR_NM, "
				+ "			  MOVIE_NM, "
				+ "			  PLAY_STRT_DT, "
				+ "			  PLAY_END_DT "
				+ 	 " FROM   THTR_MOVIE TM "
				+ "			INNER JOIN THEATER T ON T.THTR_CD = TM.THTR_CD "
				+ "         INNER JOIN MOVIE M ON M.MOVIE_CD = TM.MOVIE_CD "
				+    " WHERE 1 = 1 "
				+ "      AND TM.THTR_CD = ? "
				+ "      AND TM.MOVIE_CD = ? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, thtrCd);
			pstmt.setString(2, movieCd);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				tm = new ThtrMovie();
				tm.setMovieCd(rs.getString("MOVIE_CD"));
				tm.setThtrCd(rs.getString("THTR_CD"));
				tm.setMovieNm(rs.getString("MOVIE_NM"));
				tm.setThtrNm(rs.getString("THTR_NM"));
				tm.setPlayStrtDt(rs.getString("PLAY_STRT_DT"));
				tm.setPlayEndDt(rs.getString("PLAY_END_DT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, pstmt, rs);
		}
		
		return tm;
	} // end of displaySchedule()
} // end of class
