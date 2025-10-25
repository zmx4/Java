import com.student.credits.*;

public class Main {
    public static void main(String[] args) {
        // 创建一个学生
        Student student1 = new Student("张三");

        // 为学生添加不同类型的学分
        // 1. 考取证书
        student1.addCredit(new Certificate("大学英语六级证书", 2.0));
        student1.addCredit(new Certificate("计算机二级证书", 1.5));

        // 2. 参加社会实践
        student1.addCredit(new SocialPractice("暑期支教活动", 3.0));

        // 3. 发表论文 (通过继承新增的方式)
        student1.addCredit(new Paper("关于人工智能在教育领域的应用", 5.0));

        // 老师统计并打印学生的学分
        CreditManager teacher = new CreditManager();
        teacher.printStudentCreditReport(student1);

        // 假设毕业需要10个学分
        final double requiredCreditsForGraduation = 10.0;
        System.out.println("毕业要求总学分: " + requiredCreditsForGraduation);
        if (student1.getTotalCredits() >= requiredCreditsForGraduation) {
            System.out.println(student1.getName() + " 已获得足够学分，可以毕业。");
        } else {
            System.out.println(student1.getName() + " 尚未获得足够学分，仍需努力。");
        }
    }
}