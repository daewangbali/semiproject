package test1;

import java.util.ArrayList;

import org.kosta.ekoprojecct.model.BoardDAO;
import org.kosta.ekoprojecct.model.BoardVO;

public class TestBoardDAO {
	public static void main(String[] args) {
		BoardDAO dao=BoardDAO.getInstance();
		try {
			//게시물 리스트 조회
			ArrayList<BoardVO> list=dao.findPostList("소통");
			for(BoardVO vo:list)
				System.out.println(vo);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
