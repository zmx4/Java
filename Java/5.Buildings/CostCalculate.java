/**
 * 定义了工程造价计算的通用接口。
 * 所有具体的造价计算类都需要实现这个接口。
 */
public interface CostCalculate {
    /**
     * 计算并返回工程的造价。
     * @return 工程造价
     */
    double calculateCost();
}

