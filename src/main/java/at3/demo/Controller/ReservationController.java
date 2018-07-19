package at3.demo.Controller;

import at3.demo.Model.Hotel;
import at3.demo.Model.Reservation;
import at3.demo.Repository.HotelRepository;
import at3.demo.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(value = "/reservations")
public class ReservationController {
    @Autowired
    public ReservationRepository reservations;

    /*@GetMapping
    public Page<Reservation> getAllReservation(@PathVariable Long userId, Pageable pageable) {
        return reservationRepository.findByPostId(userId, pageable);
    }*/

    @RequestMapping(value = "/{reservation_id}", method = RequestMethod.GET)
    public Optional<Reservation> getReservationById(Long Id) {
        try {
            return reservations.findById(Id);

        } catch (Exception e) {
            System.out.println("Error!!!");
            return null;
        }
    }

    @RequestMapping(value = "/getreservation", method = RequestMethod.GET)
    public Page<Reservation> getAllReservation(Pageable pageable){
        try {
            return reservations.findAll(pageable);

        } catch (Exception e) {
            System.out.println("Error!!!");
            return null;
        }
    }

    @RequestMapping(value = "/deletereservation", method = RequestMethod.DELETE)
    public void removeById(Pageable pageable, Reservation hotel){
        try{
            reservations.deleteById(hotel.getId());
            reservations.save(hotel);
        }catch(Exception e){
            System.out.println("Error 200!Couldn't find that Id!");
        }
    }

    @RequestMapping(value = "/updatereservation", method = RequestMethod.PUT)
    public void updateHotel(@Valid @RequestBody Reservation reservation){
        HotelRepository existingHotel;
        Optional<Reservation>newReservation = this.reservations.findById(reservation.getId());
        reservations.save(reservation);
    }

    @RequestMapping(value = "/addreservation", method = RequestMethod.POST)
    public void addHotel(@Valid @RequestBody Reservation reservation){
        reservations.save(reservation);
    }
}