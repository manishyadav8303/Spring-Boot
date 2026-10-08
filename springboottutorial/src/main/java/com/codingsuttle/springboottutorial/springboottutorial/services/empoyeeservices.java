package com.codingsuttle.springboottutorial.springboottutorial.services;

import com.codingsuttle.springboottutorial.springboottutorial.dto.employeedto;
import com.codingsuttle.springboottutorial.springboottutorial.entities.employeeEntity;
import com.codingsuttle.springboottutorial.springboottutorial.repository.employeerepositoty;
import org.apache.el.util.ReflectionUtil;
import org.aspectj.util.Reflection;
import org.modelmapper.ModelMapper;
import org.springframework.aot.hint.annotation.Reflective;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class empoyeeservices {

    private final employeerepositoty employeeRepository;
    private final ModelMapper modelMapper;

    public empoyeeservices(
            employeerepositoty employeeRepository,
            ModelMapper modelMapper) {

        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    // GET by ID
    public Optional<employeedto> findById(Long employeeid) {

        Optional<employeeEntity> employee =
                employeeRepository.findById(employeeid);

        return employee.map(
                e -> modelMapper.map(e, employeedto.class)
        );
    }

    // GET all
    public List<employeedto> findAll() {

        return employeeRepository.findAll()
                .stream()
                .map(e -> modelMapper.map(e, employeedto.class))
                .toList();
    }

    // POST
    public employeedto save(employeedto inputemployee) {

        employeeEntity entity =
                modelMapper.map(inputemployee, employeeEntity.class);

        employeeEntity saved =
                employeeRepository.save(entity);

        return modelMapper.map(saved, employeedto.class);
    }

    public employeedto updateemployee(
            Long employeeid,
            employeedto inputemployee) {

        employeeEntity existingEmployee =
                employeeRepository.findById(employeeid)
                        .orElse(null);

        if (existingEmployee == null) {
            return null;
        }

        modelMapper.map(inputemployee, existingEmployee);

        existingEmployee.setId(employeeid);

        employeeEntity updatedEmployee =
                employeeRepository.save(existingEmployee);

        return modelMapper.map(
                updatedEmployee,
                employeedto.class
        );
    }

    public boolean deletedid(Long employeeid) {
        boolean exists = employeeRepository.existsById(employeeid);
        if(!exists) return  false;
        employeeRepository.deleteById(employeeid);
        return true;
    }

    public employeedto patchdata(Long employeeid, Map<String, Object> updates) {
        boolean exists = employeeRepository.existsById(employeeid);
        if(!exists) return  null;
        employeeEntity EmployeeEntity = employeeRepository.findById(employeeid).get();
        updates.forEach((field , value) ->{
            Field fieldToupdate = ReflectionUtils.findField(employeeEntity.class , field);
            fieldToupdate.setAccessible(true);
            ReflectionUtils.setField(fieldToupdate , EmployeeEntity ,value);
        });
        return modelMapper.map(employeeRepository.save(EmployeeEntity) , employeedto.class);
    }
}