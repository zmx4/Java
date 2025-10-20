/**
 * 程序入口：构建不同形状的地块并关联家庭，输出综合信息。
 */
public class Main {
    public static void main(String[] args) {
        // 示例数据：三个家庭分别拥有矩形、三角形与圆形地块
        Family family1 = new Family(new Rectangle(20, 15), 4);
        Family family2 = new Family(new Triangle(10, 12, 14), 3);
        Family family3 = new Family(new Circle(30), 5);

        // 打印每个家庭的地块信息与人均面积
        System.out.println(family1.getFamilyFieldInformation());
        System.out.println(family2.getFamilyFieldInformation());
        System.out.println(family3.getFamilyFieldInformation());
    }
}
