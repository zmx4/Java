public class FieldRectangle extends Field{
    double length;
    double width;
    FieldRectangle(double length, double width){
        this.length = length;
        this.width = width;
    }
    @Override
    double calculateArea() {
        area = length * width;
        return area;
    }
}
