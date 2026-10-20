package mainaha.hibernate.demo.bean;

import java.util.Date;

public class UserBean {
	private int userId;
	private String userName;
	private String createdBy;
	private Date createdDate;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	
	
	public UserBean(int userId, String userName, String createdBy, Date createdDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "UserBean [userId=" + userId + ", userName=" + userName + ", createdBy=" + createdBy + ", createdDate="
				+ createdDate + "]";
	}

}
