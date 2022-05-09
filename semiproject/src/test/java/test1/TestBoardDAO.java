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
			/*
			int nowPage=3;
			Pagination pagination=new Pagination(dao.getTotalPostCount(),nowPage);
			ArrayList<BoardVO> list=dao.findPostList("소통", pagination);
			for(BoardVO vo:list)
				System.out.println(vo);
			*/
			//조회수 증가
			/*
			int postNo=3;
			dao.updateHits(postNo);
			System.out.println("조회수 증가");
			BoardVO bvo=dao.postDetail(postNo);
			System.out.println(bvo.getPostNo()+" "+bvo.getPostTitle()+" hits: "+bvo.getHits());
			*/
			//내가 쓴 게시글 조회
			/*
			int nowPage=3;
			Pagination pagination=new Pagination(dao.getTotalPostCountByCategory("소통"),nowPage);
			ArrayList<BoardVO> list=dao.findPostByMyId("zoo", pagination);
			for(BoardVO vo:list)
				System.out.println(vo);
			*/
			
			//제목으로 찾기
			
			int nowPage=2;
			Pagination pagination=new Pagination(dao.getTotalPostCount(),nowPage);
			ArrayList<BoardVO> list=dao.findPostByFilterAndWord("name","a",pagination);
			for(BoardVO vo:list)
				System.out.println(vo);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
