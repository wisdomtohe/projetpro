package com.ipnetinstitute.csc394.backend.controller;

import com.ipnetinstitute.csc394.backend.dao.CourseEntityRepository;
import com.ipnetinstitute.csc394.backend.dao.QuestionEntityRepository;
import com.ipnetinstitute.csc394.backend.entity.Course;
import com.ipnetinstitute.csc394.backend.entity.Question;
import com.ipnetinstitute.csc394.backend.entity.SurveyWP;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ipnetinstitute.csc394.backend.dao.SurveyEntityRepository;
import com.ipnetinstitute.csc394.backend.entity.Survey;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


@CrossOrigin
@RestController
@RequestMapping("/surveys")
public class SurveyController {
    
    @Autowired
    private SurveyEntityRepository surveyRepo;

    @Autowired
    private CourseEntityRepository courseEntityRepository;

    @Autowired
    QuestionEntityRepository questionEntityRepository;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Survey> registerTeacher(@RequestBody SurveyWP surveyWP) {
        Survey survey = surveyWP.getSurvey();
        List<Course> courses = surveyWP.getCourses();
        List<Course> tcourses = new ArrayList<Course>();
        List<Question> questions = surveyWP.getQuestions();
        List<Question> tquestions = new ArrayList<Question>();

        if (survey == null) {
            return new ResponseEntity<Survey>(HttpStatus.BAD_REQUEST);
        }
        if(survey.getId() != null && survey.getId()>0) {
            survey.setModDateTime(new Date());
        }
        else {
            survey.setCreateDateTime(new Date());
            survey.setModDateTime(new Date());
        }

        for(Course entry :courses) {
            tcourses.add(courseEntityRepository.findById(entry.getId()).get());
        }
        for(Question entry :questions) {
            tquestions.add(questionEntityRepository.findById(entry.getId()).get());
        }
        survey.setCourses(tcourses);
        survey.setQuestions(tquestions);

        survey = surveyRepo.save(survey);

        return new ResponseEntity<Survey>(survey, HttpStatus.OK);
    }
    
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
    @RequestMapping(value = "/pending/{userId}", method = RequestMethod.GET)
    public List<Survey> getPendingSurvey(@PathVariable("userId") Long userId) {

        List<Survey> result = new ArrayList<Survey>();
        try {
            result = (List<Survey>) surveyRepo.pendingSurvey(userId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }

    @RequestMapping(value = "/passed/{userId}", method = RequestMethod.GET)
    public List<Survey> getPassedSurvey(@PathVariable("userId") Long userId) {

        List<Survey> result = new ArrayList<Survey>();
        try {
            result = (List<Survey>) surveyRepo.passedSurvey(userId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }
    
    @GetMapping("/getSurveyByTeacher/{teacherId}")
    public List<Survey> getSurveyByTeacher(@PathVariable("teacherId") Long teacherId) {

        List<Survey> result = new ArrayList<Survey>();
        try {
            result = (List<Survey>) surveyRepo.pendingSurvey(teacherId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }
//    @GetMapping("/getSurveyByTeacher/{teacherId}")
//    public List<Survey> getPendingSrvey(@PathVariable("teacherId") Integer teacherId) {
//
//        List<Survey> result = new ArrayList<Survey>();
//        try {
//            result = (List<Survey>) surveyRepo.pendingSurvey(teacherId);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            return result;
//        }
//    }

}
