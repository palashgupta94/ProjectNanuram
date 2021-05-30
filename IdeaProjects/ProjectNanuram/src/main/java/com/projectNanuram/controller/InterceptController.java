package com.projectNanuram.controller;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.projectNanuram.helper.DataHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class InterceptController {

    @Autowired
    private DataHelper dataHelper;

    @Autowired
    private HomeController controller;

    @Autowired
    private ObjectMapper mapper;

//    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping(value = "/getDataFromPython" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String  getDataFromPython(@RequestBody Map<String , List<String>> json) throws IOException {

        System.out.println("running");
        int x = 1;

//        System.out.println(json);

        List<String> helperlist = json.get("district");
        System.out.println(helperlist);
        List<String> Districts = new ArrayList<>();

        for(int i = 0; i < helperlist.size(); i++){

            Districts.add(helperlist.get(i).toString());
        }
        dataHelper.setDistricts(Districts);


        Map<String , String>districtsMap = new HashMap<>();

        for(String District : dataHelper.getDistricts()){
            districtsMap.put(""+x++ , District);
        }

        System.out.println(districtsMap);
//
//
//        controller.referenceData().put("districtMap" , districtsMap);
//

        return "done";

    }
}
