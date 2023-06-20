package com.minha.model;

public class MemberDto {
	private String id;
	private String name;
	private String password;
	private String email;
	private int zonecode;
	private String address;
	private String detailaddress;
	private String extraaddress;
	private String profile;
	private String realProfile;
	
	
	public MemberDto() {
		super();
	}

	public MemberDto(String id, String name, String password, String email, int zonecode, String address,
			String detailaddress, String extraaddress, String profile, String realProfile) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.zonecode = zonecode;
		this.address = address;
		this.detailaddress = detailaddress;
		this.extraaddress = extraaddress;
		this.profile = profile;
		this.realProfile = realProfile;
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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getZonecode() {
		return zonecode;
	}


	public void setZonecode(int zonecode) {
		this.zonecode = zonecode;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getDetailaddress() {
		return detailaddress;
	}


	public void setDetailaddress(String detailaddress) {
		this.detailaddress = detailaddress;
	}


	public String getExtraaddress() {
		return extraaddress;
	}


	public void setExtraaddress(String extraaddress) {
		this.extraaddress = extraaddress;
	}


	public String getProfile() {
		return profile;
	}


	public void setProfile(String profile) {
		this.profile = profile;
	}


	public String getRealProfile() {
		return realProfile;
	}


	public void setRealProfile(String realProfile) {
		this.realProfile = realProfile;
	}

	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", zonecode="
				+ zonecode + ", address=" + address + ", detailaddress=" + detailaddress + ", extraaddress="
				+ extraaddress + ", profile=" + profile + ", realProfile=" + realProfile + "]";
	}

}
