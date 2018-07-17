package at3.demo.Repository;

import at3.demo.Model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    //List<Hotel> findByTitleContainingOrContentContaining(String hotelName);

}
