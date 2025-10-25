package com.student.credits;

/**
 * 模拟老师的角色，用于统计和打印学生的学分。
 */
public class CreditManager {

    /**
     * 打印指定学生的学分详情。
     * @param student 要查询的学生。
     */

    final double requiredCreditsForGraduation;

    public CreditManager(double requiredCreditsForGraduation) {
        this.requiredCreditsForGraduation = requiredCreditsForGraduation;
    }

    public void printStudentCreditReport(Student student) {
        System.out.println("--- 学分统计报告 ---");
        System.out.println("学生姓名: " + student.getName());
        System.out.println("--------------------");
        System.out.println("学分详情:");

        if (student.getCredits().isEmpty()) {
            System.out.println("  (暂无学分记录)");
        } else {
            for (Credit credit : student.getCredits()) {
                System.out.printf(
                    "  - [%s] %s: %.1f 学分\n",
                    credit.getType(),
                    credit.getName(),
                    credit.getValue()
                );
            }
        }

        System.out.println("--------------------");
        System.out.printf("总学分: %.1f\n", student.getTotalCredits());
        System.out.println("--- 报告结束 ---\n");
    }

    public void checkGraduationStatus(Student student) {
        System.out.println("毕业要求总学分: " + this.requiredCreditsForGraduation);
        if (student.getTotalCredits() >= this.requiredCreditsForGraduation) {
            System.out.println(
                student.getName() + " 已获得足够学分，可以毕业。"
            );
        } else {
            System.out.println(
                student.getName() + " 尚未获得足够学分，仍需努力。"
            );
        }
    }
}
