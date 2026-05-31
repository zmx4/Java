package Entity;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Goods, Integer> items;

    public Cart() {
        this.items = new HashMap<>();
    }

    public void addItem(Goods goods, int count) {
        if (goods == null || count <= 0) return;
        items.put(goods, items.getOrDefault(goods, 0) + count);
    }

    public Map<Goods, Integer> getItems() {
        return items;
    }

    public int getTotalPrice() {
        int total = 0;
        for (Map.Entry<Goods, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }
}
