package com.tick.springbootlearning.springbootlearning.entity;

public class SportTeacher implements Teacher {
    @Override
    public void teach() {
        System.out.println("教体育");
    }
}
