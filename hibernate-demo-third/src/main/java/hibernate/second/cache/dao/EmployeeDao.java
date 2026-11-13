package hibernate.second.cache.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.stat.Statistics;

import hibernate.second.cache.model.Address;
import hibernate.second.cache.model.Employee;
import hibernate.second.cache.util.HibernateUtil;

/**
 * Hibernate EHCache Example for Second Level Cache
 */
public class EmployeeDao {

	public static void main(String[] args) {

		System.out.println("Temp Dir:" + System.getProperty("java.io.tmpdir"));

		// Initialize Sessions
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Statistics stats = sessionFactory.getStatistics();
		System.out.println("Stats enabled=" + stats.isStatisticsEnabled());
		stats.setStatisticsEnabled(true);
		System.out.println("Stats enabled=" + stats.isStatisticsEnabled());

		Session session = sessionFactory.openSession();
		Session otherSession = sessionFactory.openSession();
		

		printStats(stats, 0);

		Employee emp = null;

		try {		

			try {
				Transaction otherTransaction = otherSession.beginTransaction();
				saveEmp(otherSession, otherTransaction);
				otherTransaction.commit();
			} catch (Exception e) {
                e.printStackTrace();
				System.out.println("Employee already exists, skipping save.");
			}

			emp = (Employee) session.load(Employee.class, new Long(3));
			printData(emp, stats, 1);

			emp = (Employee) session.load(Employee.class, 3L);
			printData(emp, stats, 2);

			// clear first level cache, so that second level cache is used
			session.evict(emp);
			emp = (Employee) session.load(Employee.class, 3L);
			printData(emp, stats, 3);

			emp = (Employee) session.load(Employee.class, 4L);
			printData(emp, stats, 4);

			emp = (Employee) otherSession.load(Employee.class, 4L);
			printData(emp, stats, 5);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Release resources
			session.close();
			otherSession.close();
			sessionFactory.close();
		}
	}

	private static void saveEmp( Session session, Transaction transaction) {

		Address a1 = new Address(" Bharahut Unchehara", "485661", "Satna");

		Employee e1 = new Employee("Namo Great", 90000.00);
		
		e1.setAddress(a1);
		
		a1.setEmployee(e1);

		session.save(e1);

	}

	private static void printStats(Statistics stats, int i) {
		System.out.println("***** " + i + " *****");
		System.out.println("Fetch Count=" + stats.getEntityFetchCount());
		System.out.println("Second Level Hit Count=" + stats.getSecondLevelCacheHitCount());
		System.out.println("Second Level Miss Count=" + stats.getSecondLevelCacheMissCount());
		System.out.println("Second Level Put Count=" + stats.getSecondLevelCachePutCount());
	}

	private static void printData(Employee emp, Statistics stats, int count) {
		System.out.println(count + ":: Name=" + emp.getName() + ", Zipcode=" + emp.getAddress().getZipcode());
		printStats(stats, count);
	}

}
