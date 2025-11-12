public class Drink {
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
}
