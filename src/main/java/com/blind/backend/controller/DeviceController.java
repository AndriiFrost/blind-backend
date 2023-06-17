package com.blind.backend.controller;

import com.blind.backend.dto.request.DeviceAddToUserDto;
import com.blind.backend.dto.request.DeviceUpdateRequest;
import com.blind.backend.dto.response.DeviceResponse;
import com.blind.backend.service.DeviceService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/device")
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('USER')")
public class DeviceController {

    private final DeviceService deviceService;

    @PostMapping
    public boolean addDeviceToUser(@RequestBody DeviceAddToUserDto deviceAddToUserDto) {
        return deviceService.addDeviceToUser(deviceAddToUserDto);
    }

    @GetMapping
    public List<DeviceResponse> getAllDevices() {
        return deviceService.getAllForCurrentUser();
    }

    @GetMapping(path = "/{deviceId}")
    public DeviceResponse getDevice(@PathVariable(value = "deviceId") Long deviceId) {
        return deviceService.getDevice(deviceId);
    }

    @PostMapping(path = "/{deviceId}")
    public DeviceResponse updateDevice(@PathVariable(value = "deviceId") Long deviceId,
                                       @RequestBody DeviceUpdateRequest deviceUpdateRequest) {
        return deviceService.updateDevice(deviceId, deviceUpdateRequest);
    }
}
