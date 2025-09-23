//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        var F = new Family();
        F.addMember("Alice", new FieldArea(FieldType.RECTANGLE, 4, 5));
        F.addMember("Bob", new FieldArea(FieldType.CIRCLE, 3, 0));
        F.addMember("Charlie", new FieldArea(FieldType.TRIANGLE, 4, 6));

        System.out.println("Total Area: " + F.getTotalArea());
        System.out.println("Average Area: " + F.getAverageArea());
    }
}