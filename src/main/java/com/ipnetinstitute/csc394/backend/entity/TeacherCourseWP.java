package com.ipnetinstitute.csc394.backend.entity;

import java.util.List;

public class TeacherCourseWP {
    public TeacherCourseWP(Teacher teacher, List<Course> courses) {
        this.teacher = teacher;
        this.courses = courses;
    }

    public TeacherCourseWP() {
    }

    Teacher teacher;
    List<Course> courses;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
