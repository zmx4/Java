/**
 * 抽象的地块基类，定义面积与周长的计算契约。
 */
public interface Field {
    /**
     * 计算地块面积。
     * @return 面积数值
     */
    public abstract double calculateArea();

    /**
     * 计算地块周长。
     * @return 周长数值
     */
    public abstract double calculatePerimeter();

    /**
     * 获取地块信息的简要描述字符串（包含类型、面积、周长）。
     * @return 格式化描述
     */
    public default String getFieldInformation() {
        // 使用类名作为类型名，保留两位小数
        return String.format("%s - Area: %.2f, Perimeter: %.2f",
            this.getClass().getSimpleName(),
            calculateArea(),
            calculatePerimeter());
    }
}
