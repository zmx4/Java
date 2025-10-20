public abstract class Field {
    public abstract double calculateArea();
    public abstract double calculatePerimeter();
    public String getFieldInformation() {
        return String.format("%s - Area: %.2f, Perimeter: %.2f",
            this.getClass().getSimpleName(),
            calculateArea(),
            calculatePerimeter());
    }
}
