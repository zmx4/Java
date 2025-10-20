public class Family {
    private final Field field;
    private final int membersCount;
    public Family(Field field, int membersCount) {
        this.field = field;
        this.membersCount = membersCount;
    }

    public int getMembersCount() {
        return membersCount;
    }

    public Field getField() {
        return field;
    }

    public String getFieldInformation() {
        return field.getFieldInformation();
    }

    public double calculateAreaPerMember() {
        return field.calculateArea() / membersCount;
    }

    public String getFamilyFieldInformation() {
        return field.getFieldInformation() +
            ", Members: " +
            membersCount +
            ", Area per Member: " + 
            ((Double)(calculateAreaPerMember())).toString().substring(0, 
            ((Double)(calculateAreaPerMember())).toString().indexOf('.') + 2);
    }
}
