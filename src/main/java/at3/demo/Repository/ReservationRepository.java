package at3.demo.Repository;

import at3.demo.Model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long>
{
    //Page<Reservation> findByPostId(Long userId, Pageable pageable);
}