package mainaha.hibernate.demo.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();
 
	/**
	 * This method initializes and returns the Hibernate SessionFactory.
	 * @return SessionFactory instance
	 * 	since version 4.x, service registry is being used
     *  service registry is a new concept in Hibernate 4.x, 
     *  it is a new way of bootstrapping Hibernate and it is used to configure and build the SessionFactory.
	 */
    private static SessionFactory buildSessionFactory() {
     
        if (sessionFactory == null) {
            try {
            	System.out.println("Hibernate setup successful!");
                // 1. Load the configuration file (defaults to hibernate.cfg.xml)
                Configuration configuration = new Configuration().configure();

                // 2. Build the ServiceRegistry using configuration properties
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties())
                        .build();

                // 3. Build the SessionFactory using the service registry
                return configuration.buildSessionFactory(serviceRegistry);
                
                
            } catch (Throwable ex) {
            	  System.err.println("SessionFactory creation failed." + ex);
                  throw new ExceptionInInitializerError(ex);
            }
        }else {
			return sessionFactory;
		}
        
    }
 
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
     // shut down the session factory, releasing all resources
    public static void shutdownSessionFactory() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
 
}