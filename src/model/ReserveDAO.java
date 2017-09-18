package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import exception.MyException;
import util.DBUtil;
/**
 * 예약 기능을 처리하는 클래스
 */
public class ReserveDAO {
	private static ReserveDAO rDao;

	private ReserveDAO() {}

	public static ReserveDAO getInstance(){
		
		if(rDao == null){
			rDao = new ReserveDAO();
		}
		return rDao;
	}
	
	public Reserve selectLastSeatNo(String thtrCd, String watchDate, int playSeq) throws SQLException{
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Reserve r = null;
		
		String sql = " SELECT THTR_SEAT_CNT, LAST_SEAT_NO "
				+ "	   FROM           THEATER T "
				+ "  	   INNER JOIN	( SELECT THTR_CD, WATCH_DATE, PLAY_SEQ, MAX(SEAT_NO) LAST_SEAT_NO "
				+ "  		          FROM RESERVE "
				+ " 		          WHERE 1 = 1 "
				+ " 		            AND THTR_CD = ? "
				+ " 		            AND WATCH_DATE = ?	"
				+ "   	                AND PLAY_SEQ = ? "
				+ "                   GROUP BY THTR_CD, WATCH_DATE, PLAY_SEQ ) TMP "
				+ "        ON T.THTR_CD = TMP.THTR_CD " ;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, thtrCd);
			pstmt.setString(2, watchDate);
			pstmt.setInt(3, playSeq);
			rs = pstmt.executeQuery();
			r = new Reserve();
			if(rs.next()){
				r.setThtrSeatCnt(rs.getInt("THTR_SEAT_CNT"));
				r.setSeatNo(rs.getInt("LAST_SEAT_NO"));
			} else {
				r.setSeatNo(0);
			}
		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			throw new MyException("부서 코드 입력 오류");
		} catch (SQLException e) {
			if(e instanceof SQLIntegrityConstraintViolationException ){
				throw new MyException("부서코드 오류");
			}
		} finally {
			DBUtil.close(conn, pstmt, rs);
		}
		
		return r;
	} // end of selectLastSeatNo()

	
	public int insertReserve(Reserve r) throws SQLException {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO RESERVE VALUES(RESERVE_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?)";
		
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, r.getThtrCd());
			pstmt.setInt(2, r.getPlaySeq());
			pstmt.setInt(3, r.getSeatNo());
			pstmt.setString(4, r.getWatchDate());
			pstmt.setString(5, r.getMovieCd());
			pstmt.setString(6, r.getMemberId());
			result = pstmt.executeUpdate();
		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			throw new MyException("부서 코드 입력 오류");
		} catch (SQLException e) {
			if(e instanceof SQLIntegrityConstraintViolationException ){
				throw new MyException("부서코드 오류");
			}
		} finally {
			DBUtil.close(conn, pstmt);
		}
		
		return result;
	} // end of insertReserve()

	public List<Reserve> selectReserveList(String loginId) throws SQLException {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Reserve r = null;
		List<Reserve> l = new ArrayList<>();
		
		String sql = " SELECT 	BOOK_CODE, "
				+ " 			THTR_NM, "
				+ " 	 		MOVIE_NM, "
				+ " 	 		R.MEMBER_ID MEMBER_ID, "
				+ " 	 		MEMBER_NM, "
				+ "				WATCH_DATE, "
				+ "				PLAY_SEQ, "
				+ "				SEAT_NO "
				+ "	   FROM    	RESERVE R "
				+ " 	 	INNER JOIN THEATER T ON R.THTR_CD = T.THTR_CD "
				+ " 	 	INNER JOIN MOVIE M ON R.MOVIE_CD = M.MOVIE_CD "
				+ " 	 	INNER JOIN MEMBER MEM ON R.MEMBER_ID = MEM.MEMBER_ID "
				+ "	   WHERE R.MEMBER_ID = ? "
				+ "    ORDER BY BOOK_CODE ";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loginId);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				r = new Reserve();
				r.setBookCode(rs.getInt("BOOK_CODE"));
				r.setThtrNm(rs.getString("THTR_NM"));
				r.setMovieNm(rs.getString("MOVIE_NM"));
				r.setMemberId(rs.getString("MEMBER_ID"));
				r.setMemberNm(rs.getString("MEMBER_NM"));
				r.setWatchDate(rs.getString("WATCH_DATE"));
				r.setPlaySeq(rs.getInt("PLAY_SEQ"));
				r.setSeatNo(rs.getInt("SEAT_NO"));
				l.add(r);
			}
		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			throw new MyException("부서 코드 입력 오류");

		} catch (SQLException e) {
			if(e instanceof SQLIntegrityConstraintViolationException ){
				throw new MyException("부서코드 오류");
			}
		} finally {
			DBUtil.close(conn, pstmt, rs);
		}
		
		return l;
	} // end of selectReserveList()

	public List<Reserve> selectReserveList(String loginId, String thtrCd, String watchDate, int playSeq) throws SQLException {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Reserve r = null;
		List<Reserve> l = new ArrayList<>();
		
		String sql = " SELECT 	BOOK_CODE, "
				+ " 			THTR_NM, "
				+ " 	 		MOVIE_NM, "
				+ " 	 		R.MEMBER_ID MEMBER_ID, "
				+ " 	 		MEMBER_NM, "
				+ "				WATCH_DATE, "
				+ "				PLAY_SEQ, "
				+ "				SEAT_NO "
				+ "	   FROM    	RESERVE R "
				+ " 	 	INNER JOIN THEATER T ON R.THTR_CD = T.THTR_CD "
				+ " 	 	INNER JOIN MOVIE M ON R.MOVIE_CD = M.MOVIE_CD "
				+ " 	 	INNER JOIN MEMBER MEM ON R.MEMBER_ID = MEM.MEMBER_ID "
				+ "	   WHERE R.MEMBER_ID = ? "
				+ "		 AND R.THTR_CD = ? "
				+ "		 AND R.WATCH_DATE = ? "
				+ "		 AND R.PLAY_SEQ = ?"
				+ "    ORDER BY BOOK_CODE ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loginId);
			pstmt.setString(2, thtrCd);
			pstmt.setString(3, watchDate);
			pstmt.setInt(4, playSeq);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				r = new Reserve();
				r.setBookCode(rs.getInt("BOOK_CODE"));
				r.setThtrNm(rs.getString("THTR_NM"));
				r.setMovieNm(rs.getString("MOVIE_NM"));
				r.setMemberId(rs.getString("MEMBER_ID"));
				r.setMemberNm(rs.getString("MEMBER_NM"));
				r.setWatchDate(rs.getString("WATCH_DATE"));
				r.setPlaySeq(rs.getInt("PLAY_SEQ"));
				r.setSeatNo(rs.getInt("SEAT_NO"));
				l.add(r);
			}
		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			throw new MyException("무결성 오류");

		} catch (SQLException e) {
			if(e instanceof SQLIntegrityConstraintViolationException ){
				System.out.println(e.getSQLState());
				throw new MyException("무결성 오류");
			}
		} finally {
			DBUtil.close(conn, pstmt, rs);
		}
		
		return l;
	} // end of selectReserveList()
} // end of class
