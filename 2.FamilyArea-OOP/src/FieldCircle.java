
public class FieldCircle extends Field {
    double radius;
    FieldCircle(double radius){
        this.radius = radius;
    }
    @Override
    double calculateArea() {
        area = Math.PI * radius * radius;
        return area;
    }
}
