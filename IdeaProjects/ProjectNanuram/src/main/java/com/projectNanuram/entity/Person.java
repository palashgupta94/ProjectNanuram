package com.projectNanuram.entity;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Entity

public class Person {

    @Id
    private String personId;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String status;
    @NotNull
    private String relationWithHead;
    @NotNull
    private String Gender;
    @NotNull
    private String DOB;
    @NotNull
    private int age;
    @Nullable
    private String familyGotra;
    @Nullable
    private String motherGotra;
    @NotNull
    private String educationalStatus;
    @NotNull
    private String occupation;
//    private String contactNumber;
    @Nullable
    private String imgUrl;
    private boolean isMarried;
    private boolean isSpeciallyAbled;
    private boolean isMan;
    private boolean isWoman;
    private boolean isGirl;
    private boolean isBoy;
    private boolean isSenior;

    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    private List<MobileNumbers> mobileNumbers = new ArrayList<>();

    @ManyToOne
    private Family family;

    public Person() {
    }

    public Person(String personId, @NotNull String firstName, @NotNull String lastName, @NotNull String status,
                  @NotNull String relationWithHead, @NotNull String gender, @NotNull String DOB,
                  @NotNull int age, @Nullable String familyGotra, @Nullable String motherGotra, @NotNull String educationalStatus,
                  @NotNull String occupation, @Nullable String imgUrl, boolean isMarried,
                  boolean isSpeciallyAbled, List<MobileNumbers> mobileNumbers, Family family) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
        this.relationWithHead = relationWithHead;
        Gender = gender;
        this.DOB = DOB;
        this.age = age;
        this.familyGotra = familyGotra;
        this.motherGotra = motherGotra;
        this.educationalStatus = educationalStatus;
        this.occupation = occupation;
        this.imgUrl = imgUrl;
        this.isMarried = isMarried;
        this.isSpeciallyAbled = isSpeciallyAbled;
        this.mobileNumbers = mobileNumbers;
        this.family = family;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRelationWithHead() {
        return relationWithHead;
    }

    public void setRelationWithHead(String relationWithHead) {
        this.relationWithHead = relationWithHead;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Nullable
    public String getFamilyGotra() {
        return familyGotra;
    }

    public void setFamilyGotra(@Nullable String familyGotra) {
        this.familyGotra = familyGotra;
    }

    @Nullable
    public String getMotherGotra() {
        return motherGotra;
    }

    public void setMotherGotra(@Nullable String motherGotra) {
        this.motherGotra = motherGotra;
    }

    public String getEducationalStatus() {
        return educationalStatus;
    }

    public void setEducationalStatus(String educationalStatus) {
        this.educationalStatus = educationalStatus;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Nullable
    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(@Nullable String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public void setMarried(boolean married) {
        isMarried = married;
    }

    public boolean isSpeciallyAbled() {
        return isSpeciallyAbled;
    }

    public void setSpeciallyAbled(boolean speciallyAbled) {
        isSpeciallyAbled = speciallyAbled;
    }

    public boolean isMan() {
        return isMan;
    }

    public void setMan(boolean man) {
        isMan = man;
    }

    public boolean isWoman() {
        return isWoman;
    }

    public void setWoman(boolean woman) {
        isWoman = woman;
    }

    public boolean isGirl() {
        return isGirl;
    }

    public void setGirl(boolean girl) {
        isGirl = girl;
    }

    public boolean isBoy() {
        return isBoy;
    }

    public void setBoy(boolean boy) {
        isBoy = boy;
    }

    public boolean isSenior() {
        return isSenior;
    }

    public void setSenior(boolean senior) {
        isSenior = senior;
    }

    public List<MobileNumbers> getMobileNumbers() {
        return mobileNumbers;
    }

    public void setMobileNumbers(List<MobileNumbers> mobileNumbers) {
        this.mobileNumbers = mobileNumbers;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }
}
