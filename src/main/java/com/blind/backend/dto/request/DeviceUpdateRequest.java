package com.blind.backend.dto.request;

import com.blind.backend.entity.enumeration.BlindDeviceOption;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeviceUpdateRequest {

    private BlindDeviceOption blindDeviceOption;

    private String deviceName;

    private String deviceDescription;

    private Long temperatureForSensor;

}
