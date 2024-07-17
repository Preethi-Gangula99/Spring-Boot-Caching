//
//package com.example.cache_practice.config;
//
//import com.example.cache_practice.entities.Book;
//import com.fasterxml.jackson.databind.cfg.CacheProvider;
//import org.ehcache.config.CacheConfiguration;
//import org.ehcache.config.builders.CacheConfigurationBuilder;
//import org.ehcache.config.builders.ExpiryPolicyBuilder;
//import org.ehcache.config.builders.ResourcePoolsBuilder;
//import org.ehcache.config.units.MemoryUnit;
//import org.ehcache.jsr107.Eh107Configuration;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.cache.jcache.JCacheCacheManager;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//
//import javax.cache.CacheManager;
//import javax.cache.Caching;
//import javax.cache.spi.CachingProvider;
//import java.net.URI;
//import java.time.Duration;
//import java.util.Objects;
//
//@Configuration
//@EnableCaching
//public class EhCacheConfig {
//
//    @Bean
//    public  CacheManager cacheManager(){
////        try{
////            CachingProvider cachingProvider = Caching.getCachingProvider();
////            URI uri = Objects.requireNonNull(getClass().getResource("/ehcache.xml")).toURI();
////            CacheManager cacheManager = cachingProvider.getCacheManager(uri,
////                    getClass().getClassLoader());
////            return new JCacheCacheManager(cacheManager).getCacheManager();
////        } catch (Exception e){
////            throw new RuntimeException("Failed to configure Ehcache",e);
////        }
//        CacheConfiguration<Long, Book>  cacheConfig = CacheConfigurationBuilder
//                .newCacheConfigurationBuilder(Long.class,Book.class,
//                        ResourcePoolsBuilder.newResourcePoolsBuilder().offheap(10, MemoryUnit.MB)
//                                .build())
//                .withExpiry(ExpiryPolicyBuilder.timeToIdleExpiration(Duration.ofSeconds(10)))
//                .build();
//        CachingProvider cacheProvider = Caching.getCachingProvider();
//        CacheManager cacheManager = cacheProvider.getCacheManager();
//        javax.cache.configuration.Configuration<Long,Book> configuration = Eh107Configuration.fromEhcacheCacheConfiguration(cacheConfig);
//        cacheManager.createCache("books",configuration);
//        return cacheManager;
//    }
//}
//
