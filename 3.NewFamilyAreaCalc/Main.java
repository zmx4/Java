public class Main {
    public static void main(String[] args) {
        Family family1 = new Family(new Rectangle(20, 15), 4);
        Family family2 = new Family(new Triangle(10, 12, 14), 3);
        Family family3 = new Family(new Circle(30), 5);

        System.out.println(family1.getFamilyFieldInformation());
        System.out.println(family2.getFamilyFieldInformation());
        System.out.println(family3.getFamilyFieldInformation());
    }
}
