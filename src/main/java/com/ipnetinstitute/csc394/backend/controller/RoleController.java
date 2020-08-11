package com.ipnetinstitute.csc394.backend.controller;

import com.ipnetinstitute.csc394.backend.dao.RoleEntitityRepository;
import com.ipnetinstitute.csc394.backend.entity.Role;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class RoleController{
    private RoleEntitityRepository roleEntitityRepository;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Role> register(@RequestBody Role r) {
        if (r == null) {
            return new ResponseEntity<Role>(HttpStatus.BAD_REQUEST);
        }
        Role role = roleEntitityRepository.save(r);

        return new ResponseEntity<Role>(role, HttpStatus.OK);
    }
}
