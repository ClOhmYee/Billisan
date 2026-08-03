package com.ssafy.billisan.device.repository;

import com.ssafy.billisan.device.domain.DeviceOperation;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceOperationRepository extends JpaRepository<DeviceOperation, UUID> {
}
