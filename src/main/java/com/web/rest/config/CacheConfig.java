package com.web.rest.config;

import com.web.rest.resources.CustomerController;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.logging.Logger;

@Configuration
@EnableCaching
@EnableScheduling
public class CacheConfig {

    private static final long CACHE_FLUSH = 6000 * 10;
    private static Logger log = Logger.getLogger(CacheConfig.class.getName());

    @Bean
    public CustomerController customerController(){
        return new CustomerController();
    }

    @Bean
    public CacheManager cacheManager(){
        return new ConcurrentMapCacheManager("customerCache");
    }

    @CacheEvict(value = "customerCache" , allEntries = true)
    @Scheduled(fixedRate = CACHE_FLUSH)
    public void clearCache(){
        log.info("Cache flushed");
    }
}
