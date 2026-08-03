package com.ssafy.billisan.rental.repository;

import com.ssafy.billisan.rental.domain.Rental;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, UUID> {

    Optional<Rental> findByRentalRequestId(String rentalRequestId);
}
