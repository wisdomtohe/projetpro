package com.ipnetinstitute.csc394.backend.controller;

import java.util.*;

import com.ipnetinstitute.csc394.backend.dao.ClasseEntityRepository;
import com.ipnetinstitute.csc394.backend.dao.TeacherEntityRepository;
import com.ipnetinstitute.csc394.backend.entity.Classe;
import com.ipnetinstitute.csc394.backend.entity.ClasseCourseWP;
import com.ipnetinstitute.csc394.backend.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ipnetinstitute.csc394.backend.dao.CourseEntityRepository;
import com.ipnetinstitute.csc394.backend.entity.Course;

@CrossOrigin
@RestController
@RequestMapping("/courses")
public class CoursController  {
    
    @Autowired
    private CourseEntityRepository courseRepo;
    @Autowired
    private TeacherEntityRepository teacherEntityRepository;
    @Autowired
    private ClasseEntityRepository classeEntityRepository;

    @GetMapping("/getCourseByTeacher/{id}")
	public List getCourseByTeacher(@PathVariable("id") Integer id) {

        List result = new ArrayList();
        try {
            result = (List) courseRepo.findCousebyTeacher(id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Course> saveCourse(@RequestBody ClasseCourseWP classeCourseWP) {
        Course course = classeCourseWP.getCourse();

        List<Classe> classes = classeCourseWP.getClasses();
        List<Classe> courseClasses = new ArrayList<Classe>();
        if (course == null) {
            return new ResponseEntity<Course>(HttpStatus.BAD_REQUEST);
        }
        if(course.getId() != null && course.getId()>0) {
            course.setModDateTime(new Date());
        }
        else {
            course.setCreateDateTime(new Date());
            course.setModDateTime(new Date());
        }
        for(Classe entry : classes) {
            System.out.println("///////////////*************////////////////");
            System.out.println(entry.getName());
            System.out.println(classeEntityRepository.findById(entry.getId()).get());
            System.out.println("///////////////*************////////////////");
            courseClasses.add(classeEntityRepository.findById(entry.getId()).get());
        }
        course.setClasses(courseClasses);

        course = courseRepo.save(course);

        return new ResponseEntity<Course>(course, HttpStatus.OK);
    }

    @RequestMapping(value = "/save/classe", method = RequestMethod.POST)
    public ResponseEntity<Classe> saveClasse(@RequestBody ClasseCourseWP classeCourseWP) {
        Classe classe = classeCourseWP.getClasse();

        List<Course> courses = classeCourseWP.getCourses();
        List<Course> courseClasses = new ArrayList<Course>();
        if (classe == null) {
            return new ResponseEntity<Classe>(HttpStatus.BAD_REQUEST);
        }
        if(classe.getId() != null && classe.getId()>0) {
            classe.setModDateTime(new Date());
        }
        else {
            classe.setCreateDateTime(new Date());
            classe.setModDateTime(new Date());
        }
        for(Course entry : courses) {
            System.out.println("///////////////*************////////////////");
            System.out.println(entry.getName());
            System.out.println(courseRepo.findById(entry.getId()).get());
            System.out.println("///////////////*************////////////////");
            courseClasses.add(courseRepo.findById(entry.getId()).get());
        }
//        roles.add(roleEntitityRepository.findById(course.getRole()[0]))
        classe.setCourses(courseClasses);

        classe = classeEntityRepository.save(classe);

        return new ResponseEntity<Classe>(classe, HttpStatus.OK);
    }

}

    



