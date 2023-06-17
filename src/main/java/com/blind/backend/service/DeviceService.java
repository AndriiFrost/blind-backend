package com.blind.backend.service;

import com.blind.backend.dto.request.DeviceAddToUserDto;
import com.blind.backend.dto.request.DeviceUpdateRequest;
import com.blind.backend.dto.response.DeviceResponse;
import java.util.List;

public interface DeviceService {

    boolean addDeviceToUser(DeviceAddToUserDto deviceAddToUserDto);

    List<DeviceResponse> getAllForCurrentUser();

    DeviceResponse getDevice(Long deviceId);

    DeviceResponse updateDevice(Long deviceId, DeviceUpdateRequest deviceUpdateRequest);
}
