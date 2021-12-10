package com.example.programovil_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/users")
public class MainController {
    @Autowired
    private UserRepository userRepo;

    @PostMapping()
    public @ResponseBody String Register(@RequestBody User user) {
        User exist = userRepo.findByEmail(user.getEmail());
        if(exist != null){
            return "Already exist an account with the given Email";
        }
        userRepo.save(user);
        return "Saved";
        
    }

    @GetMapping()
    public @ResponseBody Iterable<User> getUsers() {
        return userRepo.findAll();
    }
}
