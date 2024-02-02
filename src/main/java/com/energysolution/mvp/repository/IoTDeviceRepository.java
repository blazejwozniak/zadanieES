package com.energysolution.mvp.repository;

import com.energysolution.mvp.data.IoTDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IoTDeviceRepository extends JpaRepository<IoTDevice, Long> {

    Optional<IoTDevice> findByDeviceId(String deviceId);
}
