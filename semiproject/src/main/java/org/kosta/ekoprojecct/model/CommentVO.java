package org.kosta.ekoprojecct.model;

public class CommentVO {
	private int commentNo;
	private String commentContent;
	private String commentDate;
	private BoardVO boardVO;
	
	public CommentVO() {
		super();
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

	@Override
	public String toString() {
		return "CommentVO [commentNo=" + commentNo + ", commentContent=" + commentContent + ", commentDate="
				+ commentDate + ", boardVO=" + boardVO + "]";
	}

}
