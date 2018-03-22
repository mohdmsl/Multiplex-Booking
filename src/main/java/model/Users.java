package model;

public class Users {

	private String emailId;
	private String mobileNo;
	private String password;
	private int userId;

	private String userName;

	private String userType;
	public Users(int userId, String userName, String userType, String mobileNo, String emailId, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userType = userType;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.password=password;
	}
	public String getEmailId() {
		return emailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public String getPassword() {
		return password;
	}

	public int getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserType() {
		return userType;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

}
