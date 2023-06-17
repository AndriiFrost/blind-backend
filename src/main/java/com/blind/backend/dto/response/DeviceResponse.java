package com.blind.backend.dto.response;

import com.blind.backend.entity.enumeration.BlindDeviceOption;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeviceResponse {

    private Long id;

    private BlindDeviceOption blindDeviceOption;

    private String deviceName;

    private String deviceDescription;

    private Long temperatureForSensor;

}
