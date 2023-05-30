package com.example.task61.services;

import com.example.task61.entities.CourseEntity;
import com.example.task61.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CourseRequestServiceImpl implements CourseRequestService{

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public CourseEntity AddCourse(CourseEntity courses) {
        return courseRepository.save(courses);
    }
}
