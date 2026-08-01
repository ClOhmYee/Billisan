package com.ssafy.billisan.rental.repository;

import com.ssafy.billisan.rental.domain.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface RentalRepository extends JpaRepository<Rental, UUID> {
}
