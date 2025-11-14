import java.util.ArrayList;

public class TacoBurrito implements Cost {

    // Declare variables
    private String plateType;
    private String shellType;
    private ArrayList<Topping> toppingList;
    private boolean isDeepFried;

    public TacoBurrito(){
        this.toppingList = new ArrayList<>();
    }

    // GETTERS
    public String getPlateType() {
        return plateType;
    }

    public String getShellType() {
        return shellType;
    }

    public ArrayList<Topping> getToppingList() {
        return toppingList;
    }

    public boolean isDeepFried() {
        return isDeepFried;
    }

    // SETTERS
    public void setPlateType(String plateType) {
        this.plateType = plateType;
    }

    public void setShellType(String shellType) {
        this.shellType = shellType;
    }

    public void setToppings(ArrayList<Topping> topping) {
        this.toppingList = topping;
    }

    public void setDeepFried(boolean deepFried) {
        isDeepFried = deepFried;
    }

    // HELPER METHOD
    // PRINTS SELECTED TOPPINGS ", "
    private String getToppingString() {
        String toppingString = "";
        // For every topping named topping in this.topping arraylist
        for (Topping topping : this.toppingList){
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
               // Ternary : (condition) ? value if true : value if false
               "Deep Fried: " + (isDeepFried ? "Yes" : "No");
    }


    @Override
    public double calcTotalCost() {
        double tacoBurritoCost = 0;
        double toppingCost = 0;

        if (this.plateType.equalsIgnoreCase("Single Taco")){
            tacoBurritoCost += 3.50;
        } else if (this.plateType.equalsIgnoreCase("Three Taco Plate")){
            tacoBurritoCost += 9.00;
        } else if (this.plateType.equalsIgnoreCase("Burrito")){
            tacoBurritoCost += 8.50;
        }

        for (Topping topping : this.toppingList){
            toppingCost += topping.getPrice();
        }
        return tacoBurritoCost + toppingCost;

    }
}
