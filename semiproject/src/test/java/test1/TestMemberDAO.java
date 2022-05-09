package test1;

import org.kosta.ekoprojecct.model.MemberDAO;

public class TestMemberDAO {
	public static void main(String[] args) {
		MemberDAO dao=MemberDAO.getInstance();
		try {
			dao.deleteMember("java56","a");
			System.out.println(dao.findIdByNameAndTel("java56", "01023"));
	}catch(Exception e){
		e.printStackTrace();
	}
	}
}
