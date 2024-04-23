class Item {
    private String itemName;
    private int quantity;
    private double price;

    public Item(String itemName, int quantity, double price) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }

    public double getTotal() {
        return quantity * price;
    }

    public String toString() {
        return String.format("%s\t\t %d\t%.2f\t\t %.2f", itemName, quantity, price, getTotal());
    }
}