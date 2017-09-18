package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import util.DBUtil;
/**
 * 맴버 확인, 가입, 탈퇴, 수정을 처리하는 클래스
 */
public class MemberDAO {
	private static MemberDAO memDao;

	private MemberDAO() {}

	public static MemberDAO getIntance() {
		if (memDao == null) {
			memDao = new MemberDAO();
		}
		return memDao;
	}

	public Member checkMember(String id, String pw) throws SQLException {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member mem = null;
		
		String sql = "SELECT * "
				+ 	 "FROM   MEMBER "
				+    "WHERE MEMBER_ID = ? "
				+    "  AND MEMBER_PW = ? "
				+ "";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id); 
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				mem = new Member();
				mem.setId(rs.getString("MEMBER_ID"));
				mem.setPw(rs.getString("MEMBER_PW"));
				mem.setName(rs.getString("MEMBER_NM"));
				mem.setPhone(rs.getString("MEMBER_PHONE"));
				mem.setEmail(rs.getString("EMAIL"));
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mem;
	} // end of checkMember()
	
	public void joinMemeber(Member mem) throws SQLException{
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO MEMBER VALUES(?, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem.getId());
			pstmt.setString(2, mem.getPw());
			pstmt.setString(3, mem.getName());
			pstmt.setString(4, mem.getPhone());
			pstmt.setString(5, mem.getPwHash());
			pstmt.setString(6, mem.getEmail());
			pstmt.executeUpdate();
		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			if(e instanceof SQLIntegrityConstraintViolationException ){
				e.printStackTrace();
			}
		} finally {
			DBUtil.close(conn, pstmt);
		}
	} // end of joinMemeber()

	public static void updateMemeber(Member mem) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE MEMBER SET MEMBER_PW = ? , MEMBER_NM = ? , MEMBER_PHONE = ? , EMAIL = ? WHERE MEMBER_ID = ?";
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem.getPw());
			pstmt.setString(2, mem.getName());
			pstmt.setString(3, mem.getPhone());
			pstmt.setString(4, mem.getEmail());
			pstmt.setString(5, mem.getId());
			pstmt.executeUpdate();
		} catch (SQLException s) {
			s.printStackTrace();
		} finally {
			DBUtil.close(con, pstmt);
		}
	} // end of updateMemeber()
	
	public static void deleteMemeber(String id) throws SQLException{
    	Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM MEMBER WHERE MEMBER_ID=?";
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(con, pstmt);
		}
	} // end of deleteMemeber()
} // end of class
