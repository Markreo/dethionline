dataSource {
    pooled = true
    jmxExport = true
    driverClassName = "org.postgresql.Driver"
    username = "postgres"
    password = "123456"
    dialect = "org.hibernate.dialect.PostgreSQLDialect"
    properties {
        maxActive = 1000
        maxIdle = 100
        minIdle = 50
        initialSize =50
        minEvictableIdleTimeMillis = 60000
        timeBetweenEvictionRunsMillis = 60000
        maxWait = 10000
        testOnBorrow = true
        testWhileIdle = false
        testOnReturn = false
        validationQuery = 'select 1 from dual'
    }
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
//    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory' // Hibernate 3
    cache.region.factory_class = 'org.hibernate.cache.ehcache.EhCacheRegionFactory' // Hibernate 4
    singleSession = true // configure OSIV singleSession mode
    flush.mode = 'manual' // OSIV session flush mode outside of transactional context
}

// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "update" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:postgresql://127.0.0.1:5432/dethionline"
            username = "postgres"
            password = "123456"
        }
    }
    test {
        dataSource {

        }
    }
    production {
        dataSource {

        }
    }
}
