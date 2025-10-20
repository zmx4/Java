/**
 * 矩形地块，实现面积与周长的计算。
 */
public class Rectangle extends Field {
    /** 长边长度 */
    private final double length;
    /** 短边长度 */
    private final double width;

    /**
     * 构造一个矩形。
     *
     * @param length 长边
     * @param width  短边
     */
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    /**
     * 面积计算：长 × 宽。
     */
    public double calculateArea() {
        return length * width;
    }

    /**
     * 周长计算：2 × (长 + 宽)。
     */
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
}
