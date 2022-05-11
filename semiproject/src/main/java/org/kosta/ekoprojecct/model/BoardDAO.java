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
			//paging을 위해 rnum 생성
			sql.append("SELECT rnum, postNo, postTitle,id, postDate, postCategory, hits,youtubelink ");
			sql.append("FROM(SELECT ROW_NUMBER() OVER(ORDER BY postno DESC) as rnum, postno, posttitle, to_char(postdate,'yyyy.mm.dd') as postDate, hits, id, postCategory, youtubelink FROM semiboard WHERE postCategory=?) ");
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
				boardVO.setYoutubeLink(rs.getString("youtubelink"));//추가
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
	
	//Search List By Filter부분 paging 할 때 사용했음
	public int getTotalPostCountByFilter(String filter, String word) throws SQLException{
		int totalPostCountByFilter=0;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select count(*) ");
			sql.append("from SemiBoard b , SemiMember m ");
			sql.append("where m.id = b.id ");
			if (filter.equals("name")) {
				sql.append("and b.postTitle LIKE '%' || ? || '%'");
			} else if (filter.equals("content")) {
				sql.append("and b.postContent LIKE '%' || ? || '%'");
			}
			pstmt = con.prepareStatement(sql.toString());
			//pstmt.setString(1, filter);
			pstmt.setString(1, word);
			rs=pstmt.executeQuery();
			if(rs.next())
				totalPostCountByFilter=rs.getInt(1);
		}finally {
			closeAll(rs, pstmt, con);
		}
		return totalPostCountByFilter;
	}
	
	//getTotalPostCountByCategory(String postCategory)는 자유, 소통, 두시 게시판에서 사용. 
	//SELECT COUNT(*) FROM SemiBoard WHERE postCategory=? 부분을 추가하였음. 
	public int getTotalPostCountByCategory(String postCategory) throws SQLException{
		int totalPostCountByCategory=0;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			String sql="SELECT COUNT(*) FROM SemiBoard WHERE postCategory=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, postCategory);
			rs=pstmt.executeQuery();
			if(rs.next())
				totalPostCountByCategory=rs.getInt(1);
				
		}finally {
			closeAll(rs, pstmt, con);
		}
		return totalPostCountByCategory;
	} 
	 
	
	public BoardVO postDetail(int no) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO bvo = null;
		try {
			con  = dataSource.getConnection();
			StringBuilder sql = new StringBuilder("select b.postNo, b.postTitle, b.postContent, TO_CHAR(b.postDate, 'mm.dd') as postDate, b.postCategory, b.hits, m.id, m.name ,b.youtubeLink ");
			sql.append("from SemiBoard b , semimember m ");
			sql.append("where m.id = b.id and b.postNo = ?");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				MemberVO mvo = new MemberVO();
				mvo.setId(rs.getString(7));
				mvo.setName(rs.getString(8));
				bvo = new BoardVO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(9),mvo);
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return bvo;
	}
	//게시물 삭제
	public void deletePost(int no) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String sql = "delete from SemiBoard where postno = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		}finally {
			closeAll(pstmt, con);
		}
	}
	//게시물 작성
	public void posting(BoardVO bvo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String sql = "insert into semiboard(postNo,postTitle,postContent,postDate,postCategory,id,youtubelink) values(SemiBoard_seq.nextval,?,?,sysdate,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bvo.getPostTitle());
			pstmt.setString(2, bvo.getPostContent());
			pstmt.setString(3, bvo.getPostCategory());
			pstmt.setString(4, bvo.getMemberVO().getId());
			pstmt.setString(5, bvo.getYoutubeLink());
			pstmt.executeUpdate();
			
		}finally {
			closeAll(pstmt, con);
		}
		
	}
	//게시물 수정
	public void updatePost(BoardVO bvo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String sql = "update SemiBoard set posttitle=?, postcontent=? where postno=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bvo.getPostTitle());
			pstmt.setString(2, bvo.getPostContent());
			pstmt.setInt(3, bvo.getPostNo());
			pstmt.executeUpdate();
		}finally {
			closeAll(pstmt, con);
		}
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
	/*
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
	*/
	 //pagination 추가
	 public ArrayList<BoardVO> findPostByFilterAndWord(String filter, String word, Pagination pagination) throws SQLException {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			System.out.println(filter);
			System.out.println(word);
			StringBuilder sql = new StringBuilder();
			
			//paging 하기 위해서 sql문 수정 -> if문 구조 변경, rnum 생성
			sql.append("SELECT rnum, postNo, postTitle,id, postDate, postCategory, hits ");
			
			sql.append("FROM(SELECT ROW_NUMBER() OVER(ORDER BY postno DESC) as rnum, b.postNo, b.postTitle, b.postDate, b.postCategory, b.hits , m.name, m.id ");
			sql.append("from SemiBoard b , semimember m ");
			sql.append("where m.id = b.id ");
			if (filter.equals("name")) {
				sql.append("and b.postTitle LIKE '%' || ? || '%') ");
				sql.append("WHERE rnum between ? and ? ");
			} else if (filter.equals("content")) {
				sql.append("and b.postContent LIKE '%' || ? || '%') ");
				sql.append("WHERE rnum between ? and ? ");
			}
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, word);
			pstmt.setInt(2, pagination.getStartRowNumber());
			pstmt.setInt(3, pagination.getEndRowNumber());
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
	
	public ArrayList<BoardVO> findPostByMyId(String id, Pagination pagination) throws SQLException {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT rnum, postNo, postTitle,id, postDate, postCategory, hits ");
			sql.append("FROM(SELECT ROW_NUMBER() OVER(ORDER BY postno DESC) as rnum, postno, posttitle, to_char(postdate,'yyyy.mm.dd') as postDate, hits, id, postCategory FROM semiboard WHERE id=?) ");
			sql.append("WHERE rnum between ? and ? ");
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
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
				boardVO.setPostDate(rs.getString("postDate"));
				boardVO.setMemberVO(memberVO);
				list.add(boardVO);
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}
	public void like(MemberVO mvo, int no) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String sql ="Insert into SemiLike(id,postNo) values(?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mvo.getId());
			pstmt.setInt(2, no);
			pstmt.executeUpdate();
		}finally {
			closeAll(pstmt, con);
		}
	}
	public void cancelLike(MemberVO mvo, int no) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String sql ="delete from SemiLike where id = ? and postNo = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mvo.getId());
			pstmt.setInt(2, no);
			pstmt.executeUpdate();
		}finally {
			closeAll(pstmt, con);
		}
	}
	
	public boolean checkLike(String id, int no) throws SQLException {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean flag = false;
		try {
			String sql = "select count(*) from semilike where id = ? and postno = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getInt(1)==1) {
					flag = true;
				}
				
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return flag;
		
	}
	public int likeNumber(int no) throws SQLException {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int likes = 0;
		try {
			String sql = "select count(*) from semilike where postno = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				likes = rs.getInt(1);
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return likes;
	}
	
	public ArrayList<BoardVO> findLikePostList(MemberVO mvo) throws SQLException {
		ArrayList<BoardVO> list=new ArrayList<BoardVO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append("select b.postNo, b.postTitle, b.postDate, b.postCategory, b.hits ");
			sql.append("from SEMIBOARD b, semilike l ");
			sql.append("where b.postno = l.postno and l.id = ?");
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, mvo.getId());
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BoardVO boardVO=new BoardVO();
				boardVO.setPostNo(rs.getInt(1));
				boardVO.setPostTitle(rs.getString(2));
				boardVO.setPostDate(rs.getString(3));
				boardVO.setPostCategory(rs.getString(4));
				boardVO.setHits(rs.getInt(5));
				boardVO.setMemberVO(mvo);
				list.add(boardVO);
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}
	
	//두시게시판용 findlist
	public ArrayList<BoardVO> findDusiPostList() throws SQLException {
		ArrayList<BoardVO> list=new ArrayList<BoardVO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			String sql = "select postNo, postTitle, id, postDate, postCategory, hits, youtubelink from SEMIBOARD where postCategory = ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, "두시");
			rs=pstmt.executeQuery();
			while(rs.next()) {
				MemberVO memberVO=new MemberVO();
				memberVO.setId(rs.getString("id"));
				BoardVO boardVO=new BoardVO();
				boardVO.setPostNo(rs.getInt("postNo"));
				boardVO.setPostTitle(rs.getString("postTitle"));
				boardVO.setHits(rs.getInt("hits"));
				boardVO.setPostCategory(rs.getString("postCategory"));
				boardVO.setPostDate(rs.getString("postDate"));
				boardVO.setYoutubeLink(rs.getString("youtubelink"));//추가
				boardVO.setMemberVO(memberVO);
				list.add(boardVO);
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}

	
}











