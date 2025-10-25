package com.student.credits;

/**
 * 代表通过考取证书获得的学分。
 */
public class Certificate extends Credit {
    public Certificate(String name, double value) {
        super(name, value);
    }

    @Override
    public String getType() {
        return "证书";
    }
}
