/**
 * 按高度计算工程造价的类。
 */
public class CostHight implements CostCalculate {
    private double height; // 工程量：高度
    private double costPerHeight; // 单位高度造价

    /**
     * 构造函数
     * @param height 工程高度
     * @param costPerUnitHeight 单位高度的造价
     */
    public CostHight(double height, double costPerUnitHeight) {
        this.height = height;
        this.costPerHeight = costPerUnitHeight;
    }

    /**
     * 计算总造价
     * @return 按高度计算出的总造价
     */
    @Override
    public double calculateCost() {
        return height * costPerHeight;
    }
    
}
