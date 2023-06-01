package bsu.evg.m;

public class Item {
    private int weight;
    private int price;
    private int count;
    public Item(int weight, int price, int count) {
        this.weight = weight;
        this.price = price;
        this.count = count;
    }
    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }


    @Override
    public String toString() {
        return "Item: " + "weight = " + weight + ", price = " + price + ", count = " + count;
    }
}
