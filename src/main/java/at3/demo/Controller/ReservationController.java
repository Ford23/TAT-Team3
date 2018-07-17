package at3.demo.Controller;

import at3.demo.Model.Reservation;

import at3.demo.Repository.ReservationRepository;
import at3.demo.Repository.ReservationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
public class ReservationController {
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired

    private ReservationUserRepository reservationUserRepository;

    /*@GetMapping
    public Page<Reservation> getAllReservation(@PathVariable Long userId, Pageable pageable) {
        return reservationRepository.findByPostId(userId, pageable);
    }*/

    @RequestMapping
    public Optional<Reservation> getReservationById(Long Id) {
        try {
            return reservationRepository.findById(Id);

        } catch (Exception e) {
            System.out.println("Error!!!");
            return null;
        }
    }
}