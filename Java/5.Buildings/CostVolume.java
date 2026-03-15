/**
 * 按体积计算工程造价的类。
 */
public class CostVolume implements CostCalculate {
    private double volume; // 工程量：体积
    private double costPerVolume; // 单位体积造价

    /**
     * 构造函数
     * @param volume 工程体积
     * @param costPerUnitVolume 单位体积的造价
     */
    public CostVolume(double volume, double costPerUnitVolume) {
        this.volume = volume;
        this.costPerVolume = costPerUnitVolume;
    }

    /**
     * 计算总造价
     * @return 按体积计算出的总造价
     */
    @Override
    public double calculateCost() {
        return volume * costPerVolume;
    }
}