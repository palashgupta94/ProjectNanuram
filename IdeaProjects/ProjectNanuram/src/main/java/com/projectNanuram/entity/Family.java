package com.projectNanuram.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity

public class Family {

    @Id
    private int familyId;
    private int totalMembers;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Person> members = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Address> addresses = new ArrayList<>();

    public Family(){}

    public Family(int familyId, int totalMembers, List<Person> member) {
        this.familyId = familyId;
        this.totalMembers = totalMembers;
        this.members = member;
    }

    public int getFamilyId() {
        return familyId;
    }

    public void setFamilyId(int familyId) {
        this.familyId = familyId;
    }

    public int getTotalMembers() {
        return totalMembers;
    }

    public void setTotalMembers(int totalMembers) {
        this.totalMembers = totalMembers;
    }

    public List<Person> getMember() {
        return members;
    }

    public void setMember(List<Person> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "Family{" +
                "familyId=" + familyId +
                ", totalMembers=" + totalMembers +
                ", member=" + members +
                '}';
    }
}