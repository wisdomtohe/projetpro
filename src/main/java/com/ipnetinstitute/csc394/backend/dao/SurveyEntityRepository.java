package com.ipnetinstitute.csc394.backend.dao;

import java.util.List;

import javax.transaction.Transactional;


import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.ipnetinstitute.csc394.backend.entity.Survey;


@Transactional
public interface SurveyEntityRepository extends BaseEntityRepository<Survey>  {
    
    @Query(value = "select sv.* from survey sv inner join response " +
     "r on sv.id = r.id_survey  inner join student s " +
      "on r.id_student = s.id   where s.id = :userId  ", nativeQuery = true)
    List<Survey> findAllSurveyRespondbyUser(@Param("userId") Integer userId);


    @Query(value = "SELECT * FROM survey s WHERE s.end_date >= now()", nativeQuery = true)
    List<Survey> findAllSurveyStillValid();


    @Query(value = "select * from survey sur " +
    		"where sur.id_cat_survey = :categoryId " +
    		 "and sur.id_course = :courseId",
    		 nativeQuery = true)
    List<Survey> findbyCategoryAndCourse(@Param("categoryId") Integer catSurveyId , @Param("courseId") Integer idCourse);

    
//    @Query(value= "SELECT DISTINCT S.* FROM survey S INNER JOIN cat_survey CS ON (S.id_cat_survey = CS.id)" +
//            " INNER JOIN cat_survey_question CSQ ON (CSQ.id_cat_survey= CS.id) " +
//            "WHERE CSQ.id_question NOT IN (SELECT SS.id_question " +
//             "FROM student_survey SS, student ST WHERE ST.id = SS.id_student AND  ST.id_user = :UserID);", nativeQuery = true)
//
    @Query(value= "SELECT DISTINCT S.* FROM survey S INNER JOIN course_has_survey CS " +
            "ON (S.id = CS.id_survey) INNER JOIN survey_has_question CSQ " +
            "ON (CSQ.id_survey= CS.id_survey) WHERE CSQ.id_question " +
            "NOT IN (SELECT SS.id_question FROM response SS, student ST, " +
            "user_is_student uis WHERE ST.id = SS.id_student AND  ST.id = uis.id_student " +
            "and uis.id_user= :UserID) and S.id in ( (SELECT DISTINCT s.id from survey s " +
            "inner join course_has_survey chs on s.id = chs.id_survey " +
            "INNER JOIN classe_has_course chc on chs.id_course = chc.id_course " +
            "INNER JOIN student st on st.id_classe = chc.id_classe " +
            "INNER JOIN user_is_student uis on uis.id_student = st.id " +
            "and uis.id_user = :UserID))", nativeQuery = true)
    List<Survey> pendingSurvey(@Param("UserID") Long userId);

    @Query(value= "SELECT DISTINCT Sv.* FROM survey Sv where Sv.id not in (SELECT DISTINCT S.id FROM survey S INNER JOIN course_has_survey CS " +
            "ON (S.id = CS.id_survey) INNER JOIN survey_has_question CSQ " +
            "ON (CSQ.id_survey= CS.id_survey) WHERE CSQ.id_question " +
            "NOT IN (SELECT SS.id_question FROM response SS, student ST, " +
            "user_is_student uis WHERE ST.id = SS.id_student AND  ST.id = uis.id_student " +
            "and uis.id_user= :UserID) and S.id " +
            " in (SELECT DISTINCT s.id from survey s " +
            "inner join course_has_survey chs on s.id = chs.id_survey " +
            "INNER JOIN classe_has_course chc on chs.id_course = chc.id_course " +
            "INNER JOIN student st on st.id_classe = chc.id_classe " +
            "INNER JOIN user_is_student uis on uis.id_student = st.id " +
            "and uis.id_user = :UserID))", nativeQuery = true)
    List<Survey> passedSurvey(@Param("UserID") Long userId);

    
    @Query(value= "select sy.* from survey sy " +
    			"inner  join course c on sy.id_course = c.id "  +
    			"where c.id_teacher =:teacherId",
    			nativeQuery = true)
    List<Survey> SurveyByTeacher(@Param("teacherId") Long teacherId);

    

    


}
