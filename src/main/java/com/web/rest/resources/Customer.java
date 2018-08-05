package com.web.rest.resources;

public class Customer {

    private String name;
    private String id;

    public Customer(String name, String id){
        this.name = name;
        this.id = id;
    }

    public String getName(){ return this.name; }
    public String getId(){ return this.id; }
}
