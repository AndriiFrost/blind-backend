package com.blind.backend.controller;

import com.blind.backend.dto.request.AdminCreationDeviceRequest;
import com.blind.backend.dto.response.AdminDeviceResponse;
import com.blind.backend.service.AdminDeviceService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin/device")
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminDeviceController {

    private final AdminDeviceService adminDeviceService;

    @PostMapping
    public AdminDeviceResponse addNewDeviceToSystem(@RequestBody AdminCreationDeviceRequest request) {
        return adminDeviceService.createDevice(request);
    }

    @GetMapping
    public List<AdminDeviceResponse> getAllNotUserDevices() {
        return adminDeviceService.getAllNotUserDevices();
    }
}
