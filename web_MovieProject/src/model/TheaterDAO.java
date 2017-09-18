package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.MyException;
import util.DBUtil;
/**
 * 극장 검색을 처리하는 클래스
 */
public class TheaterDAO {
	private static TheaterDAO tDao;

	private TheaterDAO() {}

	public static TheaterDAO getInstance(){
		
		if(tDao == null){
			tDao = new TheaterDAO();
		}
		return tDao;
	}
	
	public List<Theater> searchByTheaterName(String thtrNm, String loc1, String loc2){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Theater t = null;
		List<Theater> list = new ArrayList<>();
		int i = 0;
		
		String sql = "SELECT * "
				+ 	 "FROM   THEATER "
				+    "WHERE 1 = 1 ";
		
		if(!thtrNm.equals("")) 	sql += " AND THTR_NM LIKE ?";
		if(!loc1.equals("")) 	sql += " AND LOC1 = ? ";
		if(!loc2.equals(""))	sql += " AND LOC2 = ? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			if(!thtrNm.equals("")) {
				i++;
				pstmt.setString(i, thtrNm+"%"); 
			}
			if(!loc1.equals("")) {
				i++;
				pstmt.setString(i, loc1);		
			}
			if(!loc2.equals("")) {
				i++;
				pstmt.setString(i, loc2);
			}
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				t = new Theater();
				t.setThtrCd(rs.getString("THTR_CD"));
				t.setThtrNm(rs.getString("THTR_NM"));
				t.setLoc1(rs.getString("LOC1"));
				t.setLoc2(rs.getString("LOC2"));
				t.setThtrSeatCnt(rs.getInt("THTR_SEAT_CNT"));
				t.setThtrAddr(rs.getString("THTR_ADDR"));
				list.add(t);
			} 
		} catch (SQLException e) {
				e.printStackTrace();
				throw new MyException("데이터 검색 실패");
		} finally {
			DBUtil.close(conn, pstmt, rs);
		}
		
		return list;
	} // end of searchByTheaterName()
	
	public List<Theater> searchTheaterByMovie(String movieCd, int flag){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Theater t = null;
		List<Theater> list = new ArrayList<>();
		
		String sql = "SELECT T.THTR_CD THTR_CD, "
				+ "          THTR_NM, "
				+ "          LOC1, "
				+ "          LOC2, "
				+ "          PLAY_STRT_DT, "
				+ "          PLAY_END_DT, "
				+ "          THTR_SEAT_CNT "
				+ "   FROM   THEATER T "
				+ "          INNER JOIN THTR_MOVIE TM ON T.THTR_CD = TM.THTR_CD "
				+ "   WHERE 1 = 1 "
				+ "    AND MOVIE_CD = ? ";
				   
		if(flag == DBUtil.ON_SCREEN){
			sql = sql + "  AND PLAY_STRT_DT <= TO_CHAR(SYSDATE,'YYYYMMDD') "
				      + "  AND PLAY_END_DT >= TO_CHAR(SYSDATE,'YYYYMMDD') ";
		}
		if(flag == DBUtil.RESERVABLE){
			sql += "  AND PLAY_END_DT >= TO_CHAR(SYSDATE,'YYYYMMDD')";
		}
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, movieCd);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				t = new Theater();
				t.setThtrCd(rs.getString("THTR_CD"));
				t.setThtrNm(rs.getString("THTR_NM"));
				t.setLoc1(rs.getString("LOC1"));
				t.setLoc2(rs.getString("LOC2"));
				t.setThtrSeatCnt(rs.getInt("THTR_SEAT_CNT"));
				t.setPlayStrtDt(rs.getString("PLAY_STRT_DT"));
				t.setPlayEndDt(rs.getString("PLAY_END_DT"));
				list.add(t);
			} 
		} catch (SQLException e) {
				e.printStackTrace();
		} finally {
			DBUtil.close(conn, pstmt, rs);
		}
		
		return list;
	} // end of searchTheaterByMovie()
} // end of class
