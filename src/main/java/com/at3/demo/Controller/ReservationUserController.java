package com.at3.demo.Controller;

import com.at3.demo.Model.Hotel;
import com.at3.demo.Model.ReservationUser;
import com.at3.demo.Repository.ReservationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class ReservationUserController {
    @Autowired
    ReservationUserRepository users;


}
