package org.kosta.ekoprojecct.model;

public class BoardVO {
	private int postNo;
	private String postTitle;
	private String postContent;
	private String postDate;
	private String postCategory;
	private int hits;
	private MemberVO memberVO;

	public BoardVO() {
		super();
	}

	public BoardVO(int postNo, String postTitle, String postContent, String postDate, String postCategory, int hits,
			MemberVO memberVO) {
		super();
		this.postNo = postNo;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.postDate = postDate;
		this.postCategory = postCategory;
		this.hits = hits;
		this.memberVO = memberVO;
	}

	public BoardVO(int postNo, String postTitle, String postDate, String postCategory, int hits, MemberVO memberVO) {
		super();
		this.postNo = postNo;
		this.postTitle = postTitle;
		this.postDate = postDate;
		this.postCategory = postCategory;
		this.hits = hits;
		this.memberVO = memberVO;
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

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public MemberVO getMemberVO() {
		return memberVO;
	}

	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}

	@Override
	public String toString() {
		return "BoardVO [postNo=" + postNo + ", postTitle=" + postTitle + ", postContent=" + postContent + ", postDate="
				+ postDate + ", postCategory=" + postCategory + ", hits=" + hits + ", memberVO=" + memberVO + "]";
	}

}
