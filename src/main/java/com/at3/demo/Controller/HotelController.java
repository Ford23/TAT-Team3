package com.at3.demo.Controller;

import com.at3.demo.Model.Hotel;
import com.at3.demo.Model.Reservation;
import com.at3.demo.Model.ReservationUser;
import com.at3.demo.Repository.HotelRepository;
import com.at3.demo.Repository.ReservationRepository;
import com.at3.demo.Repository.ReservationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/hotels")
public class HotelController {
   @Autowired
   HotelRepository hotels;
   @Autowired
   ReservationUserRepository users;
   @Autowired
    ReservationRepository reservations;

    public HotelController (HotelRepository hotelRepository, ReservationUserRepository userRepository, ReservationRepository reservations){
        this.hotels = hotelRepository;
        this.users = userRepository;
        this.reservations = reservations;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public String findAll(Model model){
        List<Hotel> hotel =  this.hotels.findAll();

        model.addAttribute("hotelsList", hotel);
        model.addAttribute("reservation", new Reservation());

        return "userPanel";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/admin")
    public String findAllH(Map<String, Object> model1){
        List<Hotel> hotel =  this.hotels.findAll();
        List<ReservationUser> user =  this.users.findAll();
        model1.put("hotelsList", hotel);
        model1.put("userList", user);
        return "adminPanel";
    }


    @RequestMapping(value = "/updateHotel/{Id}", method = RequestMethod.POST)
    public String updateHotel(@PathVariable("Id") long Id, @ModelAttribute("hotel") Hotel hotel)
    {

        Hotel newHotel=hotels.findById(Id).get();

        if(newHotel!=null){

            newHotel.setHotelName(hotel.getHotelName());
            newHotel.setHotelAdress(hotel.getHotelAdress());
            newHotel.setContactNumber(hotel.getContactNumber());
            newHotel.setLatitude(hotel.getLatitude());
            newHotel.setlongitude(hotel.getLongitude());
            newHotel.setRoomPrice(hotel.getRoomPrice());

            hotels.save(newHotel);
        }

        return "redirect:/hotels/admin";
    }

    @RequestMapping(value = "/updateHotel/{Id}", method = RequestMethod.GET)
    public String updateHotel(@PathVariable("Id") long Id, Model model)
    {
        model.addAttribute("hotel",hotels.getOne(Id));

        return "editHotel";
    }

    @RequestMapping(value="/addHotel")
    public String addHotel(Model model){
        model.addAttribute("hotel",new Hotel());

        return "addHotel";
    }

    @RequestMapping(value="save", method = RequestMethod.POST)
    public String addNew(Hotel hotel){
        hotels.save(hotel);

        return "redirect:/hotels/admin";
    }


    @RequestMapping(value = "/updateUser/{Id}", method = RequestMethod.POST)
    public String updateUser(@PathVariable("Id") long Id, @ModelAttribute("user") ReservationUser user)
    {

        ReservationUser newUser=users.findById(Id).get();

        if(newUser!=null){

            newUser.setUserName(user.getUserName());
            newUser.setLatitude(user.getLatitude());
            newUser.setLongitude(user.getLongitude());


            users.save(newUser);

        }

        return "redirect:/hotels/admin";
    }

    @RequestMapping(value = "/updateUser/{Id}", method = RequestMethod.GET)
    public String updateUser(@PathVariable("Id") Long Id, Model model)
    {
        model.addAttribute("user",users.getOne(Id));

        return "editUsers";
    }

    @RequestMapping(value="/addNewUser")
    public String addUser(Model model){
        model.addAttribute("user",new ReservationUser());

        return "addUser";
    }

    @RequestMapping(value="savereservation", method = RequestMethod.POST)
    public String addNewReservation(@RequestParam(value="Id") Long Id)

    {
        Reservation newReservation= new Reservation();
        Hotel newHotel = new Hotel();
        newHotel = hotels.getOne(Id);
        ReservationUser newUser = new ReservationUser();
        newUser = users.getOne((long)2);
        newReservation.setUser(newUser);
        newReservation.setHotel(newHotel);
        reservations.save(newReservation);

        return "redirect:/userPanel";
    }

    @RequestMapping(value="saveuser", method = RequestMethod.POST)
    public String addNewUser(ReservationUser user){
        users.save(user);

        return "redirect:/hotels/admin";
    }
    @RequestMapping(value = "/deleteUser/{Id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("Id") Long Id) {

        users.deleteById(Id);

        return "redirect:/hotels/admin";
    }
    @RequestMapping(value = "/deleteHotel/{Id}", method = RequestMethod.GET)
    public String deleteHotel(@PathVariable("Id") Long Id)  {

        hotels.deleteById(Id);

        return "redirect:/hotels/admin";
    }
    @RequestMapping(value = "/supervisor", method = RequestMethod.GET)
    public String getMap()  {



        return "supervizor";
    }
    @RequestMapping(value = "/default", method = RequestMethod.GET)
    public String redirectToPanel(Model model, Authentication authentication) {
        if (authentication.getAuthorities().toString().contains("ROLE_ADMIN")) {
            System.out.println("==== ADMIN");
            return "redirect:/hotels/admin";
        }
        else if (authentication.getAuthorities().toString().contains("ROLE_USER")) {
            System.out.println("==== USER");
            return "redirect:/hotels/all";
        } else if (authentication.getAuthorities().toString().contains("ROLE_SUPERVISOR")) {
            System.out.println("==== SUPERVISOR");
            return "redirect:/supervisor";
        }

        System.out.println("==== ROLE FAILED");
        return "/login";
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginView() {

        return "auth/login";
    }
}
