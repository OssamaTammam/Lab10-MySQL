package View;

public class productItem {

    private int id;
    private String productName;
    private double cost;
    private int quantity;

    public productItem(String productName, double cost, int quantity) {
        this.productName = productName;
        this.cost = cost;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String lineRepresentation() {
        return "ID: " + id + " Product Name: " + productName + " Cost: " + cost + " Quantity: " + quantity;
    }
}
