package com.energysolution.mvp.repository;

import com.energysolution.mvp.data.DeviceConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeviceConfigurationRepository extends JpaRepository<DeviceConfiguration, Long> {

    Optional<DeviceConfiguration> findByDeviceId(String deviceId);
}
