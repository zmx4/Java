/**
 * 按面积计算工程造价的类。
 */
public class CostArea implements CostCalculate {
    private double area; // 工程量：面积
    private double costPerArea; // 单位面积造价
    
    /**
     * 构造函数
     * @param area 工程面积
     * @param costPerUnitArea 单位面积的造价
     */
    public CostArea(double area, double costPerUnitArea) {
        this.area = area;
        this.costPerArea = costPerUnitArea;
    }

    /**
     * 计算总造价
     * @return 按面积计算出的总造价
     */
    @Override
    public double calculateCost() {
        return area * costPerArea;
    }
}
