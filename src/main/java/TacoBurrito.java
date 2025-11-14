import java.util.ArrayList;

public class TacoBurrito implements Cost {
    String plateType;
    String shellType;
    ArrayList<Topping> topping;
    boolean isDeepFried;

    // tacoBurrito is made up of an arraylist named topping
    public TacoBurrito(){
        this.topping = new ArrayList<>();
    }

    public void deepFried(){

    }

    // Getters
    public String getPlateType() {
        return plateType;
    }

    public String getShellType() {
        return shellType;
    }

    public ArrayList<Topping> getTopping() {
        return topping;
    }

    public boolean isDeepFried() {
        return isDeepFried;
    }

    // Setters
    public void setPlateType(String plateType) {
        this.plateType = plateType;
    }

    public void setShellType(String shellType) {
        this.shellType = shellType;
    }

    public void setToppings(ArrayList<Topping> topping) {
        this.topping = topping;
    }

    public void setDeepFried(boolean deepFried) {
        isDeepFried = deepFried;
    }


    private String getToppingString() {
        String toppingString = "";
        // For every topping named topping in this.topping arraylist
        for (Topping topping : this.topping){
            // Add the topping name to the toppingString with ", "
            toppingString += topping.getName() + ", ";
        }
        return toppingString;
    }

    @Override
    public String toString() {
       return
               "PlateType: " + this.plateType + "\n" +
               "ShellType: " + this.shellType + "\n" +
               "Toppings: " + getToppingString() + "\n" +
               "Deep Fried: " + (isDeepFried ? "Yes" : "No");
    }


    @Override
    public double calcTotalCost() {
        double totalCost = 0;
        double toppingCost = 0;

        if (this.plateType.equalsIgnoreCase("Single Taco")){
            totalCost += 3.50;
        } else if (this.plateType.equalsIgnoreCase("Three Taco Plate")){
            totalCost += 9.00;
        } else if (this.plateType.equalsIgnoreCase("Burrito")){
            totalCost += 8.50;
        }

        for (Topping topping : this.topping){
            toppingCost += topping.getPrice();

        }

        return totalCost + toppingCost;

    }
}
