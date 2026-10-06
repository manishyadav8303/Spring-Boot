package com.codingsuttle.springboottutorial.springboottutorial.controller;

import com.codingsuttle.springboottutorial.springboottutorial.dto.employeedto;
import com.codingsuttle.springboottutorial.springboottutorial.services.empoyeeservices;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static com.codingsuttle.springboottutorial.springboottutorial.services.empoyeeservices.*;

@RestController
@RequestMapping("/employee")
public class employeecontrolller {

    private final empoyeeservices Employeservice;

    public employeecontrolller(empoyeeservices employeservice) {
        Employeservice = employeservice;
    }

    @GetMapping("/{employeeid}")
    public employeedto getemployeeid(
            @PathVariable Long employeeid) {

        return Employeservice.findById(employeeid)
                .orElse(null);
    }

    @GetMapping
    public List<employeedto> getallemployee() {

        return Employeservice.findAll();
    }

    @PostMapping
    public employeedto addemployee(
            @RequestBody employeedto inputemployee) {

        return Employeservice.save(inputemployee);
    }

    @PutMapping("/{employeeid}")
    public employeedto updateemployee(
            @RequestBody employeedto employeedto,
            @PathVariable Long employeeid) {

        return Employeservice.updateemployee(employeeid, employeedto);
    }
    @DeleteMapping("/{employeeid}")
    public boolean deletedid(@PathVariable Long employeeid){
        return Employeservice.deletedid(employeeid);
    }
    @PatchMapping("/{employeeid}")
    public employeedto patchdata(@RequestBody Map<String , Object> updates,
                                 @PathVariable Long employeeid){
        return Employeservice. patchdata(employeeid , updates);
    }
}