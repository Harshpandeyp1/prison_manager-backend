package com.prisonmanager.React.controller;

import com.prisonmanager.React.Entity.visitor;

import com.prisonmanager.React.service.visitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visitors")
@CrossOrigin(origins="http://localhost:5173")
public class visitorController {

    @Autowired
    public visitorService visitorService;

    @PostMapping
    public visitor addVisitor(@RequestBody visitor visitor){
        return visitorService.addVisitor(visitor);

    }
    @GetMapping
    public List<visitor>getAllVisitor(){
        return visitorService.getAllVisitor();
    }

 @GetMapping("/inmate/{prisonerid}")
    public List<visitor> getByPrisonerid(@PathVariable String prisonerid){
        return visitorService.getVisitorByPrisoner(prisonerid);
 }
}
