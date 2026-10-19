# Hibernate Framework Introduction
 Hibernate is an Object Relational Mapping (ORM) framework for Java, which simplifies database operations by mapping Java classes to database tables. 
 It eliminates the need for manual JDBC code, providing cleaner and more maintainable applications.Hibernate implements the specifications of JPA (Java Persistence API) for data persistence.
 

## Key features of Hibernate
- Object-Relational Mapping (ORM)
- Database Independence
- Caching
- Lazy Loading
- Transaction Management
-  Hibernate Query Language (HQL)
- Annotations and XML Configuration

## Advantages Of Hibernate In Java
- Lightweight and open-source – Being lightweight and open-source makes it accessible and efficient.
- Increased performance – Using cache memory helps in fast performance.
- Database Independence – Being database-independent gives it the ability to work with different databases.
- Auto DDL Operations – automatic table creation saves us from manually creating tables.
- It takes care of mapping Java classes databases using XML files without writing any code.
  We can directly store and retrieve data directly from the database using simple APIs.
- It does not require any application server to operate.
- Minimizes database access with smart fetching strategies.
- It provides simple querying of data.

## Elements of Hibernate Architecture
- SessionFactory 
 The SessionFactory is a factory of session and client of ConnectionProvider. It holds second level cache (optional) of data. The org.hibernate.SessionFactory interface provides factory method to get the object of Session.

- Session
 The session object provides an interface between the application and data stored in the database. It is a short-lived object and wraps the JDBC connection. It is factory of Transaction, Query and Criteria. It holds a first-level cache (mandatory) of data. The org.hibernate.Session interface provides methods to insert, update and delete the object. It also provides factory methods for Transaction, Query and Criteria.
- Transaction
 The transaction object specifies the atomic unit of work. It is optional. The org.hibernate.Transaction interface provides methods for transaction management.

- ConnectionProvider
  It is a factory of JDBC connections. It abstracts the application from DriverManager or DataSource. It is optional.

- TransactionFactory
 It is a factory of Transaction. It is optional.

## Hibernate Work flow 
-  Application loads configuration (hibernate.cfg.xml).
-  Hibernate builds a SessionFactory.
-  Application requests a Session from SessionFactory.
-  Inside a Session:
 
   Begin Transaction
   Perform CRUD operations
   Commit or Rollback transaction
- 5. Hibernate translates operations -> SQL-> executes via JDBC.
- 6. Results are returned as Java objects

## Hibernate Caching Levels 
- First-Level Cache (Session-level): Always enabled
- Second-Level Cache (SessionFactory-level): Optional / Configurable

## Hibernate Mapping
- One-to-One Mapping
- One-to-Many Mapping
- Many-to-One Mapping
- Many-to-Many Mapping
- Component Mapping

## Hibernate/JPA Annotations
- @Embeddable vs @Embedded
- @Entity
- @Table
- @Column
- @Id
- @GeneratedValue
- @Version
- @OrderBy
- @Transient

## Hibernate Lifecycle or Entity Object Lifecycle in Hibernate Framework
- Transient State
- Persistent State
- Detached State
- Removed State

### Main Reference Link 
- https://www.geeksforgeeks.org/java/hibernate-tutorial/
- https://www.tpointtech.com/hibernate-tutorial

### Other Reference Link 
- https://www.geeksforgeeks.org/advance-java/jpa-object-relational-mapping/
- https://www.geeksforgeeks.org/java/introduction-to-hibernate-framework/
- https://www.edureka.co/blog/what-is-hibernate-in-java/
- https://www.devopsschool.com/blog/what-is-hibernate-and-use-cases-of-hibernate/
- https://www.geeksforgeeks.org/java/hibernate-enable-and-implement-first-and-second-level-cache/
