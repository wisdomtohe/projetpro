package com.ipnetinstitute.csc394.backend.controller;

import java.util.ArrayList;
import java.util.List;

import com.ipnetinstitute.csc394.backend.dao.QuestionEntityRepository;


import com.ipnetinstitute.csc394.backend.dao.SurveyEntityRepository;
import com.ipnetinstitute.csc394.backend.entity.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
 @RequestMapping(value="/questions")
public class QuestionController  {
	
    @Autowired
    private QuestionEntityRepository questionRepo;

    @Autowired
    private SurveyEntityRepository surveyEntityRepository;

    // @Autowired
    // private CategorieSurveyQuestionEntityRepository cat_survey_questionRepo;
    // @Autowired
    // private CategorySurveyEntityRepository cat_surveyRepo;


    // @Autowired
    // QuestionService queryservice;

    // @GetMapping("/questiontest")
    // public List<Question> getQuery()
    // {
    //     // return (List) questionRepo.listdesquestionparcategorie();
    // }



    @GetMapping("/getQuestionByCategory/{id}")
    public List getQuestionByCategory(@PathVariable("id") Integer id){

        List result = new ArrayList();
        try {
            result = (List)questionRepo.findAllQuestionbyCategory(id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }
   
    @GetMapping("/getPendingSurveyQuestions/{surveyId}/{userId}")
    public List getPendingSurveyQuestions(@PathVariable("surveyId") Integer surveyId,
            @PathVariable("userId") Integer userId) {

        List result = new ArrayList();
        try {
            result = (List) questionRepo.pendingSurveyQuestions(surveyId, userId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }

    @RequestMapping(value = "/pending/{surveyId}", method = RequestMethod.GET)
    public List getPendingQuestionBySurvey(@PathVariable("surveyId") Long sid){
        List result = new ArrayList();
        Survey s = surveyEntityRepository.findById(sid).get();

        result= s.getQuestions();

        return result;
    }
	

}
 
