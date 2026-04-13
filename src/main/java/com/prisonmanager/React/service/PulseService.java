package com.prisonmanager.React.service;

import com.prisonmanager.React.DTO.PulseResponse;
import com.prisonmanager.React.Entity.Inmate;
import com.prisonmanager.React.Entity.staff;
import com.prisonmanager.React.Entity.User; // Corrected import
import com.prisonmanager.React.Repo.InmateRepository;
import com.prisonmanager.React.Repo.UserRepository;
import com.prisonmanager.React.Repo.staffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PulseService {

    @Autowired
    private InmateRepository inmateRepo;
    @Autowired
    private staffRepository staffRepo;

    @Autowired
    private UserRepository logRepo;

    public PulseResponse getPulse() {

        // 1. Fetch data
        List<Inmate> inmates = inmateRepo.findAll();
        List<staff> staff = staffRepo.findAll();
        List<User> logs = logRepo.findTop10ByOrderByLoginTimeDesc(); // Corrected method call

        // 2. Calculate inmates
        long totalInmates = inmates.size();

        // 3. Active staff
        long activeStaff = staff.stream()
                .filter(s -> "ON_DUTY".equalsIgnoreCase(s.getStatus()))
                .count();

        // 4. Alerts (simple rule-based logic)
        long alerts = inmates.stream()
                .filter(i -> "CRITICAL".equalsIgnoreCase(i.getStatus()))
                .count();

        // 5. Occupancy (safe division)
        int capacity = 290; // you already used this in frontend
        double occupancyRate = (totalInmates * 100.0) / capacity;

        // 6. Logs mapping
        List<String> recentLogs = logs.stream()
                .map(User::getName) // Corrected mapping
                .collect(Collectors.toList());

        // 7. Return DTO
        return new PulseResponse(
                totalInmates,
                activeStaff,
                alerts,
                occupancyRate,
                recentLogs
        );
    }
}
