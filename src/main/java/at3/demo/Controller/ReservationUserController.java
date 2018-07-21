package at3.demo.Controller;

import at3.demo.Model.ReservationUser;
import at3.demo.Repository.ReservationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "users")
public class ReservationUserController {
    @Autowired
    ReservationUserRepository users;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getAllUsers(ModelMap modelMap){
        modelMap.put("users",users.findAll());
        return "/user";
    }

    @RequestMapping(value = "/{user_id}", method = RequestMethod.GET)
    public String getUserById(@PathVariable Long Id, ModelMap model) {
        model.put("userId", users.findById(Id));

        return "/user/id";
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    @ModelAttribute ("user")
    public String addReservation(ReservationUser user, ModelMap modelMap){
        users.save(user);
        return "/user/add";
    }

    @RequestMapping(value = "/delete/{user_id}", method = RequestMethod.DELETE)
    public String removeById(Long Id){
        users.deleteById(Id);
        return "/user/delete/id";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public String updateHotel(Long Id, ModelMap model){
        model.put("user", users.findById(Id));
        return "user/edit/id";
    }
}
