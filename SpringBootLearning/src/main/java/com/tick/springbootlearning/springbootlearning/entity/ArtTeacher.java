package com.tick.springbootlearning.springbootlearning.entity;

public class ArtTeacher implements Teacher{

    @Override
    public void teach() {
        System.out.println("教美术");
    }
}
