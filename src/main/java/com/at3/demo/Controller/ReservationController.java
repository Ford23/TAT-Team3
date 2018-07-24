package com.at3.demo.Controller;

import com.at3.demo.Model.Reservation;
import com.at3.demo.Model.ReservationUser;
import com.at3.demo.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import sun.util.calendar.BaseCalendar;

import java.util.Collection;
import java.util.Date;

@RestController
@RequestMapping(value = "/reservations")
public class ReservationController {
    @Autowired
    public ReservationRepository reservations;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getAllReservation(ModelMap modelMap){
        modelMap.put("reservations",reservations.findAll());

        return "/reservation";
    }

    @RequestMapping(value = "/{reservation_id}", method = RequestMethod.GET)
    public String getReservationById(@PathVariable Long Id, ModelMap model) {
        model.put("reservationsId", reservations.findById(Id));

        return "reservation/id";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> createReservation(@RequestBody Reservation reservationn, UriComponentsBuilder ucBuilder) {

        Collection<Reservation> reservation = this.reservations.findAll();
        boolean exists = false;

        reservations.save(reservationn);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/reservations/{id}").buildAndExpand(reservationn.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
    @RequestMapping(value = "/addReservation", method = RequestMethod.POST)
    @ModelAttribute ("reservation")
    public String addReservation(@RequestParam (value = "id") Long hotelId){
        Reservation reservation = new Reservation();
        reservation.setId(hotelId);
        ReservationUser user= new ReservationUser("Korisnik","Korisnik", 15.1555, 40.2222);

        reservations.save(reservation);
        return "adminPanel";
    }

    @RequestMapping(value = "/delete/{reservation_id}", method = RequestMethod.DELETE)
    public String removeById(Long Id){
        reservations.deleteById(Id);
        return "reservation/delete/id";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public String updateHotel(Long Id, ModelMap model){
        model.put("reservation", reservations.findById(Id));
        return "reservation/edit/id";
    }

}