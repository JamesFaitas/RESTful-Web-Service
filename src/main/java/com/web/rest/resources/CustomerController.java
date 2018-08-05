package com.web.rest.resources;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@CacheConfig(cacheNames = {"customerCache"})
@RestController
public class CustomerController {

    private Logger log = Logger.getLogger(CustomerController.class.getName());


    @RequestMapping("/customer")
    @Cacheable
    public Customer output(){
        log.info("Got customer..");
        return new Customer("James" , "123");
    }

}
