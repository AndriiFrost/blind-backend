package com.blind.backend.controller;

import com.blind.backend.service.DeviceService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/device")
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('USER')")
public class DeviceController {

    private final DeviceService deviceService;

    @PutMapping("/register")
    public void register(@RequestParam(name = "openBlind") String openBlind,
                         @RequestParam(name = "caseForBlind") String caseForBlind) {
        deviceService.updateDeviceSetting(openBlind, caseForBlind);
    }

    @PostMapping
    public boolean addNewDeviceToSystem(@RequestParam("deviceCode") String deviceCode) {
        return deviceService.deviceByCodeExist(deviceCode);
    }

    @GetMapping
    public List<String> getAllDevices() {
        return List.of("Hello", "NICE");
    }
}
