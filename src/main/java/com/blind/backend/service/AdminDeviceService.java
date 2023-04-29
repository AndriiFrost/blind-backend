package com.blind.backend.service;

import com.blind.backend.dto.request.AdminCreationDeviceRequest;
import com.blind.backend.dto.response.AdminDeviceResponse;
import java.util.List;

public interface AdminDeviceService {

    AdminDeviceResponse createDevice(AdminCreationDeviceRequest adminCreationDeviceRequest);

    List<AdminDeviceResponse> getAllNotUserDevices();

}
