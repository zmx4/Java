package com.student.credits;

/**
 * 代表通过参加社会实践获得的学分。
 */
public class SocialPractice extends Credit {
    public SocialPractice(String name, double value) {
        super(name, value);
    }

    @Override
    public String getType() {
        return "社会实践";
    }
}
