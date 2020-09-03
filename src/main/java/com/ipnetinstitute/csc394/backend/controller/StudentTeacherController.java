package com.ipnetinstitute.csc394.backend.controller;

import com.ipnetinstitute.csc394.backend.dao.StudentEntityRepository;
import com.ipnetinstitute.csc394.backend.dao.TeacherEntityRepository;
import com.ipnetinstitute.csc394.backend.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin
@RestController
public class StudentTeacherController {

    @Autowired
    TeacherEntityRepository teacherRepo;

    @Autowired
    StudentEntityRepository studentRepo;

    @RequestMapping(value = "/get/TeacherWithTheirUser", method = RequestMethod.GET)
    public List getfindAllTeacherWithTheirUser () {
        List result = new ArrayList();
        try {
            result=  teacherRepo.findAllTeacherWithTheirUser();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }
    @RequestMapping(value = "/get/StudentWithTheirUser", method = RequestMethod.GET)
    public List getfindAllStudentWithTheirUser () {
        List result = new ArrayList();
        try {
            result=  studentRepo.findAllStudentWithTheirUser();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }

//    @RequestMapping(value = "/get/user/student/{id}", method = RequestMethod.GET)
//    public Student getStudentByHisUid(@PathVariable("id") Long id){
//        return studentRepo.findStudentByUserId(id);
//    }

    @RequestMapping(value = "/get/user/student/{id}", method = RequestMethod.GET)
    Long studentLoggedIn(@PathVariable("id") Long id){
        return studentRepo.studentLoggedIn(id);
    }
    @RequestMapping(value = "/get/user/teacher/{id}", method = RequestMethod.GET)
    Long teacherLoggedIn(@PathVariable("id") Long id){
        return studentRepo.teacherLoggedIn(id);
    }
}
