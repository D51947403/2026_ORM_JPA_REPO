package mainaha.hibernate.demo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import mainaha.hibernate.demo.entity.EmployeeEntity;
import mainaha.hibernate.demo.util.HibernateUtil;

public class EmployeeDao {

	public static void main(String[] args) {
		System.out.println("EmployeeDao started.................!");

		EmployeeEntity saveEmp = new EmployeeEntity();
		saveEmp.setEmail("akash-employee@mail.com");
		saveEmp.setFirstName("akash");
		saveEmp.setLastName("shukla");
		
		saveEmployee(saveEmp);
		
		EmployeeEntity retrievedEmp =	getEmployee(6);
		System.out.println("Retrieved Employee: " + retrievedEmp);
		
		EmployeeEntity updateEmp = new EmployeeEntity();
		updateEmp.setEmployeeId(2);
		updateEmp.setEmail("devendra-employee@mail.com");
		updateEmp.setFirstName("devendra");
		updateEmp.setLastName("lodhi");
		
		updateEmployee(updateEmp);
		
		deleteEmployee(3);

		System.out.println("EmployeeDao end.................!");

	}

	public static void saveEmployee(EmployeeEntity saveEmp) {
		System.out.println("Calling saveEmployee() ");
		Session session = null;
		SessionFactory sessionFactory = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			/********* Employee Persistent ********/
			// Save the employee entity to the database
			session.save(saveEmp);
			// commit the transaction to persist the changes
			tx.commit();
			System.out.println("Employee Saved Successfully with ID: " + saveEmp.getEmployeeId());
			// transaction management approach in case of FATAL
		} catch (RuntimeException e) {
			System.err.println("Employee Saved Failed! " + e.getMessage());
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			// Close the session only if the sessionFactory is not null and is open
			session.close();

			if (sessionFactory != null && !sessionFactory.isClosed()) {
			//	HibernateUtil.shutdownSessionFactory();
			}
		}
	}

	public static EmployeeEntity getEmployee(int employeeId) {
		System.out.println("Calling getEmployee() ");
		Session session = null;
		SessionFactory sessionFactory = null;
		EmployeeEntity emp = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			// Fetch by ID using get method
			emp = (EmployeeEntity) session.get(EmployeeEntity.class, employeeId);

			if (emp != null) {
				System.out.println("Employee fetched successfully ");
				System.out.println("Employee ID: " + emp.getEmployeeId());
				System.out.println("Employee Email: " + emp.getEmail());
				System.out.println("Employee First Name: " + emp.getFirstName());
				System.out.println("Employee Last Name: " + emp.getLastName());
			} else {
				System.out.println("Employee fetched successfully ");
			}

		} catch (RuntimeException e) {
			System.err.println("Employee fetched exception " + e.getMessage());

		} finally {
			// Close the session only if the sessionFactory is not null and is open
			session.close();

			if (sessionFactory != null && !sessionFactory.isClosed()) {
				//HibernateUtil.shutdownSessionFactory();
			}
		}
		return emp;
	}

	public static void updateEmployee(EmployeeEntity updateEmp) {
		System.out.println("Calling updateEmployee() ");
		Session session = null;
		SessionFactory sessionFactory = null;
		Transaction tx = null;
		EmployeeEntity emp = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			
			// Fetch by ID using get method
		   emp = (EmployeeEntity) session.get(EmployeeEntity.class, updateEmp.getEmployeeId());
						
		   emp.setEmail(updateEmp.getEmail());
		   emp.setFirstName(updateEmp.getFirstName());
		   emp.setLastName(updateEmp.getLastName());
		   
			tx = session.beginTransaction();
			/********* Employee Persistent ********/
			// update the employee entity to the database
			session.saveOrUpdate(emp);
			// commit the transaction to persist the changes
			tx.commit();
			System.out.println("Employee updated Successfully with ID: " + updateEmp.getEmployeeId());
			// transaction management approach in case of FATAL
		} catch (RuntimeException e) {
			System.err.println("Employee update Failed! " + e.getMessage());
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			// Close the session only if the sessionFactory is not null and is open
			session.close();

			if (sessionFactory != null && !sessionFactory.isClosed()) {
			//	HibernateUtil.shutdownSessionFactory();
			}
		}
	}
	
	public static void deleteEmployee(int employeeId) {
		System.out.println("Calling updateEmployee() ");
		Session session = null;
		SessionFactory sessionFactory = null;
		Transaction tx = null;
		EmployeeEntity emp = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			
			// Fetch by ID using get method
		   emp = (EmployeeEntity) session.get(EmployeeEntity.class,employeeId);
		   
			tx = session.beginTransaction();
			/********* Employee Persistent ********/
			// update the employee entity to the database
			session.delete(emp);
			// commit the transaction to persist the changes
			tx.commit();
			System.out.println("Employee deleted successfully with ID: " + employeeId);
			// transaction management approach in case of FATAL
		} catch (RuntimeException e) {
			System.err.println("Employee delete Failed! " + e.getMessage());
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			// Close the session only if the sessionFactory is not null and is open
			session.close();

			if (sessionFactory != null && !sessionFactory.isClosed()) {
			 HibernateUtil.shutdownSessionFactory();
			}
		}
	}
}
