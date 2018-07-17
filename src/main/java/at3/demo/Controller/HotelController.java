package at3.demo.Controller;

import at3.demo.Model.Hotel;
import at3.demo.Repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
public class HotelController{
    @Autowired
    HotelRepository hotels;

    //Returns all hotels in the database
    @GetMapping("/view")
    public Page<Hotel> getAllHotels(Pageable pageable){
        return hotels.findAll(pageable);
    }

    //Return one specific hotel by its ID
    @GetMapping
    public Optional<Hotel> getHotelById(Pageable pageable, Long Id){
        try{
            return hotels.findById(Id);
        }catch (Exception e){
            System.out.println("Error 200!");
            return null;
        }
    }

    //Return one specific hotel by its name --> made for search in app on frontend
    /* @GetMapping
    public List<Hotel> getHotelByString(Pageable pageable, String hotelName) {
        try {
            return hotels.findByTitleContainingOrContentContaining(hotelName);
        } catch (Exception e) {
            System.out.println("Error 200!");
            return null;
        }
    }
    */

    @DeleteMapping
    public void removeById(Pageable pageable, Long Id){
        try{
            hotels.deleteById(Id);
        }catch(Exception e){
            System.out.println("Error 200!Couldn't find that Id!");
        }
    }

    @PostMapping
    public void addHotel(@Valid @RequestBody Hotel hotel){
        hotels.save(hotel);
    }


}
