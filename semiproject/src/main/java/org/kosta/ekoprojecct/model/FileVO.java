package org.kosta.ekoprojecct.model;

import java.io.Serializable;

public class FileVO implements Serializable{

	private static final long serialVersionUID = 1L;
	private int fileNo;
	private MemberVO memberVO;
	private String originalName;
	private String savedName;
	private String filePath;
	private int fileSize;
	private String fileDate;
	public FileVO() {
		super();
	}
	public int getFileNo() {
		return fileNo;
	}
	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}
	public MemberVO getMemberVO() {
		return memberVO;
	}
	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}
	public String getOriginalName() {
		return originalName;
	}
	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}
	public String getSavedName() {
		return savedName;
	}
	public void setSavedName(String savedName) {
		this.savedName = savedName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public int getFileSize() {
		return fileSize;
	}
	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}
	public String getFileDate() {
		return fileDate;
	}
	public void setFileDate(String fileDate) {
		this.fileDate = fileDate;
	}
	@Override
	public String toString() {
		return "FileVO [fileNo=" + fileNo + ", memberVO=" + memberVO + ", originalName=" + originalName + ", savedName="
				+ savedName + ", filePath=" + filePath + ", fileSize=" + fileSize + ", fileDate=" + fileDate + "]";
	}

}
