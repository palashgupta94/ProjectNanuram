package com.projectNanuram.controller;

import com.projectNanuram.Dao.daoInterfaces.FamilyDao;
import com.projectNanuram.entity.*;

import com.projectNanuram.helper.AgeCalculator;
import com.projectNanuram.helper.IdentityHelper;
import com.projectNanuram.helper.ReferenceHelper;
import com.projectNanuram.helper.RowHelper;
import com.projectNanuram.service.FamilyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


@Controller
public class HomeController {

    static {
        System.out.println("Hello");
    }

    @Autowired
    private FamilyDao familyDao;

    @Autowired
    private FamilyService familyService;

    @Autowired
    private Family family;


    @GetMapping("/showForm")
    public String showForm(Model model) {

        PersonWrapper wrapper = new PersonWrapper();

        int rowNum = (int) model.asMap().get("rowValue");
        System.out.println("rownum :" + rowNum);
        model.addAttribute(wrapper);
        model.addAttribute("rowNum", rowNum);
        model.addAttribute("referenceData", ReferenceHelper.referenceData());
        return "registrationForm";

    }

    @GetMapping("/showCard")
    public String getInputForLoop(Model model) {

        RowHelper helper = new RowHelper();
        model.addAttribute("referenceData", ReferenceHelper.referenceData());
        model.addAttribute(helper);
        return "card";

    }

    @PostMapping("/saveCard")
    public String SaveCard(@ModelAttribute("helper") RowHelper helper, RedirectAttributes redirectAttributes) {
        System.out.println(helper.getNumberofRows());

        redirectAttributes.addFlashAttribute("rowValue", helper.getNumberofRows());
        return "redirect:/showForm";

    }


//

    @PostMapping("/save")
    public String save(@ModelAttribute("wrapper") PersonWrapper wrapper, HttpSession session) {

        try {
            family.setFamilyId(IdentityHelper.familyIdGenerator());
            List<Person> personList = wrapper.getMembers();
            List<Address> addressList = wrapper.getAddresses();

            for (Person person : personList) {

                if (person != null) {
//
                    if (person.getGender().equalsIgnoreCase("Male") || person.getGender().equalsIgnoreCase("female")) {

                        System.out.println(person.getDOB().getClass());
                        System.out.println(person.getDOB());
                        int age = AgeCalculator.age(person.getDOB());
                        if (age < 18) person.setBoy(true);
                        else if (age < 60) person.setMan(true);
                        else person.setSenior(true);
                    }
                    String pId = IdentityHelper.personIdGenerator();
                    person.setPersonId(pId);
                    person.setFamily(family);

                    List<MobileNumbers> mobileNumbersList = person.getMobileNumbers();
                    List<MobileNumbers> newlist = new ArrayList<>();
                    for (MobileNumbers number : mobileNumbersList) {
                        if (number.getMobileNumber() != null && !number.getMobileNumber().isEmpty()) {
                            newlist.add(number);
                        }
                    }
                    if (!newlist.isEmpty()) {
                        person.setMobileNumbers(newlist);
                    }
                    if (!newlist.isEmpty()) {
                        for (MobileNumbers mobileNumbers : newlist) {
                            mobileNumbers.setPerson(person);
                            mobileNumbers.setId(pId+newlist.indexOf(mobileNumbers));

                            if(mobileNumbers.getPrimaryString().equalsIgnoreCase("true")){
                                mobileNumbers.setPrimary(true);
                            }
                            else{
                                mobileNumbers.setPrimary(false);
                            }
                        }
                    }

                    family.getMember().add(person);
                    family.setTotalMembers(personList.size());
                }
            }
            if (!addressList.isEmpty()) {
                for (Address address : addressList) {
                    address.setFamily(family);
                    family.getAddresses().add(address);
                }
            }
            familyService.saveFamily(family);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "success";

    }


}