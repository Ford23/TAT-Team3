package com.at3.demo.Repository;

import com.at3.demo.Model.ReservationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationUserRepository extends JpaRepository<ReservationUser, Long> {
}
