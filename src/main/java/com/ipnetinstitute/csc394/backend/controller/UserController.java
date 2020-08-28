package com.ipnetinstitute.csc394.backend.controller;

import com.ipnetinstitute.csc394.backend.dao.RoleEntitityRepository;
import com.ipnetinstitute.csc394.backend.dao.TeacherEntityRepository;
import com.ipnetinstitute.csc394.backend.dao.UserEntityRepository;
import com.ipnetinstitute.csc394.backend.entity.Role;
import com.ipnetinstitute.csc394.backend.entity.Teacher;
import com.ipnetinstitute.csc394.backend.entity.User;

import com.ipnetinstitute.csc394.backend.entity.UserRoleWP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserEntityRepository userRepository;
    @Autowired
    private TeacherEntityRepository teacherRepository;
    @Autowired
    private RoleEntitityRepository roleEntitityRepository;
    @Autowired
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

    @RequestMapping(value = "/getByEmail/{mail}", method = RequestMethod.GET)
    public ResponseEntity<User> userByMail(@PathVariable("mail") String email){
        return  new ResponseEntity<User>(userRepository.findByEmail(email), HttpStatus.OK);
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<User> register(@RequestBody UserRoleWP userRoleWP) {
        User user = userRoleWP.getUser();
        Set<Role> roles = userRoleWP.getRoles();
        Set<Role> uroles = new HashSet<Role>();
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
        for(Role entry :roles) {
            System.out.println("///////////////*************////////////////");
            System.out.println(entry.getName());
            System.out.println(roleEntitityRepository.getById(entry.getId()).get());
            System.out.println(roleEntitityRepository.findById(entry.getId()).get());
            System.out.println("///////////////*************////////////////");
            uroles.add(roleEntitityRepository.getById(entry.getId()).get());
            uroles.add(roleEntitityRepository.findById(entry.getId()).get());
        }
//        roles.add(roleEntitityRepository.findById(user.getRole()[0]))
        user.setRoles(uroles );


        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        user = userRepository.save(user);

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
    @RequestMapping(value = "/save/teacher", method = RequestMethod.POST)
    public ResponseEntity<Teacher> registerTeacher(@RequestBody Teacher teacher) {
        if (teacher == null) {
            return new ResponseEntity<Teacher>(HttpStatus.BAD_REQUEST);
        }
        if(teacher.getId() != null && teacher.getId()>0) {
            teacher.setModDateTime(new Date());
        }
        else {
            teacher.setCreateDateTime(new Date());
            teacher.setModDateTime(new Date());
        }
        System.out.println("///////////////*************////////////////");
        User user = userRepository.findById(teacher.getUser().getId()).get();
        teacher.setUser(user);

        System.out.println(teacher);

        teacher = teacherRepository.save(teacher);

        return new ResponseEntity<Teacher>(teacher, HttpStatus.OK);
    }
}

