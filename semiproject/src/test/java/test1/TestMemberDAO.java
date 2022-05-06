package test1;

import org.kosta.ekoprojecct.model.MemberDAO;

public class TestMemberDAO {
	public static void main(String[] args) {
		MemberDAO dao=MemberDAO.getInstance();
		try {
			System.out.println(dao.findIdByNameAndTel("감자깡", "01012345678"));
		} catch(Exception e) {
			
		}
	}
	
}
