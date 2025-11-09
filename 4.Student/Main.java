import com.student.credits.*;

public class Main {

    public static void main(String[] args) {
        // 创建一个学生
        Student student1 = new Student("张三");
        Student student2 = new Student("李四");

        // 不同的学分
        Certificate certificate1 = new Certificate("大学英语六级证书", 2.0);
        Certificate certificate2 = new Certificate("计算机二级证书", 1.5);
        SocialPractice socialPractice = new SocialPractice("暑期支教活动", 3.0);
        Paper paper = new Paper("关于人工智能在教育领域的应用", 5.0);

        // 添加学分
        student1.addCredits(certificate1, certificate2, socialPractice);

        student2.addCredits(paper);

        // 老师统计并打印学生的学分
        CreditManager teacher = new CreditManager(10.0);
        teacher.printStudentCreditReport(student1);
        teacher.checkGraduationStatus(student1);

        teacher.printStudentCreditReport(student2);
        teacher.checkGraduationStatus(student2);
    }
}
