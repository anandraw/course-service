package com.anand.controller;

import com.anand.dto.Course;
import com.anand.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<Course> addCourse(@RequestBody Course course){
        courseService.addCourse(course);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Course>> getAllCourses(){
        List<Course> allCourse = courseService.getAllCourse();
        return new ResponseEntity<>(allCourse,HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}",produces = "application/json")
    public String deleteCourse(@PathVariable int id){
        courseService.deleteCourse(id);
        return "course deleted sucessfuly";
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Optional<Course>> getCoursebyId(@PathVariable int id){
        Optional<Course> courseById = courseService.getCourseById(id);
        return new ResponseEntity<>(courseById,HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course, @PathVariable int id){
        boolean updated = courseService.updateCourse(id, course);
        if (updated){
            return new ResponseEntity<>(course, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
