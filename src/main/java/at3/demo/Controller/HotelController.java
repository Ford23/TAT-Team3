package at3.demo.Controller;

import at3.demo.Model.Hotel;
import at3.demo.Repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/hotels")
public class HotelController {
   @Autowired
   HotelRepository hotels;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getAllHotels(ModelMap modelMap){
        modelMap.put("hotels",hotels.findAll());

        return "/hotel";
    }

    @RequestMapping(value = "/{hotel_id}", method = RequestMethod.GET)
    public String getHotelById(@PathVariable Long Id, ModelMap model) {
        model.put("hotelId", hotels.findById(Id));

        return "hotel/id";
    }

    @RequestMapping(value = "/addhotel", method = RequestMethod.POST)
    @ModelAttribute ("hotel")
    public String addHotel(Hotel hotel, ModelMap modelMap){
        hotels.save(hotel);
        return "hotel/add";
    }

    @RequestMapping(value = "/delete/{hotel_id}", method = RequestMethod.DELETE)
    public String removeById(Long Id){
        hotels.deleteById(Id);
        return "hotel/delete/id";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public String updateHotel(Long Id, ModelMap model){
        model.put("hotel", hotels.findById(Id));
        return "hotel/edit/id";
    }

}
