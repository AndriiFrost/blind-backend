package com.blind.backend.controller;

import com.blind.backend.service.DeviceService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/device")
@RequiredArgsConstructor
public class DeviceController {

    private final DeviceService deviceService;

    @PutMapping("/register")
    public void register(@RequestParam(name = "openBlind") String openBlind,
                         @RequestParam(name = "caseForBlind") String caseForBlind) {
        deviceService.updateDeviceSetting(openBlind, caseForBlind);
    }

    @GetMapping
    public List<String> get() {
        return List.of("Hello", "NICE");
    }
}
