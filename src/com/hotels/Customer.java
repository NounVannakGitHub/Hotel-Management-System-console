package com.hotels;

/**
 * Created by kaustavc on 3/14/2015.
 */
public class Customer {
    private final String name;
    private int phone;
    private int age;
    private City city;

    public Customer(String name, City city, int age, int phoneNumber) {
        this.name = name;
        this.city = city;
        this.age = age;
        this.phone = phoneNumber;
    }

    public Details getDetails() {
        return new Details(name, age, city, phone);
    }
}
