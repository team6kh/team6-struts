package user.dto;

import java.sql.Timestamp;

public class UserDTO {
	private String userId;
	private String password;
	private String userName;
	private String regDate;
	private Timestamp userLevel;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public Timestamp getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(Timestamp userLevel) {
		this.userLevel = userLevel;
	}
}