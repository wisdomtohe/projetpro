package com.ipnetinstitute.csc394.backend.controller;

import com.ipnetinstitute.csc394.backend.dao.RoleEntitityRepository;
import com.ipnetinstitute.csc394.backend.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController{
    @Autowired
    private RoleEntitityRepository roleEntitityRepository;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Role> register(@RequestBody Role r) {
        if (r == null) {
            return new ResponseEntity<Role>(HttpStatus.BAD_REQUEST);
        }
        Role role = roleEntitityRepository.save(r);

        return new ResponseEntity<Role>(role, HttpStatus.OK);
    }
    @GetMapping("/all")
    public List<Role> allRoles(){

        List<Role> result = new ArrayList<Role>();
        try {
            result = roleEntitityRepository.findAll();
        } catch (Exception e) {
            System.out.println("erreur");
            e.printStackTrace();
        } finally {
            return result;
        }
    }
}
