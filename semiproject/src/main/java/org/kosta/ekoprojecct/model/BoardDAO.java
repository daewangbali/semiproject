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
	public ArrayList<BoardVO> findPostList(String postCategory) throws SQLException {
		ArrayList<BoardVO> list=new ArrayList<BoardVO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append("SELECT b.postNo, b.postTitle, m.id, TO_CHAR(b.postDate,'yyyy.mm.dd') as postDate, b.hits ");
			sql.append("FROM SemiMember m, SemiBoard b ");
			sql.append("WHERE m.id=b.id ");
			sql.append("AND b.postCategory=? ");
			sql.append("ORDER BY b.postNo desc ");
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, postCategory);
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
	/*
	 * 




	 */
}