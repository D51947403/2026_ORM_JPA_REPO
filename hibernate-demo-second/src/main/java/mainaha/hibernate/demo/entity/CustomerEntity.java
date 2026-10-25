package mainaha.hibernate.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tm_customer")
public class CustomerEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cust_id", unique = true, nullable = false)
	private Integer custId;

	@Column(name = "cust_name", unique = false, nullable = false, length = 100)
	private String custName;

	@Column(name = "email", unique = true, nullable = false, length = 100)
	private String email;

	@Column(name = "city", unique = false, nullable = false, length = 100)
	private String city;

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "CustomerEntity [custId=" + custId + ", custName=" + custName + ", email=" + email + ", city=" + city
				+ "]";
	}
	
	

}