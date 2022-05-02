package org.kosta.ekoprojecct.model;

public class BoardVO {
	private int postNo;
	private String postTitle;
	private String postContent;
	private String postDate;
	private String postCategory;
	private MemberVO memberVO;

	public BoardVO() {
		super();
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public String getPostCategory() {
		return postCategory;
	}

	public void setPostCategory(String postCategory) {
		this.postCategory = postCategory;
	}

	@Override
	public String toString() {
		return "BoardVO [postNo=" + postNo + ", postTitle=" + postTitle + ", postContent=" + postContent + ", postDate="
				+ postDate + ", postCategory=" + postCategory + ", memberVO=" + memberVO + "]";
	}

}
