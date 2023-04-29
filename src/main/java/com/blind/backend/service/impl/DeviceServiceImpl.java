package com.blind.backend.service.impl;

import com.blind.backend.service.DeviceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeviceServiceImpl implements DeviceService {

    @Value("${aws.api.gateway.endpoint.change.blind}")
    private String awsApiGatewayEndpointChangeBlind;
    private final RestTemplate restTemplate;

    @Override
    public void updateDeviceSetting(String openBlind, String caseForBlind) {
        log.info(openBlind);
        log.info(caseForBlind);
        String response = restTemplate.getForObject(awsApiGatewayEndpointChangeBlind
                        + "?openBlind={openBlind}&caseForBlind={caseForBlind}",
                String.class,
                openBlind,
                caseForBlind);
        log.info(String.format("Response for change blind: '%s'", response));
    }

    @Override
    public boolean deviceByCodeExist(String deviceCode) {
        return true;
    }
}
