import java.util.ArrayList;

/**
 * 家庭与地块的组合，便于基于成员数计算人均面积并输出信息。
 */
public class Family implements IPerPersonAreaCal {
    /** 家庭拥有的地块 */
    private final ArrayList<Field> fields = new ArrayList<Field>();
    /** 家庭成员数量（>0） */
    private final int membersCount;

    /**
     * 构造函数。
     *
     * @param field 拥有的地块
     * @param membersCount 家庭成员数量
     */
    public Family(Field field, int membersCount) {
        this.fields.add(field);
        this.membersCount = membersCount;
    }

    /** 家庭成员数量 */
    public int getMembersCount() {
        return membersCount;
    }

    /** 家庭拥有的地块 */
    public ArrayList<Field> getField() {
        return fields;
    }

    /** 计算家庭拥有地块的总面积
     * @return 总面积
     */
    public double getTotalArea() {
        double totalArea = 0;
        for (Field field : fields) {
            totalArea += field.calculateArea();
        }
        return totalArea;
    }

    /** 计算家庭人均面积
     * @return 人均面积
     */
    public double getPerCapitaArea() {
        return getTotalArea() / membersCount;
    }

    /** 添加地块
     * @param field 新增地块
     */
    public void addField(Field field) {
        this.fields.add(field);
    }

}
