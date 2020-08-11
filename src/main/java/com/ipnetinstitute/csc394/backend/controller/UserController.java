package com.ipnetinstitute.csc394.backend.controller;

import com.ipnetinstitute.csc394.backend.dao.RoleEntitityRepository;
import com.ipnetinstitute.csc394.backend.dao.UserEntityRepository;
import com.ipnetinstitute.csc394.backend.entity.Role;
import com.ipnetinstitute.csc394.backend.entity.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/users")
public class UserController {
    private UserEntityRepository userRepository;
    private RoleEntitityRepository roleEntitityRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UserEntityRepository u,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = u;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/sign-up")
    public void signUp(@RequestBody User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<User> register(@RequestBody User user) {
        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }
        if (userRepository.findByEmail(user.getEmail()) != null) {
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }
        if(user.getId() != null && user.getId()>0) {
            user.setModDateTime(new Date());
        }
        else {
            user.setCreateDateTime(new Date());
            user.setModDateTime(new Date());
        }
        Set<Role> roles = new HashSet<Role>();
        for(Role entry :user.getRole()) {
            System.out.println("///////////////*************////////////////");
            System.out.println(entry.getName());
            System.out.println("///////////////*************////////////////");
            roles.add(roleEntitityRepository.getById(entry.getId()).get());
            roles.add(roleEntitityRepository.findById(entry.getId()).get());
        }
//        roles.add(roleEntitityRepository.findById(user.getRole()[0]))
        user.setRole( roles );


        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        user = userRepository.save(user);

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}

