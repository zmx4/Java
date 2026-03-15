import java.lang.Math;

/**
 * 圆形地块，实现面积与周长的计算。
 * <p>
 * 注意：单位未限定，请在全局保持一致的度量单位（例如米）。
 */
public class Circle extends Field {
    /** 圆的半径 */
    private final double radius;

    /**
     * 构造一个圆。
     *
     * @param radius 半径（非负）
     */
    public Circle(int radius) {
        this.radius = radius;
    }

    /**
     * 计算圆的面积：πr²。
     *
     * @return 面积
     */
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    /**
     * 计算圆的周长：2πr。
     *
     * @return 周长
     */
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}
