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

import javax.validation.Valid;
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
    @RequestMapping(value = "/updateUser/{Id}", method = RequestMethod.GET)
    public String updateUser(@PathVariable("Id") long Id, Model model)
    {
        model.addAttribute("user",users.getOne(Id));

        return "editUsers";
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
    @RequestMapping(value = "/updateHotel/{Id}", method = RequestMethod.GET)
    public String updateHotel(@PathVariable("Id") long Id, Model model)
    {
        model.addAttribute("hotel",hotels.getOne(Id));

        return "editHotel";
    }
    @RequestMapping(value = "/deleteUser/{Id}", method = RequestMethod.POST)
    public String deleteUser(@RequestParam(value = "Id") Long Id) {
        ReservationUser newUser=users.findById(Id).get();
        users.delete(newUser);

        return "redirect:/hotels/admin";
    }
}
