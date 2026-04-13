package com.prisonmanager.React.controller;

import com.prisonmanager.React.DTO.PulseResponse;
import com.prisonmanager.React.service.PulseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pulse")
@CrossOrigin(origins = "http://localhost:5173")
public class PulseController {
    private static final Logger logger = LoggerFactory.getLogger(PulseController.class);

    @Autowired
    private PulseService pulseService;

    public PulseController() {
        logger.info("PulseController instantiated");
    }

    @GetMapping("/summary")
    public PulseResponse getPulseData(){
        logger.info("getPulseData called");
        return pulseService.getPulse();
    }
    }

