package com.blind.backend.entity;

import com.blind.backend.entity.enumeration.BlindDeviceOption;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "devices", schema = "public")
public class DeviceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "device_id")
    private Long deviceId;

    private String deviceName;

    private String specialDeviceTopicSubName;

    @Enumerated(value = EnumType.STRING)
    private BlindDeviceOption blindDeviceOption;

    private String specialDeviceCode;

    private String specialDevicePasswordCode;

    @ManyToOne
    @JoinColumn(name = "blind_user_id")
    private BlindUserEntity blindUserEntity;

}
