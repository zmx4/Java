/**
 * 程序入口：构建不同形状的地块并关联家庭，输出综合信息。
 */
public class Main {
    public static void main(String[] args) {
        // 示例数据：三个家庭分别拥有矩形、三角形与圆形地块
        Family family = new Family(new Rectangle(20, 15), 4);
        
        family.addField(new Triangle(3, 4, 5));
        family.addField(new Circle(7));

        // 输出家庭信息
        System.out.println("家庭成员数量: " + family.getMembersCount());
        System.out.println("家庭拥有地块总面积: " + family.getTotalArea());
        System.out.println("家庭人均面积: " + family.getPerCapitaArea());

        
    }
}
