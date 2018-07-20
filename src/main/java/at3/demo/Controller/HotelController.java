package at3.demo.Controller;

import at3.demo.Model.Hotel;
import at3.demo.Repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.Optional;


@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    HotelRepository hotels;

    //Returns all hotels in the database
    @RequestMapping(method = RequestMethod.GET, value = "/all", produces = MediaType.APPLICATION_JSON)
    @ResponseBody
    public ResponseEntity<Collection<Hotel>> findAll(){

        Collection<Hotel> users = this.hotels.findAll();

        if(users.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }


        return new ResponseEntity<Collection<Hotel>>(users, HttpStatus.OK);
    }

    //Return one specific hotel by its ID
    @RequestMapping(value = "/{id}/", method = RequestMethod.GET)
    public ResponseEntity getHotelById(@PathVariable Long Id){
        Optional<Hotel> hotel = this.hotels.findById(Id);
        if (!hotel.isPresent()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Optional<Hotel>>(hotel, HttpStatus.OK);
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

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void removeById(Pageable pageable, Hotel hotel){
            hotels.deleteById(hotel.getId());
            hotels.save(hotel);

    }

    @RequestMapping(value = "/addhotel", method = RequestMethod.POST)
    public void addHotel(@Valid @RequestBody Hotel hotel){
        Hotel novi = new Hotel();
        novi.setHotelName(hotel.getHotelName());
        novi.setHotelAdress(hotel.getHotelAdress());
        novi.setlongitude(hotel.getLongitude());
        novi.setLatitude(hotel.getLatitude());
        novi.setContactNumber(hotel.getContactNumber());
        novi.setRoomPrice(hotel.getRoomPrice());

        hotels.save(novi);
    }

    @RequestMapping(value = "/updatehotel", method = RequestMethod.PUT)
    public void updateHotel(@Valid @RequestBody Hotel hotel){
        HotelRepository existingHotel;
        Optional<Hotel>newHotel = this.hotels.findById(hotel.getId());
        hotels.save(hotel);
    }
}
