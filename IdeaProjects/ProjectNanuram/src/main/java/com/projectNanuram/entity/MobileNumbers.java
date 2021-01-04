package com.projectNanuram.entity;

import org.hibernate.annotations.ManyToAny;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class MobileNumbers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "mobile_number" , unique = true)
    @Nullable
    private String mobileNumber;
    @Column(name = "number_type")
    private NumberType type;
    @NotNull
    private boolean isPrimary;

    @ManyToOne
    private Person person;
    //No arg constructor
    public MobileNumbers() {

    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public NumberType getType() {
        return type;
    }

    public void setType(NumberType type) {
        this.type = type;
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    public void setPrimary(boolean primary) {
        isPrimary = primary;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
