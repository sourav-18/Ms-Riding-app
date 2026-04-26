package com.ms.rider_service.repositories;

import com.ms.rider_service.entities.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RiderRepository extends JpaRepository<Rider,Long> {
    boolean existsByMobileNo(String mobileNo);
    Optional<Rider> findByMobileNo(String mobileNo);

    @Modifying
    @Query("UPDATE Rider SET latitude=:latitude, longitude=:longitude WHERE id=:id")
    int locationUpdateById(@Param("id") Long id,
                         @Param("latitude") Double latitude,
                         @Param("longitude") Double longitude);
}
