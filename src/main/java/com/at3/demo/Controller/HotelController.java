package com.at3.demo.Controller;

import com.at3.demo.Model.Hotel;
import com.at3.demo.Model.ReservationUser;
import com.at3.demo.Repository.HotelRepository;
import com.at3.demo.Repository.ReservationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/hotels")
public class HotelController {
   @Autowired
   HotelRepository hotels;
   @Autowired
   ReservationUserRepository users;

    
    public HotelController (HotelRepository hotelRepository, ReservationUserRepository userRepository){
        this.hotels = hotelRepository;
        this.users = userRepository;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public String findAll(Model model){
        List<Hotel> hotel =  this.hotels.findAll();

        model.addAttribute("hotelsList", hotel);

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


    @RequestMapping(value = "/{hotel_id}", method = RequestMethod.GET)
    public String getHotelById(@PathVariable Long Id, ModelMap model) {
        model.put("hotelId", hotels.findById(Id));

        return "hotel/id";
    }

    @RequestMapping(value = "/addHotel", method = RequestMethod.POST)
    @ModelAttribute ("hotel")
    public String addHotel(Hotel hotel, ModelMap modelMap){
        hotels.save(hotel);
        return "adminPanel";
    }
    @RequestMapping(path = "/addHotelNew", method = RequestMethod.POST)
    public String addNewHotel(Model model, Hotel hotel) {
        model.addAttribute("hotelDetail", new Hotel());
        hotels.save(new Hotel(hotel.getHotelName(), hotel.getLongitude(), hotel.getLatitude()));
        model.addAttribute("hotelsList",hotels.findAll());
        return "userPanel";
    }
    @RequestMapping(path = "/addHotel", method = RequestMethod.GET)
    public String createProduct(Model model) {
        model.addAttribute("addHotel", new Hotel());
        return "userPanel";
    }

    @RequestMapping(value = "/delete/{hotel_id}", method = RequestMethod.DELETE)
    public String removeById(Long Id){
        hotels.deleteById(Id);
        return "adminPanel";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public String updateHotel(Long Id, ModelMap model){
        model.put("hotel", hotels.findById(Id));
        return "adminPanel";
    }

}
