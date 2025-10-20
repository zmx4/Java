import java.lang.Math;
public class Circle extends Field {
    private final double radius;
    public Circle(int radius) {
        this.radius = radius;
    }
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}
