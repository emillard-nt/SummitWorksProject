package com.brightrace.summitworksproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DonationType {

    private Integer id;
    private String name;
    boolean active;

    public DonationType() {
        this.id = 0 ;
    }

    public DonationType(Integer id, String name, boolean active) {
        this.id = id;
        this.name = name;
        this.active = active;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() { return id; }
    public String getName() { return name; }
    public boolean isActive() { return active; }

    public void setId(Integer id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setActive(boolean active) { this.active = active; }

}
