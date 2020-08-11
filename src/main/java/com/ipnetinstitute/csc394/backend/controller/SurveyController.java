package com.ipnetinstitute.csc394.backend.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ipnetinstitute.csc394.backend.dao.SurveyEntityRepository;
import com.ipnetinstitute.csc394.backend.entity.Survey;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@CrossOrigin
@RestController
public class SurveyController {
    
    @Autowired
    private SurveyEntityRepository surveyRepo;
    
    @GetMapping("/getAllSurveyByStudent/{id}")
    public List<Survey> getAllSurveyByStudent(@PathVariable("id") Integer id) {

		List<Survey> result = new ArrayList<Survey>();
        try {
        	result=  surveyRepo.findAllSurveyRespondbyUser(id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }

    @GetMapping("/getValidSurvey")
    public List<Survey> getValidSurvey() {

        List<Survey> result = new ArrayList<Survey>();
        try {
            result = (List<Survey>) surveyRepo.findAllSurveyStillValid();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }



     @GetMapping("/getSurveybyCategoryAndCourse/{CategoryID}/{CourseID}")
    public List<Survey> getSurveybyCategoryAndCourse(@PathVariable("CategoryID") Integer CategoryID, @PathVariable("CourseID") Integer CourseID) {

        List<Survey> result = new ArrayList<Survey>();
        try {
            result = (List<Survey>) surveyRepo.findbyCategoryAndCourse(CategoryID, CourseID);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }

//    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/getPendingSurvey/{userId}")
    public List<Survey> getPendingSurvey(@PathVariable("userId") Integer userId) {

        List<Survey> result = new ArrayList<Survey>();
        try {
            result = (List<Survey>) surveyRepo.pendingSurvey(userId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }
    
    @GetMapping("/getSurveyByTeacher/{teacherId}")
    public List<Survey> getSurveyByTeacher(@PathVariable("teacherId") Integer teacherId) {

        List<Survey> result = new ArrayList<Survey>();
        try {
            result = (List<Survey>) surveyRepo.pendingSurvey(teacherId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }
    @GetMapping("/getSurveyByTeacher/{teacherId}")
    public List<Survey> getPendingSrvey(@PathVariable("teacherId") Integer teacherId) {

        List<Survey> result = new ArrayList<Survey>();
        try {
            result = (List<Survey>) surveyRepo.pendingSurvey(teacherId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }

}
