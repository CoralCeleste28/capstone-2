public class Drink implements Cost {
    String flavor;
    String size;


    public Drink(){
    }

    // Getters
    public String getFlavor() {
        return flavor;
    }

    public String getSize() {
        return size;
    }

    // Setters
    public void setSize(String size) {
        this.size = size;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    @Override
    public String toString() {
      return this.size + " - " + this.flavor;
    }

    @Override
    public double calcTotalCost() {
        if (this.size.equalsIgnoreCase("Large")){
            return 3.00;
        } else if (this.size.equalsIgnoreCase("Medium")) {
            return  2.50;
        } else if (this.size.equalsIgnoreCase("Small")) {
            return 2.00;
        }
        return 0;
    }
}
