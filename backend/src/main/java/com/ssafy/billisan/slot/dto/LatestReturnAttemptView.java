package com.ssafy.billisan.slot.dto;

import com.ssafy.billisan.returns.domain.ReturnAttempt;
import java.time.LocalDateTime;
import java.util.UUID;

public record LatestReturnAttemptView(
        UUID returnAttemptId,
        String status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static LatestReturnAttemptView of(ReturnAttempt returnAttempt) {
        return new LatestReturnAttemptView(
                returnAttempt.getReturnAttemptId(),
                returnAttempt.getStatus().name(),
                returnAttempt.getCreatedAt(),
                returnAttempt.getUpdatedAt());
    }
}
