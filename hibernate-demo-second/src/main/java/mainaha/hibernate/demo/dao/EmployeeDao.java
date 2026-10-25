package mainaha.hibernate.demo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import mainaha.hibernate.demo.entity.EmployeeEntity;
import mainaha.hibernate.demo.util.HibernateUtil;

public class EmployeeDao {

	public static void main(String[] args) {
		System.out.println("EmployeeDao started.................!");

		saveEmployee();

		System.out.println("EmployeeDao end.................!");

	}

	public static void saveEmployee() {
		System.out.println("Calling saveEmployee() ");
		Session session = null;
		SessionFactory sessionFactory = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			/********* Employee Persistent ********/
			EmployeeEntity emp = new EmployeeEntity();
			emp.setEmail("manju-employee@mail.com");
			emp.setFirstName("manju name");
			emp.setLastName("singraul name");
            // Save the employee entity to the database
			session.save(emp);
			//commit the transaction to persist the changes
			tx.commit();
			System.out.println("Employee Saved Successfully with ID: " + emp.getEmployeeId());
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
				HibernateUtil.shutdownSessionFactory();
			}
		}
	}

}
