package com.yougex.pojo;

public class Course {

	private int couNo;
	private String couName;
	private String couTeacher;
	private String couAddress;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((couAddress == null) ? 0 : couAddress.hashCode());
		result = prime * result + ((couName == null) ? 0 : couName.hashCode());
		result = prime * result + couNo;
		result = prime * result + ((couTeacher == null) ? 0 : couTeacher.hashCode());
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
		Course other = (Course) obj;
		if (couAddress == null) {
			if (other.couAddress != null)
				return false;
		} else if (!couAddress.equals(other.couAddress))
			return false;
		if (couName == null) {
			if (other.couName != null)
				return false;
		} else if (!couName.equals(other.couName))
			return false;
		if (couNo != other.couNo)
			return false;
		if (couTeacher == null) {
			if (other.couTeacher != null)
				return false;
		} else if (!couTeacher.equals(other.couTeacher))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Course [couNo=" + couNo + ", couName=" + couName + ", couTeacher=" + couTeacher + ", couAddress="
				+ couAddress + "]";
	}
	
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Course(int couNo, String couName, String couTeacher, String couAddress) {
		super();
		this.couNo = couNo;
		this.couName = couName;
		this.couTeacher = couTeacher;
		this.couAddress = couAddress;
	}

	public int getCouNo() {
		return couNo;
	}
	public void setCouNo(int couNo) {
		this.couNo = couNo;
	}
	public String getCouName() {
		return couName;
	}
	public void setCouName(String couName) {
		this.couName = couName;
	}
	public String getCouTeacher() {
		return couTeacher;
	}
	public void setCouTeacher(String couTeacher) {
		this.couTeacher = couTeacher;
	}
	public String getCouAddress() {
		return couAddress;
	}
	public void setCouAddress(String couAddress) {
		this.couAddress = couAddress;
	}

	
	

	
}