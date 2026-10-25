# Hibernate ServiceRegistry
In Hibernate, the ServiceRegistry acts as a lightweight Inversion of Control (IoC) container that hosts, manages, and provides pluggable access to Hibernate's underlying services.
Services in Hibernate represent distinct functional building blocks (such as managing database connections, handling transactions, or caching data). 
The ServiceRegistry manages the entire lifecycle, scoping, and dependency injection of these services.
Service registry is a new concept in Hibernate 4.x.

## Types of ServiceRegistries
- BootstrapServiceRegistry (The Root)
- StandardServiceRegistry (The Main Registry)
- SessionFactoryServiceRegistry (The Leaf)

## Service lifecycle
- initiation
- (optional) configuration
- (optional) starting
- in use - until registry closed
- (optional) stopping


#### Reference 
- https://docs.hibernate.org/orm/5.3/topical/html_single/registries/ServiceRegistries.html