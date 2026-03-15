//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        var family1 = new Family(4, new FieldRectangle(20, 30));
        var family2 = new Family(3, new FieldTriangle(20, 30));
        var family3 = new Family(4, new FieldCircle(20));
        System.out.println("Family 1 area per member: " + family1.calculateFieldAreaPerMember());
        System.out.println("Family 2 area per member: " + family2.calculateFieldAreaPerMember());
        System.out.println("Family 3 area per member: " + family3.calculateFieldAreaPerMember());
    }
}