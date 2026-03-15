public class Main {
        public static void main(String[] args) {
                Family family1 = new Family(3, new CirGround(5));
                System.out.printf("家庭一：面积：%.2f平方米，周长：%.2f米，人均：%.2f平方米。%n", family1.getArea(), family1.getPerimeter(),
                                family1.getPerArea());
                Family family2 = new Family(4, new RecGround(8, 5));
                System.out.printf("家庭二：面积：%.2f平方米，周长：%.2f米，人均：%.2f平方米。%n", family2.getArea(), family2.getPerimeter(),
                                family2.getPerArea());
                Family family3 = new Family(5, new TriGround(6, 8, 6, 8, 10));
                System.out.printf("家庭三：面积：%.2f平方米，周长：%.2f米，人均：%.2f平方米。%n", family3.getArea(), family3.getPerimeter(),
                                family3.getPerArea());
        }
}
