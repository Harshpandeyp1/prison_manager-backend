package com.prisonmanager.React.service;

import com.prisonmanager.React.Entity.staff;
import com.prisonmanager.React.Repo.staffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class staffService {
    @Autowired
    private staffRepository staffRepository;

    public staff addstaff(staff staff){
        return staffRepository.save(staff);
    }
    public List<staff> getAllStaff() {
        return staffRepository.findAll();
    }
    public staff updateStatus(Long id, String status) {
        staff staff = staffRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Staff not found"));

        staff.setStatus(status);
        return staffRepository.save(staff);
    }
}
