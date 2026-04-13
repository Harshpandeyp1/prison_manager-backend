package com.prisonmanager.React.controller;

import com.prisonmanager.React.DTO.LogsDto;
import com.prisonmanager.React.Repo.InmateRepository;
import com.prisonmanager.React.Repo.UserRepository;
import com.prisonmanager.React.Repo.staffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/logs")
@CrossOrigin(origins = "*")
public class LogController {

    @Autowired
    private staffRepository staffRepository;

    @Autowired
    private InmateRepository inmateRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<LogsDto> getLogs(@RequestParam(required = false) String type) {

        List<LogsDto> logs = new ArrayList<>();

        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("hh:mm a");
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd MMM yyyy");

        boolean isAll = (type == null || type.equalsIgnoreCase("ALL"));

        if (isAll || type.equalsIgnoreCase("STAFF")) {
            staffRepository.findAll().forEach(s -> {
                LocalDateTime t = s.getCreatedAt();
                if (t == null) {
                    t = LocalDateTime.now(); // Fallback for old data
                }
                String uniqueId = "STAFF-" + s.getId();
                logs.add(new LogsDto(
                        uniqueId,
                        "STAFF",
                        "Staff added: " + s.getName(),
                        t.format(timeFormat),
                        t.format(dateFormat),
                        uniqueId
                ));
            });
        }

        if (isAll || type.equalsIgnoreCase("INMATE")) {
            inmateRepository.findAll().forEach(i -> {
                LocalDateTime t = i.getCreatedAt();
                if (t == null) {
                    t = LocalDateTime.now(); // Fallback for old data
                }
                String uniqueId = "INMATE-" + i.getId();
                logs.add(new LogsDto(
                        uniqueId,
                        "INMATE",
                        "New inmate added: " + i.getName(),
                        t.format(timeFormat),
                        t.format(dateFormat),
                        uniqueId
                ));
            });
        }

        if (isAll || type.equalsIgnoreCase("SYSTEM")) {
            userRepository.findAll().forEach(l -> {
                LocalDateTime t = l.getLoginTime();
                if (t == null) {
                    t = LocalDateTime.now(); // Fallback for old data
                }
                String uniqueId = "SYSTEM-" + l.getId();
                logs.add(new LogsDto(
                        uniqueId,
                        "SYSTEM",
                        "Login: " + l.getName(),
                        t.format(timeFormat),
                        t.format(dateFormat),
                        uniqueId
                ));
            });
        }

        // 🔥 SORT (latest first)
        logs.sort((a, b) -> {
            LocalDateTime t1 = LocalDateTime.parse(
                    a.getDate() + " " + a.getTime(),
                    DateTimeFormatter.ofPattern("dd MMM yyyy hh:mm a")
            );

            LocalDateTime t2 = LocalDateTime.parse(
                    b.getDate() + " " + b.getTime(),
                    DateTimeFormatter.ofPattern("dd MMM yyyy hh:mm a")
            );

            return t2.compareTo(t1);
        });

        return logs;
    }
}