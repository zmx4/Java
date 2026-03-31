public class PhysicalProduct extends Product {
    private double weight;//重量
    private int size;//尺寸
    public PhysicalProduct(String id, String name, double price, double weight, int size) {
        super(id, name, price);
        this.weight = weight;
        this.size = size;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    
}
