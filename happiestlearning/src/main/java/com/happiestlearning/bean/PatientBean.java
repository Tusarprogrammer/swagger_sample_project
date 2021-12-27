package com.happiestlearning.bean;

import org.apache.tomcat.jni.Address;

public class PatientBean {
    public PatientBean(String name, String id) {
        super();
        this.name = name;
        this.id = id;
    }

    public PatientBean() {
        super();
    }

    private String name;
    private String id;
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
