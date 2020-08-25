package user.model;

public class Business extends User{
	
	// 사업자 추가 정보
	private String companyName = "";
	private String companyAddress = "";
	private String companyPhone = "";
	private String rank = "";
	
	public Business() {
		super();
	}
	public Business(String id, String password, String userName, String userNickName, String address, String email, String phone) {
		super(id, password, userName, userNickName, address, email, phone);
	}
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getCompanyPhone() {
		return companyPhone;
	}
	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	
	
	
	

}
