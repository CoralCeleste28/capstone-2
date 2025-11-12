import java.util.ArrayList;

public class TacoBurrito {
    String plateType;
    String shellType;
    ArrayList<Topping> topping;
    boolean isDeepFried;

    public TacoBurrito(){
        this.topping = new ArrayList<>();
    }

    public TacoBurrito(String plateType, String shellType, ArrayList<Topping> topping, boolean isDeepFried){
        this.plateType = plateType;
        this.shellType = shellType;
        this.topping = topping;
        this.isDeepFried = isDeepFried;

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

    public void setTopping(ArrayList<Topping> topping) {
        this.topping = topping;
    }

    public void setDeepFried(boolean deepFried) {
        isDeepFried = deepFried;
    }

    private String getToppingString() {
    }

    @Override
    public String toString() {
       return
               "PlateType: " + this.plateType + "\n" +
               "ShellType: " + this.shellType + "\n" +
               "Toppings: " + getToppingString() + "\n" +
               "Deep Fried: " + (isDeepFried ? "Yes" : "No");


    }


}
