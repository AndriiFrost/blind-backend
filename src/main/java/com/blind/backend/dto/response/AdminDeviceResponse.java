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
public class AdminDeviceResponse {

    private Long id;

    private String specialDeviceTopicSubName;

    private BlindDeviceOption blindDeviceOption;

    private String specialDeviceCode;

    private String specialDevicePasswordCode;
}
