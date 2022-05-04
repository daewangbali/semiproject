package org.kosta.ekoprojecct.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class BoardDAO {
	private static BoardDAO instance=new BoardDAO();
	private DataSource dataSource;
	private BoardDAO() {
		this.dataSource=DataSourceManager.getInstance().getDataSource();
	}
	public static BoardDAO getInstance() {
		return instance;
	}
	public void closeAll(PreparedStatement pstmt,Connection con) throws SQLException{
		if(pstmt!=null)
			pstmt.close();
		if(con!=null)
			con.close();
	}
	public void closeAll(ResultSet rs,PreparedStatement pstmt,Connection con) throws SQLException{
		if(rs!=null)
			rs.close();
		closeAll(pstmt, con);
	}
	public ArrayList<BoardVO> findPostList(String postCategory, Pagination pagination) throws SQLException {
		ArrayList<BoardVO> list=new ArrayList<BoardVO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			StringBuilder sql=new StringBuilder();
			/*
			sql.append("SELECT b.postNo, b.postTitle, m.id, TO_CHAR(b.postDate,'yyyy.mm.dd') as postDate, b.hits ");
			sql.append("FROM SemiMember m, SemiBoard b ");
			sql.append("WHERE m.id=b.id ");
			sql.append("AND b.postCategory=? ");
			sql.append("ORDER BY b.postNo desc ");
			*/
			sql.append("SELECT rnum, postNo, postTitle,id, postDate, postCategory, hits ");
			sql.append("FROM(SELECT ROW_NUMBER() OVER(ORDER BY postno DESC) as rnum, postno, posttitle, to_char(postdate,'yyyy.mm.dd') as postDate, hits, id, postCategory FROM semiboard WHERE postCategory=?) ");
			sql.append("WHERE rnum between ? and ?");
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, postCategory);
			pstmt.setInt(2, pagination.getStartRowNumber());
			pstmt.setInt(3, pagination.getEndRowNumber());
			rs=pstmt.executeQuery();
			while(rs.next()) {
				MemberVO memberVO=new MemberVO();
				memberVO.setId(rs.getString("id"));
				BoardVO boardVO=new BoardVO();
				boardVO.setPostNo(rs.getInt("postNo"));
				boardVO.setPostTitle(rs.getString("postTitle"));
				boardVO.setHits(rs.getInt("hits"));
				boardVO.setPostCategory(postCategory);
				boardVO.setPostDate(rs.getString("postDate"));
				boardVO.setMemberVO(memberVO);
				list.add(boardVO);
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}	
	public int getTotalPostCount() throws SQLException{
		int totalPostCount=0;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			String sql="SELECT COUNT(*) FROM SemiBoard";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next())
				totalPostCount=rs.getInt(1);
		}finally {
			closeAll(rs, pstmt, con);
		}
		return totalPostCount;
	}
	public BoardVO postDetail(int no) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO bvo = null;
		try {
			con  = dataSource.getConnection();
			StringBuilder sql = new StringBuilder("select b.postNo, b.postTitle, b.postContent, b.postDate, b.postCategory, b.hits, m.id, m.name ");
			sql.append("from SemiBoard b , semimember m ");
			sql.append("where m.id = b.id and b.postNo = ?");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				MemberVO mvo = new MemberVO();
				mvo.setId(rs.getString(7));
				mvo.setName(rs.getString(8));
				bvo = new BoardVO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),mvo);
				
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return bvo;
	}
	public void updateHits(int postNo) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con=dataSource.getConnection();
			String sql="Update semiboard SET hits=hits+1 WHERE postNo=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, postNo);
			pstmt.executeUpdate();
		}finally {
			closeAll(pstmt, con);
		}
	}
	
	public ArrayList<BoardVO> findPostByFilterAndWord(String filter, String word) throws SQLException {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			System.out.println(filter);
			System.out.println(word);
			StringBuilder sql = new StringBuilder();
			sql.append("select b.postNo, b.postTitle, b.postDate, b.postCategory, b.hits , m.name, m.id ");
			sql.append("from SemiBoard b , semimember m ");
			sql.append("where m.id = b.id ");

			if (filter.equals("name")) {
				sql.append("and b.postTitle LIKE '%' || ? || '%'");
			} else if (filter.equals("content")) {
				sql.append("and b.postContent LIKE '%' || ? || '%'");
			}

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, word);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MemberVO mvo = new MemberVO(rs.getString("id"));
				list.add(new BoardVO(rs.getInt("postNo"), rs.getString("postTitle"), rs.getString("postDate"),
						rs.getString("postCategory"), rs.getInt("hits"), mvo));
			}

		} finally {
			closeAll(rs, pstmt, con);
		}

		return list;
	}
}











