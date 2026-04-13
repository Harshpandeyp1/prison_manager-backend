package com.prisonmanager.React.controller;


import com.prisonmanager.React.DTO.FacilitiesDto;
import com.prisonmanager.React.Entity.Inmate;
import com.prisonmanager.React.Repo.InmateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/facilities")
@CrossOrigin(origins="http://localhost:5173")
public class FacilitiesController {

    @Autowired
    private InmateRepository inmateRepository;
    @GetMapping
    public List<FacilitiesDto>getFacilities(){
        //fetch data of inmate
        List<Inmate>inmates=inmateRepository.findAll();


        //count inmate

        Map<String,Long>blockcount= inmates.stream()
                .filter(i->i.getBlock()!=null)
                .collect(Collectors.groupingBy(
                        Inmate::getBlock,
                        Collectors.counting()
                ));
        //define fix capacity of each block
        Map<String,Integer>CapacityMap=new HashMap<>();
        CapacityMap.put("Alpha", 100);
        CapacityMap.put("Bravo", 120);
        CapacityMap.put("Charlie", 150);
        CapacityMap.put("Delta", 80);
    
    //convert raw data into structurd dto
    List<FacilitiesDto>result=new ArrayList<>();
    //build dto for each bock
    for(String block:CapacityMap.keySet()){
        long occupied=blockcount.getOrDefault(block,0L);

        // create DTO object
        FacilitiesDto dto = new FacilitiesDto(
                block,
                occupied,
                CapacityMap.get(block)
        );

        // add to final response list
        result.add(dto);
    }

    // STEP 6: Return final structured data to frontend
        return result;

    }
}
