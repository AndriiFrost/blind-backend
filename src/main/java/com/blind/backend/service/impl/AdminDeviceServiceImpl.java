package com.blind.backend.service.impl;

import com.blind.backend.converter.DeviceEntityConverterUtils;
import com.blind.backend.dto.request.AdminCreationDeviceRequest;
import com.blind.backend.dto.response.AdminDeviceResponse;
import com.blind.backend.entity.DeviceEntity;
import com.blind.backend.entity.enumeration.BlindDeviceOption;
import com.blind.backend.repository.DeviceRepository;
import com.blind.backend.service.AdminDeviceService;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminDeviceServiceImpl implements AdminDeviceService {

    private final DeviceRepository deviceRepository;

    @Override
    @Transactional
    public AdminDeviceResponse createDevice(AdminCreationDeviceRequest adminCreationDeviceRequest) {
        DeviceEntity deviceEntity = DeviceEntity.builder()
                .blindDeviceOption(BlindDeviceOption.CLOSE_BLIND)
                .specialDeviceCode(UUID.randomUUID().toString())
                .specialDevicePasswordCode(UUID.randomUUID().toString())
                .specialDeviceTopicSubName(adminCreationDeviceRequest.getSpecificDeviceTopicSubName())
                .build();
        DeviceEntity savedDevice = deviceRepository.save(deviceEntity);
        return DeviceEntityConverterUtils.convertDeviceToAdminResponse(savedDevice);
    }

    @Override
    public List<AdminDeviceResponse> getAllNotUserDevices() {
        List<DeviceEntity> allByDeviceUserEntityIsNull = deviceRepository.findAllByBlindUserEntityIsNull();
        return allByDeviceUserEntityIsNull.stream()
                .map(DeviceEntityConverterUtils::convertDeviceToAdminResponse)
                .collect(Collectors.toList());
    }
}
