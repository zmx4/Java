package com.tick.springbootlearning.springbootlearning;

import com.tick.springbootlearning.springbootlearning.entity.Student;
import com.tick.springbootlearning.springbootlearning.service.Service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringBootLearningApplication {

    public static void main(String[] args) {
//        SpringApplication.run(SpringBootLearningApplication.class, args);
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Student student = (Student) context.getBean("student");

    }

}
