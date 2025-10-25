package com.student.credits;

/**
 * 代表通过发表论文获得的学分。
 */
public class Paper extends Credit {
    public Paper(String name, double value) {
        super(name, value);
    }

    @Override
    public String getType() {
        return "发表论文";
    }
}
