package com.student.credits;

import java.util.ArrayList;
import java.util.List;

/**
 * 代表一个学生，包含其个人信息和学分列表。
 */
public class Student {
    private String name;
    private List<Credit> credits;

    public Student(String name) {
        this.name = name;
        this.credits = new ArrayList<>();
    }

    /**
     * 为学生添加一项学分。
     * @param credit 要添加的学分项。
     */
    public void addCredit(Credit credit) {
        credits.add(credit);
    }

    /**
     * 计算并返回学生的总学分。
     * @return 总学分。
     */
    public double getTotalCredits() {
        double total = 0;
        for (Credit credit : credits) {
            total += credit.getValue();
        }
        return total;
    }

    public String getName() {
        return name;
    }

    public List<Credit> getCredits() {
        return credits;
    }
}
