public class Side implements Cost{
    String name;
    double price;

    public Side (){
    }
    // GETTERS
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // SETTERS
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // DISPLAY IN UI
    @Override
    public String toString() {
        return this.name + " - " + this.price;
    }

    @Override
    public double calcTotalCost() {
        return this.price;
    }
}
