package com.prisonmanager.React.controller;

import com.prisonmanager.React.Entity.staff;
import com.prisonmanager.React.service.staffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
@CrossOrigin(origins ="http://localhost:5173")
public class staffController {
    @Autowired
    private staffService staffService;

    @PostMapping
    public staff addstaff(@RequestBody staff  staff){
        return staffService.addstaff(staff);
    }
    @GetMapping
    public List<staff> getAllstaff(){
        return staffService.getAllStaff();
    }
    @PutMapping("/{id}")
    public staff updateStatus(@PathVariable Long id, @RequestParam String status) {
        return staffService.updateStatus(id, status);
    }

}
