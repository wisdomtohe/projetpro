package com.ipnetinstitute.csc394.backend.entity;

import java.util.List;

public class ClasseCourseWP {
    List<Classe> classes;
    Course course;
    List<Course> courses;
    Classe classe;

    public ClasseCourseWP() {
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Classe> getClasses() {
        return classes;
    }

    public void setClasses(List<Classe> classes) {
        this.classes = classes;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }
}
