package org.kosta.ekoprojecct.model;

import java.io.Serializable;

public class MemberVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String tel;
	private String kostaNO;
	private String password;
	public MemberVO() {
		super();
	}
	public MemberVO(String id, String name, String tel, String kostaNO, String password) {
		super();
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.kostaNO = kostaNO;
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getKostaNO() {
		return kostaNO;
	}
	public void setKostaNO(String kostaNO) {
		this.kostaNO = kostaNO;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", name=" + name + ", tel=" + tel + ", kostaNO=" + kostaNO + ", password="
				+ password + "]";
	}
	
}
