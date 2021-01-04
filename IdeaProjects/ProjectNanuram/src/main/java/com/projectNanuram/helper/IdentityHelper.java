package com.projectNanuram.helper;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class IdentityHelper {

    public String getPersonId(String id , int num){

        String familyId = id;
        String str = familyId+"_"+num;
        return str;
    }

    public String getFamilyId(String cityCode){

        Random random = new Random();
        int randomNumber = random.nextInt(6);
        String familyId = cityCode+"_"+randomNumber;
        return familyId;
    }
}
