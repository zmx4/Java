public class DigitalProduct extends Product {
    private int length;//文件大小
    private String link;//下载链接

    public DigitalProduct(String id, String name, double price, int length, String link) {
        super(id, name, price);
        this.length = length;
        this.link = link;
    }

    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }


    
}
