package com.ipnetinstitute.csc394.backend.controller;

import com.ipnetinstitute.csc394.backend.dao.JpopeAnswersEntitityRepository;
import com.ipnetinstitute.csc394.backend.entity.JpopeAnswers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/jpope")
public class JpopeAnswersController {
    @Autowired
    private JpopeAnswersEntitityRepository jpopeAnswersEntitityRepository;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<JpopeAnswers> register(@RequestBody JpopeAnswers r) {
        if (r == null) {
            return new ResponseEntity<JpopeAnswers>(HttpStatus.BAD_REQUEST);
        }
        JpopeAnswers answer = jpopeAnswersEntitityRepository.save(r);

        return new ResponseEntity<JpopeAnswers>(answer, HttpStatus.OK);
    }
    @GetMapping("/all")
    public List<JpopeAnswers> allJpopeAnswers(){

        List<JpopeAnswers> result = new ArrayList<JpopeAnswers>();
        try {
            result = jpopeAnswersEntitityRepository.findAll();
        } catch (Exception e) {
            System.out.println("erreur");
            e.printStackTrace();
        } finally {
            return result;
        }
    }
    @GetMapping("/totalCS")
    public int totalCS() {

        return jpopeAnswersEntitityRepository.totalCS();
    }@GetMapping("/totalDH")
    public int totalDH() {

        return jpopeAnswersEntitityRepository.totalDH();
    }@GetMapping("/totalMK")
    public int totalMK() {

        return jpopeAnswersEntitityRepository.totalMK();
    }@GetMapping("/totalAH")
    public int totalAH() {

        return jpopeAnswersEntitityRepository.totalAH();
    }@GetMapping("/totalCI")
    public int totalCI() {

        return jpopeAnswersEntitityRepository.totalCI();
    }@GetMapping("/totalDI")
    public int totalDI() {

        return jpopeAnswersEntitityRepository.totalDI();
    }@GetMapping("/totalNS")
    public int totalNS() {

        return jpopeAnswersEntitityRepository.totalNS();
    }@GetMapping("/totalPiigo")
    public int totalPiigo() {

        return jpopeAnswersEntitityRepository.totalPiigo();
    }@GetMapping("/totalSiem")
    public int totalSiem() {

        return jpopeAnswersEntitityRepository.totalSiem();
    }
    @GetMapping("/totalTI")
    public int totalTI() {

        return jpopeAnswersEntitityRepository.totalTI();
    }

}
