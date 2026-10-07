package com.codingsuttle.springboottutorial.springboottutorial.repository;

import com.codingsuttle.springboottutorial.springboottutorial.entities.employeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface employeerepositoty extends JpaRepository<employeeEntity, Long > {
   // List<employeeEntity> findByName(String name);
}
