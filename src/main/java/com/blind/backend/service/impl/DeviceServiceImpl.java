package com.blind.backend.service.impl;

import com.blind.backend.converter.DeviceEntityConverterUtils;
import com.blind.backend.dto.request.DeviceAddToUserDto;
import com.blind.backend.dto.request.DeviceUpdateRequest;
import com.blind.backend.dto.response.DeviceResponse;
import com.blind.backend.entity.BlindUserEntity;
import com.blind.backend.entity.DeviceEntity;
import com.blind.backend.repository.DeviceRepository;
import com.blind.backend.service.BlindUserService;
import com.blind.backend.service.DeviceService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class DeviceServiceImpl implements DeviceService {

    @Value("${aws.api.gateway.endpoint.change.blind}")
    private String awsApiGatewayEndpointChangeBlind;

    private final RestTemplate restTemplate;

    private final DeviceRepository deviceRepository;

    private final BlindUserService blindUserService;

    @Override
    @Transactional
    public boolean addDeviceToUser(DeviceAddToUserDto deviceAddToUserDto) {
        BlindUserEntity currentUser = blindUserService.findCurrentUser();
        Optional<DeviceEntity> deviceEntityOptional = deviceRepository.findBySpecialDeviceCodeAndSpecialDevicePasswordCode(deviceAddToUserDto.getDeviceCode(),
                deviceAddToUserDto.getDeviceCodePassword());
        if (deviceEntityOptional.isEmpty()) {
            return false;
        }
        DeviceEntity deviceEntity = deviceEntityOptional.get();
        deviceEntity.setBlindUserEntity(currentUser);
        deviceRepository.saveAndFlush(deviceEntity);
        return true;
    }

    @Override
    public List<DeviceResponse> getAllForCurrentUser() {
        BlindUserEntity currentUser = blindUserService.findCurrentUser();
        List<DeviceEntity> deviceEntities = deviceRepository.findAllByBlindUserEntity(currentUser);
        return deviceEntities.stream()
                .map(DeviceEntityConverterUtils::convertDeviceToDeviceResponse)
                .collect(Collectors.toList());
    }

    @Override
    public DeviceResponse getDevice(Long deviceId) {
        DeviceEntity deviceEntity = findDeviceForCurrentUserByDeviceId(deviceId);
        return DeviceEntityConverterUtils.convertDeviceToDeviceResponse(deviceEntity);
    }

    @Override
    public DeviceResponse updateDevice(Long deviceId, DeviceUpdateRequest deviceUpdateRequest) {
        DeviceEntity deviceEntity = findDeviceForCurrentUserByDeviceId(deviceId);
        DeviceEntity deviceToUpdate = DeviceEntityConverterUtils.updateDevice(deviceEntity, deviceUpdateRequest);
        DeviceEntity updatedDevice = deviceRepository.saveAndFlush(deviceToUpdate);
        updateDeviceSetting(updatedDevice);
        return DeviceEntityConverterUtils.convertDeviceToDeviceResponse(updatedDevice);
    }

    private DeviceEntity findDeviceForCurrentUserByDeviceId(Long deviceId) {
        BlindUserEntity currentUser = blindUserService.findCurrentUser();
        return deviceRepository.findByBlindUserEntityAndDeviceId(currentUser, deviceId)
                .orElseThrow(EntityNotFoundException::new);
    }

    private void updateDeviceSetting(DeviceEntity deviceEntity) {
        String response = restTemplate.getForObject(awsApiGatewayEndpointChangeBlind
                        + "?temperatureForSensor={temperatureForSensor}"
                        + "&caseForBlind={caseForBlind}"
                        + "&subTopic={subTopic}",
                String.class,
                deviceEntity.getTemperatureForSensor(),
                deviceEntity.getBlindDeviceOption().getCaseForBlind(),
                deviceEntity.getSpecialDeviceTopicSubName());
        log.info(String.format("Response for change blind: '%s'", response));
    }
}
