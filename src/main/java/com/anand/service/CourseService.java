package com.anand.service;

import com.anand.dto.Course;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private final List<Course> courses = new ArrayList<>();

    public void addCourse(Course course){
        courses.add(course);
    }

    public List<Course> getAllCourse(){
        return  courses;
    }

    public Optional<Course> getCourseById(int id){
        return courses.stream().filter(course -> course.getCid()==id).findFirst();
    }

    public boolean updateCourse(int id, Course newCourse){
        return getCourseById(id).map(exstingProject -> {
            courses.remove(exstingProject);
            courses.add(newCourse);
            return true;
        }).orElse(false);
    }

    public boolean deleteCourse(int id){
        return courses.removeIf(course -> course.getCid()==id);
    }

}
