package at3.demo.Repository;

import at3.demo.Model.ReservationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationUserRepository extends JpaRepository<ReservationUser, Long> {
}
