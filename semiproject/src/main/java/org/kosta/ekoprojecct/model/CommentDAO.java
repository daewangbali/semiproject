package org.kosta.ekoprojecct.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class CommentDAO {
	private static CommentDAO instance = new CommentDAO();
	@SuppressWarnings("unused")
	private DataSource dataSource;

	private CommentDAO() {
		this.dataSource = DataSourceManager.getInstance().getDataSource();
	}

	public static CommentDAO getInstance() {
		return instance;
	}

	public void closeAll(PreparedStatement pstmt, Connection con) throws SQLException {
		if (pstmt != null)
			pstmt.close();
		if (con != null)
			con.close();
	}

	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		if (rs != null)
			rs.close();
		closeAll(pstmt, con);
	}

	public ArrayList<CommentVO> ListCommentByPostNo(int postNo) throws SQLException {
		ArrayList<CommentVO> list = new ArrayList<CommentVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder(
					"select sm.id,sm.KOSTANo,sb.postNo,sc.commentNo, TO_CHAR(sc.commentDate, 'mm.dd') as commentDate, sc.commentContent ");
			sql.append("from SemiComment sc ");
			sql.append("inner join SemiBoard sb on sc.postNo=sb.postNo ");
			sql.append("inner join SemiMember sm on sm.id=sc.id ");
			sql.append("where sc.postNo=?");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, postNo);
			// pstmt.setString(2, cvo.getBoardVO().getPostCategory());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberVO mvo = new MemberVO(rs.getString(1), rs.getString(2));
				BoardVO bvo = new BoardVO();
				CommentVO cvo = new CommentVO();

				bvo = new BoardVO(rs.getInt(3), mvo);
				cvo.setCommentNo(rs.getInt(4));
				cvo.setCommentDate(rs.getString(5));
				cvo.setCommentContent(rs.getString(6));
				cvo.setBoardVO(bvo);
				cvo.setMemberVO(mvo);
				list.add(cvo);
			}
		} finally {
			closeAll(rs, pstmt, con);
		}

		return list;
	}

	public void register(int postNo, String commentContent, String writerId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder(
					"INSERT INTO SemiComment(commentNo,postNo,commentDate,commentContent, id) ");
			sql.append("VALUES(SemiComment_seq.nextval,?,sysdate,?,?)");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, postNo);
			pstmt.setString(2, commentContent);
			pstmt.setString(3, writerId);
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}

	public void updateComment(String commentContent, int commentNo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String sql = "UPDATE SemiComment SET commentContent=? WHERE commentNo=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, commentContent);
			pstmt.setInt(2, commentNo);

			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}

	public CommentVO commentDetail(int commentNo) throws SQLException {
		CommentVO cvo = new CommentVO();
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT CommentContent FROM SEMICOMMENT WHERE commentNo=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, commentNo);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				cvo = new CommentVO(commentNo, rs.getString("commentContent"));
			}

		} finally {
			closeAll(rs, pstmt, con);
		}
		return cvo;
	}

}