package model;

public class Member {
	private String id;
	private String pw;
	private String name;
	private String address;
	private String phone;
	private String grade;
	
	
	public Member(String id, String pw, String name, String address, String phone, String grade) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.grade = grade;
	}
	
	
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}



	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + ", address=" + address + ", phone=" + phone
				+ ", grade=" + grade + "]";
	}

	
	
}
