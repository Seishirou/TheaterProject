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
 * 극장별 상영 스케줄 검색을 처리하는 클래스
 */
public class ThtrPlaySeqDAO {
	private static ThtrPlaySeqDAO tmsDao;
	
	private ThtrPlaySeqDAO() {}
	
	public static ThtrPlaySeqDAO getInstance(){
		if(tmsDao == null){
			tmsDao = new ThtrPlaySeqDAO();
		}
		return tmsDao;
	} 
	
	public List<ThtrPlaySeq> displayTimeTable(String thtrCd, String movieCd) throws SQLException{
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ThtrPlaySeq tps = null;
		List<ThtrPlaySeq> list = new ArrayList<>();
		
		String sql = "SELECT THTR_CD, "
				+ "          MOVIE_CD, "
				+ "          PLAY_SEQ, "
				+ "          PLAY_STRT_TM "
				+ "   FROM   THTR_PLAY_SEQ "
				+ "   WHERE 1 = 1 "
				+ "    AND THTR_CD = ? "
				+ "    AND MOVIE_CD = ? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, thtrCd );
			pstmt.setString(2, movieCd);

			rs = pstmt.executeQuery();
			while(rs.next()){
				tps = new ThtrPlaySeq();
				tps.setMovieCd(rs.getString("MOVIE_CD"));
				tps.setThtrCd(rs.getString("THTR_CD"));
				tps.setPlaySeq(rs.getInt("PLAY_SEQ"));
				tps.setPlayStrtTm(rs.getString("PLAY_STRT_TM"));
				
				list.add(tps);
			} 
			
		} catch (SQLException e) {
				e.printStackTrace();
			throw new MyException("데이터 검색 실패");
		} finally {
			DBUtil.close(conn, pstmt, rs);
		}
		
		return list;
	} // end of displayTimeTable()
} // end of class
