package com.upem.models;

import java.io.Serializable;

public class UserType implements Serializable {

	private static final long serialVersionUID = -8760728399280390437L;
	private int UserTypeId;
	private String type;

	public UserType() {
		// TODO Auto-generated constructor stub
	}

	public UserType(int userTypeId, String type) {
		super();
		UserTypeId = userTypeId;
		this.type = type;
	}
	public int getUserTypeId() {
		return UserTypeId;
	}
	public void setUserTypeId(int userTypeId) {
		UserTypeId = userTypeId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}


}
