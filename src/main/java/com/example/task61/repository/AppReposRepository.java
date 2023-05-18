package com.example.task61.repository;

import com.example.task61.entities.AppRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface AppReposRepository extends JpaRepository<AppRequest, Long> {
    List<AppRequest> findAll();
    AppRequest findAllById(Long id);
    List<AppRequest> findAllByHandledEquals(boolean check);
}
