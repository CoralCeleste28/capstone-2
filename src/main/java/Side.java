public class Side implements Cost{
    String name;
    double price;

    public Side (){

    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return this.name + " - " + this.price;
    }

    @Override
    public double calcTotalCost() {
        return this.price;
    }
}
