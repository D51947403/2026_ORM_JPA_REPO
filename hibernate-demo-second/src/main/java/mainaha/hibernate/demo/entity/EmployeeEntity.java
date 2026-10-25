package mainaha.hibernate.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "tm_employee", uniqueConstraints = {
        @UniqueConstraint(columnNames = "emp_id"),
        @UniqueConstraint(columnNames = "email") })
public class EmployeeEntity implements Serializable {
 
    private static final long serialVersionUID = -1798070786993154676L;
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id", unique = true, nullable = false ,columnDefinition = "INT(11) UNSIGNED")
    private Integer employeeId;
 
    @Column(name = "email", unique = true, nullable = false, length = 100)
    private String email;
 
    @Column(name = "first_name", unique = false, nullable = false, length = 100)
    private String firstName;
 
    @Column(name = "last_name", unique = false, nullable = false, length = 100)
    private String lastName;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "EmployeeEntity [employeeId=" + employeeId + ", email=" + email + ", firstName=" + firstName
				+ ", lastName=" + lastName + "]";
	}
 
    
    
   
}