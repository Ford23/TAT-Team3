package at3.demo.Controller;

import at3.demo.Model.Reservation;
import at3.demo.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/addreservation", method = RequestMethod.POST)
    @ModelAttribute ("reservation")
    public String addReservation(Reservation reservation, ModelMap modelMap){
        reservations.save(reservation);
        return "reservation/add";
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