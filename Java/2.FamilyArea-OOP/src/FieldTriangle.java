public class FieldTriangle extends  Field {
    double base;
    double height;
    FieldTriangle(double base, double height){
        this.base = base;
        this.height = height;
    }
    @Override
    double calculateArea() {
        area = 0.5 * base * height;
        return area;
    }
}
