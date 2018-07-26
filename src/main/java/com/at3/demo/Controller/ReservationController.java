package com.at3.demo.Controller;

import com.at3.demo.Model.Hotel;
import com.at3.demo.Model.Reservation;
import com.at3.demo.Model.ReservationUser;
import com.at3.demo.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import sun.util.calendar.BaseCalendar;

import java.security.Principal;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/reservations")
public class ReservationController {
    @Autowired
    public ReservationRepository reservations;

    @RequestMapping(value = "/reservation/{userId}", method = RequestMethod.GET)
    public String getAllReservation(Model model,Principal principal){

        ReservationUser user = new ReservationUser(principal.getName(),0.0,0.0);
        List<Reservation> reservation= this.reservations.findAll();

        model.addAttribute("reservationList",reservation);
        model.addAttribute("user",user);

        return "userPanel";
    }

    @RequestMapping(value = "/reservation", method = RequestMethod.GET)
    public String getReservationById(Model model) {

        List<Reservation> reservation = this.reservations.findAll();
        model.addAttribute("reservations",reservation);

        return "supervizor";
    }
    /*@RequestMapping(value = "/reservationHotel", method = RequestMethod.POST)
    public String reservationHotel(@RequestParam(value = "Id") Long Id,
                             @RequestParam(value = "reservedFrom") Date reservedFrom,
                             @RequestParam(value = "reservedTo") Date reservedTo, @RequestParam(value = "IdHotel") Hotel IdHotel )
    {

        ReservationUser user= new ReservationUser(2);
        Reservation reservation=new Reservation(Id,reservedFrom,reservedTo,IdHotel,user);

        return "redirect:/admin";
    }*/

}
