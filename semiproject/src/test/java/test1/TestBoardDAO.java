package test1;

import org.kosta.ekoprojecct.model.BoardDAO;
import org.kosta.ekoprojecct.model.BoardVO;

public class TestBoardDAO {
	public static void main(String[] args) {
		BoardDAO dao=BoardDAO.getInstance();
		try {
			//게시물 리스트 조회
			/*
			int nowPage=3;
			Pagination pagination=new Pagination(dao.getTotalPostCount(),nowPage);
			ArrayList<BoardVO> list=dao.findPostList("소통", pagination);
			for(BoardVO vo:list)
				System.out.println(vo);
			*/
			//조회수 증가
			int postNo=3;
			dao.updateHits(postNo);
			System.out.println("조회수 증가");
			BoardVO bvo=dao.postDetail(postNo);
			System.out.println(bvo.getPostNo()+" "+bvo.getPostTitle()+" hits: "+bvo.getHits());
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
