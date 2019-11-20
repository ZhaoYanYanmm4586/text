package com.yougex.pojo;

public class User {
   private String userName;
   private String userPwd;
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((userName == null) ? 0 : userName.hashCode());
	result = prime * result + ((userPwd == null) ? 0 : userPwd.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	User other = (User) obj;
	if (userName == null) {
		if (other.userName != null)
			return false;
	} else if (!userName.equals(other.userName))
		return false;
	if (userPwd == null) {
		if (other.userPwd != null)
			return false;
	} else if (!userPwd.equals(other.userPwd))
		return false;
	return true;
}
@Override
public String toString() {
	return "User [userName=" + userName + ", userPwd=" + userPwd + "]";
}
public User() {
	super();
}
public User(String userName, String userPwd) {
	super();
	this.userName = userName;
	this.userPwd = userPwd;
}
public String getUserPwd() {
	return userPwd;
}
public void setUserPwd(String userPwd) {
	this.userPwd = userPwd;
}
}
