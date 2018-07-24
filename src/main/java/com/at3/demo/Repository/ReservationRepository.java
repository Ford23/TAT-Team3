package com.at3.demo.Repository;

import com.at3.demo.Model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long>
{
    //Page<Reservation> findByPostId(Long userId, Pageable pageable);
}