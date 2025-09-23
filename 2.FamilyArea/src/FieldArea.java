
public class FieldArea {

    public FieldArea(FieldType type, double x, double y) {
//        this.type = type;
        this.x = x;
        this.y = y;
        if(type == FieldType.RECTANGLE){
            this.type = FieldType.RECTANGLE;
            this.area = x * y;
        } else if(type == FieldType.CIRCLE){
            this.type = FieldType.CIRCLE;
            this.area = Math.PI * x * x;
        } else if(type == FieldType.TRIANGLE){
            this.type = FieldType.TRIANGLE;
            this.area = 0.5 * x * y;
        } else {
            throw new IllegalArgumentException("Invalid field type: " + type);
        }
    }

    FieldType type;
    double x;
    double y;
    double area;
}
