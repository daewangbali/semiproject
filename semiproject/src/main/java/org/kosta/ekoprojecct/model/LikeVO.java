package org.kosta.ekoprojecct.model;

public class LikeVO {
	private MemberVO memberVO;
	private BoardVO boardVO;

	public LikeVO() {
		super();
	}

	public MemberVO getMemberVO() {
		return memberVO;
	}

	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}

	public BoardVO getBoardVO() {
		return boardVO;
	}

	public void setBoardVO(BoardVO boardVO) {
		this.boardVO = boardVO;
	}

	@Override
	public String toString() {
		return "LikeVO [memberVO=" + memberVO + ", boardVO=" + boardVO + "]";
	}

}
