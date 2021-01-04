package com.projectNanuram.service;

import com.projectNanuram.entity.Address;
import com.projectNanuram.entity.Family;
import com.projectNanuram.entity.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamilyServiceImpl implements FamilyService {


    @Override
    public Family getFamilyDetails() {
        Family family = new Family();
        return null;
    }

    @Override
    public List<Family> getAllFamilyDetails() {
        return null;
    }

    @Override
    public Family getFamilyById(String familyId) {
        return null;
    }

    @Override
    public int getTotalMemberCount(String familyId) {
        return 0;
    }

    @Override
    public List<Person> getMembersDetails(String familyId) {
        return null;
    }

    @Override
    public List<Address> getFamilyAddress(String familyId) {
        return null;
    }

    @Override
    public Family getFamilyByAddress(Address address) {
        return null;
    }

    @Override
    public Family getFamilyDetails(String personId) {
        return null;
    }

    @Override
    public Person getHeadOfTheFamily(String familyId) {
        return null;
    }

    @Override
    public void saveFamily(Family family) {

    }

    @Override
    public Family updateFamilyDetails(String familyId) {
        return null;
    }

    @Override
    public void deleteFamily(String familyId) {

    }
}
