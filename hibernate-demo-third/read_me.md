# Hibernate - Caching
Caching in Hibernate stores frequently accessed data in memory to reduce database calls
 and improve application performance.

## Hibernate Cache Types
- First-Level Cache: Default, session-scoped, clears when the session closes.
- Second-Level Cache: Optional, SessionFactory-scoped, persists across sessions.
- Query Cache: Caches query results, requires second-level cache.
- Collection Cache: Caches entity relationships (e.g., @OneToMany lists).

## How Hibernate Caches Work?
- Data Retrieval: Hibernate checks the cache before querying the database.
- Cache Hit: If data is cached, it’s returned immediately.
- Cache Miss: If not cached, Hibernate queries the database and caches the result.
- Eviction/Update: Cached data is updated or evicted based on configuration (e.g., expiration, entity changes).

## Advantages of caching in Hibernate
- Improved Performance: Reduces database round-trips by serving data from memory.
- Reduced Database Load: Minimizes queries, enhancing scalability.
- Increased Concurrency: Serves multiple requests simultaneously from cache.
- Customizable: Supports configurable providers, regions, strategies and eviction policies.

## Second-level cache providers in Hibernate
- Ehcache(Easy Hibernate Cache): Efficient in-memory cache with expiration, distributed and persistent caching.
- Hazelcast: In-memory data grid with partitioning, replication and failover.
- JBoss Cache: Scalable, distributed and transactional caching
- OSCache(Open Symphony Cache): Supports caching to memory and disk in a single JVM with a rich set of
  expiration policies and query cache support.
  
## How to configure the second-level cache?
- Choose a cache provider
- Add Provider to Classpath or add maven dependency 
- Configure Hibernate Properties in hibernate.cfg.xml file
- Configure entity caching
- Configure query caching

## Cache concurrency strategies provided by Hibernate
- CacheConcurrencyStrategy.NONE
- CacheConcurrencyStrategy.READ_ONLY
- CacheConcurrencyStrategy.NONSTRICT_READ_WRITE
- CacheConcurrencyStrategy.READ_WRITE
- CacheConcurrencyStrategy.TRANSACTIONAL


### Reference 
- https://www.geeksforgeeks.org/java/hibernate-caching/
- https://www.geeksforgeeks.org/java/hibernate-enable-and-implement-first-and-second-level-cache/
- https://medium.com/@toimrank/all-about-hibernate-caching-in-detail-f9251fcebab1
- https://dev.to/wittedtech-by-harshit/hibernate-caches-speed-up-your-db-queries-m41
- https://www.tutorialspoint.com/hibernate/hibernate_caching.htm