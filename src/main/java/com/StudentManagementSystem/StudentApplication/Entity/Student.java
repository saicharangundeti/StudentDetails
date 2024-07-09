package com.StudentManagementSystem.StudentApplication.Entity;
public class Student {
    private int id;
    private String name;
    private Long fee;
    private int standard;
    public Student(){

    }
    public Student(int id, String name, Long fee, int standard) {
        this.id = id;
        this.name = name;
        this.fee = fee;
        this.standard = standard;
    }
    public void setId(int id){
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFee(Long fee) {
        this.fee = fee;
    }

    public void setStandard(int standard) {
        this.standard = standard;
    }

    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getFee() {
        return fee;
    }

    public int getStandard() {
        return standard;
    }


}
