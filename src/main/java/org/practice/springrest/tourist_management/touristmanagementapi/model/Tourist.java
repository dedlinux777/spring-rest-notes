package org.practice.springrest.tourist_management.touristmanagementapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tourist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String city;
    private String country;
    private String passport_no;
    private Integer budget;

    public Tourist() {
    }

    public Tourist(Integer id, String name, String city, String country, String passport_no, Integer budget) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.country = country;
        this.passport_no = passport_no;
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "Tourist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", passport_no='" + passport_no + '\'' +
                ", budget=" + budget +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPassport_no() {
        return passport_no;
    }

    public void setPassport_no(String passport_no) {
        this.passport_no = passport_no;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }
}
