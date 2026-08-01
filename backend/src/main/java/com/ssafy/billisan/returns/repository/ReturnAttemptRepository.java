package com.ssafy.billisan.returns.repository;

import com.ssafy.billisan.returns.domain.ReturnAttempt;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface ReturnAttemptRepository extends JpaRepository<ReturnAttempt, UUID> {

    Optional<ReturnAttempt> findFirstByReturnSlotIdOrderByCreatedAtDesc(UUID returnSlotId);
}
