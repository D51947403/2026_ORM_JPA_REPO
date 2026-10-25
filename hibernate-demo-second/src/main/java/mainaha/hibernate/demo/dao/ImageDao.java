package mainaha.hibernate.demo.dao;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import mainaha.hibernate.demo.entity.ImageEntity;

public class ImageDao {

	public static void main(String[] args) {
		System.out.println("ImageDao Started............!");
		 //saveImage();
		readImage(7);
		System.out.println("ImageDao End................!");
	}

	public static void saveImage() {
		System.out.println("saveImage Started............!");
		Session session = null;
		SessionFactory sessionFactory = null;
		Transaction tx = null;
		try {
			// this will read hibernate.cfg.xml and prepare hibernate for use
			Configuration config = new Configuration().configure();

			// Build the ServiceRegistry using configuration properties
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties())
					.build();

			// Build the SessionFactory using the service registry
			sessionFactory = config.buildSessionFactory(serviceRegistry);

			// Open a new session from the SessionFactory
			session = sessionFactory.openSession();

			// Begin a transaction
			tx = session.beginTransaction();

			File imgFile = new File("D:\\2026_java_notes\\app_images\\devendra2.jpg");

			byte[] imageData = new byte[(int) imgFile.length()];

			try {
				FileInputStream fileInputStream = new FileInputStream(imgFile);

				fileInputStream.read(imageData);

				fileInputStream.close();
			} catch (Exception e) {
				System.err.println("Image save failed ...........!");
				e.printStackTrace();
			}

			File photoFile = new File("D:\\2026_java_notes\\app_images\\devendra1.jpg");
			byte[] photoData = new byte[(int) photoFile.length()];
			try {
				FileInputStream photoInputStream = new FileInputStream(photoFile);

				photoInputStream.read(photoData);

				photoInputStream.close();
			} catch (Exception e) {
				System.err.println("photo save failed ...........!");
				e.printStackTrace();
			}

			ImageEntity imageObj = new ImageEntity();
			imageObj.setImageData(imageData);
			imageObj.setImageName("applicationImg.jpg");
			imageObj.setPhotoData(photoData);

			// Save the image object to the database
			session.save(imageObj); // Save the data
			// Commit the transaction
			tx.commit();

			System.out.println("Image Saved successfully............!");
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			System.err.println("Image save exception ...........!");
			e.printStackTrace();
		} finally {
			// Close the session only if the sessionFactory is not null and is open
			session.close();

			if (sessionFactory != null && !sessionFactory.isClosed()) {
				sessionFactory.close();
			}
		}

	}

	public static void readImage(int imageId) {

		System.out.println("saveImage Started............!");
		Session session = null;
		SessionFactory sessionFactory = null;
		try {
			// this will read hibernate.cfg.xml and prepare hibernate for use
			Configuration config = new Configuration().configure();

			// Build the ServiceRegistry using configuration properties
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties())
					.build();

			// Build the SessionFactory using the service registry
			sessionFactory = config.buildSessionFactory(serviceRegistry);

			// Open a new session from the SessionFactory
			session = sessionFactory.openSession();

			// Retrieve the entity by its ID (e.g., ID = 1)

			ImageEntity retrievedImage = (ImageEntity) session.get(ImageEntity.class, imageId);

			if (retrievedImage != null) {
				System.out.println("Found image record: " + retrievedImage.getImageName());

				// 4. Extract the byte array
				byte[] imageBytes = retrievedImage.getImageData();
				byte[] photoBytes = retrievedImage.getPhotoData();

				// 5. Save the byte array to a physical file
				Path outputPath = Paths.get("output_images/" + retrievedImage.getImageName());
				Path outputPhotoPath = Paths.get("output_photo/" + "photo_" + retrievedImage.getImageName());

				// Ensure parent directories exist
				Files.createDirectories(outputPath.getParent());
				Files.write(outputPath, imageBytes);

				// Ensure parent directories exist
				Files.createDirectories(outputPhotoPath.getParent());
				Files.write(outputPhotoPath, photoBytes);

				System.out.println("Image successfully saved to: " + outputPath.toAbsolutePath());
			} else {
				System.out.println("No image record found with imageId: " + imageId);
			}

		} catch (Exception e) {

			System.err.println("Image read exception ...........!");
			e.printStackTrace();
		} finally {
			// Close the session only if the sessionFactory is not null and is open
			session.close();

			if (sessionFactory != null && !sessionFactory.isClosed()) {
				sessionFactory.close();
			}
		}

	}

}
