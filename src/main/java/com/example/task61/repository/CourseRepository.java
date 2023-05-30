package com.example.task61.repository;

import com.example.task61.entities.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CourseRepository extends JpaRepository<CourseEntity,Long> {
    CourseEntity findAllById(Long id);
}
