package mainaha.hibernate.demo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import mainaha.hibernate.demo.bean.StudentBean;
import mainaha.hibernate.demo.util.HibernateUtil;

public class StudentDao {

	public static void main(String[] args) {
		System.out.println("Student Dao started..............!");

		StudentBean student = new StudentBean(103, "Nitin", "IT", "Rewa");
		createStudent(student);

		StudentBean studentById = getStudent(105);
		System.out.println("studentById " + studentById);

		updateStudent(new StudentBean(106 ,"Devendra","EC","Maihar"));
		
		deleteStudent(108);
		
		System.out.println("Student Dao ended..............!");
	}

	public static void createStudent(StudentBean student) {
		System.out.println("Calling createStudent() ");
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			/********* Student Persistent ********/
			int newStudentId = (Integer) session.save(student);
			tx.commit();
			System.out.println("newStudentId " + newStudentId);
			// transaction management approach in case of FATAL
		} catch (RuntimeException e) {
			try {
				tx.rollback();
			} catch (RuntimeException rbe) {
				System.out.println("Couldn’t roll back transaction");
			}
		} finally {
			if (session != null) {
				// HibernateUtil.shutdown();
			}
		}
		System.out.println("Student record created successfully!");
	}

	public static StudentBean getStudent(int studentId) {
		System.out.println("Calling getStudent() ");
		Session session = null;
		StudentBean student = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			// // Fetch by ID using get method
			student = (StudentBean) session.get(StudentBean.class, studentId);
			if (student != null) {
				System.out.println("roll no: " + student.getRollNo());
				System.out.println("name: " + student.getStudName());
				System.out.println("branch: " + student.getBranch());
				System.out.println("city: " + student.getCity());

			} else {
				System.out.println("Student not found.");
			}
		} catch (RuntimeException ex) {
			System.out.println("Exception " + ex);
		} finally {
			if (session != null) {
				// HibernateUtil.shutdown();
			}
		}
		System.out.println("Student record fetched successfully!");
		return student;
	}

	public static void updateStudent(StudentBean updateStudent) {
		System.out.println("Calling updateStudent() ");
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();

			// Fetch by ID using get method
			StudentBean student = (StudentBean) session.get(StudentBean.class, updateStudent.getRollNo());

			student.setBranch(updateStudent.getBranch());
			student.setStudName(updateStudent.getStudName());
			student.setCity(updateStudent.getCity());
			
			/********* Student updated ********/
			session.saveOrUpdate(student);
			tx.commit();
			// transaction management approach in case of FATAL
		} catch (RuntimeException e) {
			try {
				tx.rollback();
			} catch (RuntimeException rbe) {
				System.out.println("Couldn’t roll back transaction");
			}
		} finally {
			if (session != null) {
				// HibernateUtil.shutdown();
			}
		}
		System.out.println("Student record updated successfully!");
	}
	
	public static void deleteStudent(int rollNo) {
		System.out.println("Calling deleteStudent() ");
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();

			// Fetch by ID using get method
			StudentBean student = (StudentBean) session.get(StudentBean.class, rollNo);
			
			 if (student != null) {
					/********* Student updated ********/
		            session.delete(student);
		            System.out.println("Student record deleted successfully!");
		        } else {
		            System.out.println("Student not found.");
		        }
			
			tx.commit();
			// transaction management approach in case of FATAL
		} catch (RuntimeException e) {
			try {
				tx.rollback();
			} catch (RuntimeException rbe) {
				System.out.println("Couldn’t roll back transaction");
			}
		} finally {
			if (session != null) {
				HibernateUtil.shutdown();
			}
		}
		System.out.println("Student record deleted successfully!");
	}
}
