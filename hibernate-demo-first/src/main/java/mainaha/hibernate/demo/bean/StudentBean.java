package mainaha.hibernate.demo.bean;

public class StudentBean {
	
	private int rollNo;
	private String studName;
	private String branch;
	private String city;

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public StudentBean() {
		super();
	}

	public StudentBean(int rollNo, String studName, String branch, String city) {
		super();
		this.rollNo = rollNo;
		this.studName = studName;
		this.branch = branch;
		this.city = city;
	}

	@Override
	public String toString() {
		return "StudentBean [rollNo=" + rollNo + ", studName=" + studName + ", branch=" + branch + ", city=" + city
				+ "]";
	}

}
