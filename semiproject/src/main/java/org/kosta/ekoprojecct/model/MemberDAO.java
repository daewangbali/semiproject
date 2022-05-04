package org.kosta.ekoprojecct.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
	private DataSource dataSource;

	private MemberDAO() {
		this.dataSource = DataSourceManager.getInstance().getDataSource();
	};

	public static MemberDAO getInstance() {
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

	public void registerMember(String id, String name, String tel, String kostaNO, String password) throws SQLException {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			System.out.println(id);
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO SemiMEMBER(id, name, tel, KOSTANo, password) ");
			sql.append("VALUES(?, ?, ?, ?, ?)");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, tel);
			pstmt.setString(4, kostaNO);
			pstmt.setString(5, password);
			
			int result = pstmt.executeUpdate();
			System.out.println(result+" Columns have been updated.");
			
		}finally {
			closeAll(pstmt, con);
		}
	}
	
	public MemberVO login(String id, String password) throws SQLException {
		MemberVO vo=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			String sql="SELECT name, tel, KOSTANO FROM SemiMEMBER WHERE id=? AND password=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);	
			rs=pstmt.executeQuery();
			if(rs.next()) {
				vo=new MemberVO(id,rs.getString("name"),rs.getString("tel"),rs.getString("KOSTANo"),password);
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		
		
		return vo;
	}

	public boolean idcheck(String id) throws SQLException {
		boolean flag=false;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			String sql="SELECT COUNT(*) FROM SemiMEMBER WHERE id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()&&(rs.getInt(1)>0))
			flag=true;
		}finally {
			closeAll(rs, pstmt, con);
		}
		
		return flag;
	}

	public MemberVO findIdByNameAndTel(String name, String tel) throws SQLException {
		MemberVO vo=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			String sql="SELECT id FROM SemiMEMBER WHERE name=? AND tel=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, tel);
			rs=pstmt.executeQuery();
			if(rs.next())
				vo=new MemberVO(rs.getString(1),name,tel,null,null);
		}finally {
			closeAll(rs, pstmt, con);
		}
		
		return vo;
	}
	public void updateMember(MemberVO vo) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="UPDATE SemiMEMBER SET name=?,tel=?,kostaNO=?,password=? WHERE id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getTel());
			pstmt.setString(3, vo.getKostaNO());
			pstmt.setString(4, vo.getPassword());
			pstmt.setString(5, vo.getId());
			pstmt.executeUpdate();
		}finally {
			closeAll(pstmt, con);		
		}	
	}

	public void deleteMember(String id) throws Exception{
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="DELETE FROM SEMIMEMBER WHERE id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		}finally {
			closeAll(pstmt, con);		
		}	
		System.out.println("db에 "+id+" 정보 삭제");
	}
}
