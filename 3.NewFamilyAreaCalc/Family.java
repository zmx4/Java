/**
 * 家庭与地块的组合，便于基于成员数计算人均面积并输出信息。
 */
public class Family {
    /** 家庭拥有的地块 */
    private final Field field;
    /** 家庭成员数量（>0） */
    private final int membersCount;

    /**
     * 构造函数。
     *
     * @param field 拥有的地块
     * @param membersCount 家庭成员数量
     */
    public Family(Field field, int membersCount) {
        this.field = field;
        this.membersCount = membersCount;
    }

    /** 家庭成员数量 */
    public int getMembersCount() {
        return membersCount;
    }

    /** 家庭拥有的地块 */
    public Field getField() {
        return field;
    }

    /** 仅返回地块本身的信息描述 */
    public String getFieldInformation() {
        return field.getFieldInformation();
    }

    /**
     * 计算人均面积。
     *
     * @return 地块面积/成员数
     */
    public double calculateAreaPerMember() {
        return field.calculateArea() / membersCount;
    }

    /**
     * 返回包含地块信息、成员数量与人均面积的描述。
     */
    public String getFamilyFieldInformation() {
        return field.getFieldInformation() +
            ", Members: " +
            membersCount +
            ", Area per Member: " + 
            ((Double)(calculateAreaPerMember())).toString().substring(0, 
            ((Double)(calculateAreaPerMember())).toString().indexOf('.') + 2);
    }
}
