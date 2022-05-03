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

	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) throws Exception {
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
	
	public MemberVO login(String id, String password) throws Exception {
		MemberVO vo=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			String sql="SELECT name, tel, KOSTANO FROM Semimember WHERE id=? AND password=?";
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

}
