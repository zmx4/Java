public class Family {
    int membersCount;
    Field field;
    double calculateFieldAreaPerMember(){
        return field.calculateArea() / membersCount;
    }
    Family(int membersCount, Field field){
        this.membersCount = membersCount;
        this.field = field;
    }
}
