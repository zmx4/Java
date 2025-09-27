public class FamilyEasy {
    int membersCount;
    FieldCircle circle;
    FieldRectangle rectangle;
    FieldTriangle triangle;
    double calculateFieldAreaPerMember(){
        if(circle != null){
            return circle.calculateArea() / membersCount;
        } else if(rectangle != null){
            return rectangle.calculateArea() / membersCount;
        } else if(triangle != null){
            return triangle.calculateArea() / membersCount;
        }
        return 0;
    }
}
