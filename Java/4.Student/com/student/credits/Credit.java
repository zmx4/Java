package com.student.credits;

/**
 * 代表一项可以获得学分的活动或成就的抽象基类。
 */
public abstract class Credit {
    private String name;
    private double value;

    /**
     * @param name  学分项的名称 (例如, "全国大学生数学建模竞赛一等奖").
     * @param value 对应的学分值.
     */
    public Credit(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    /**
     * 返回学分的类型 (例如, "证书", "社会实践").
     * @return 学分类型的字符串.
     */
    public abstract String getType();
}
