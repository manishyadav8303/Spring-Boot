package com.codingsuttle.springboottutorial.springboottutorial.dto;

import java.time.LocalDate;

public class employeedto {
    private  String name ;
    private  String email;
    private LocalDate dateofjoin;
    private boolean isactive;
    private Long id;
    private Long age;

    public employeedto(Long age) {
        this.age = age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Long getAge() {
        return age;
    }

    public employeedto(String name, String email, LocalDate dateofjoin, boolean isactive, Long id) {
        this.name = name;
        this.email = email;
        this.dateofjoin = dateofjoin;
        this.isactive = isactive;
        this.id = id;
        this.age = age;
    }
    public employeedto(){

    }

    public boolean isIsactive() {
        return isactive;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }

    public LocalDate getDateofjoin() {
        return dateofjoin;
    }

    public void setDateofjoin(LocalDate dateofjoin) {
        this.dateofjoin = dateofjoin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
