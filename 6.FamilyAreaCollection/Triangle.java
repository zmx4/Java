/**
 * 三角形地块，使用海伦公式计算面积。
 */
public class Triangle extends Field {
    /** 边 a 长度 */
    private final double sideA;
    /** 边 b 长度 */
    private final double sideB;
    /** 边 c 长度 */
    private final double sideC;

    /**
     * 构造一个三角形。
     *
     * @param sideA 边 a
     * @param sideB 边 b
     * @param sideC 边 c
     */
    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    /**
     * 使用海伦公式计算面积：设半周长 s=(a+b+c)/2，面积=√(s(s-a)(s-b)(s-c))。
     */
    @Override
    public double calculateArea() {
        double s = (sideA + sideB + sideC) / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    /**
     * 计算周长：a + b + c。
     */
    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }
}
