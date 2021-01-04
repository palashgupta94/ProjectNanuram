package com.projectNanuram.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

public class Contacts {


    private String personId;
    private List<MobileNumbers> mobileNumbers = new ArrayList<>();


    public Contacts() {
    }

    public Contacts(String personId , List<MobileNumbers> mobileNumbers) {
        this.personId = personId;
        this.mobileNumbers = mobileNumbers;

    }

    public List<MobileNumbers> getMobileNumbers() {
        return mobileNumbers;
    }

    public void setMobileNumbers(List<MobileNumbers> mobileNumbers) {
        this.mobileNumbers = mobileNumbers;
    }
}
