package test1;

import java.util.ArrayList;

import org.kosta.ekoprojecct.model.BoardDAO;
import org.kosta.ekoprojecct.model.BoardVO;
import org.kosta.ekoprojecct.model.Pagination;

public class TestBoardDAO {
	public static void main(String[] args) {
		BoardDAO dao=BoardDAO.getInstance();
		try {
			//게시물 리스트 조회
			
			int nowPage=3;
			Pagination pagination=new Pagination(dao.getTotalPostCount(),nowPage);
			ArrayList<BoardVO> list=dao.findPostList("소통", pagination);
			for(BoardVO vo:list)
				System.out.println(vo);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
