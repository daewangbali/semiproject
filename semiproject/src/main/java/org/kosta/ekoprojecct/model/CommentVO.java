package org.kosta.ekoprojecct.model;

public class CommentVO {
	private int commentNo;
	private String commentContent;
	private String commentDate;
	private BoardVO boardVO;
	private MemberVO memberVO;

	public CommentVO() {
		super();
	}
	
	public CommentVO(String commentContent) {
		super();
		this.commentContent = commentContent;
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}

	public BoardVO getBoardVO() {
		return boardVO;
	}

	public void setBoardVO(BoardVO boardVO) {
		this.boardVO = boardVO;
	}

	public MemberVO getMemberVO() {
		return memberVO;
	}

	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}

	@Override
	public String toString() {
		return "CommentVO [commentNo=" + commentNo + ", commentContent=" + commentContent + ", commentDate="
				+ commentDate + ", boardVO=" + boardVO + "]";
	}

}
