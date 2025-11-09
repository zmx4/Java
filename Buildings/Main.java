/**
 * 主程序类，用于演示如何使用不同的造价计算方式。
 */
public class Main {
    /**
     * 程序入口点
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        // 创建一个按面积计算造价的实例
        // 假设工程面积为50平方米，单位面积造价为20元
        CostCalculate costArea = new CostArea(50.0, 20.0);

        // 创建一个按高度计算造价的实例
        // 假设工程高度为30米，单位高度造价为10元
        CostCalculate costHight = new CostHight(30.0, 10.0);

        // 创建一个按体积计算造价的实例
        // 假设工程体积为100立方米，单位体积造价为40元
        CostCalculate costVolume = new CostVolume(100.0, 40.0);

        // 分别计算并输出不同工程的造价
        System.out.println("Cost Area: " + costArea.calculateCost());
        System.out.println("Cost Height: " + costHight.calculateCost());
        System.out.println("Cost Volume: " + costVolume.calculateCost());
    }
}
