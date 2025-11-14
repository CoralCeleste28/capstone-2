import java.util.ArrayList;

public class Order implements Cost{

    ArrayList<TacoBurrito> tacoBurritosList;
    ArrayList<Drink> drinksList;
    ArrayList<Side> sidesList;

    public Order(){
        // Initializing arraylist
        this.tacoBurritosList = new ArrayList<>();
        this.drinksList = new ArrayList<>();
        this.sidesList = new ArrayList<>();
    }

    // UPDATE METHODS FOR TACO_BURRITO, DRINK, SIDE
    public void addTacoBurrito(TacoBurrito tacoBurrito) {
        // Adds a tacoBurrito to the tacoBurritos arraylist
        this.tacoBurritosList.add(tacoBurrito);
    }
    public void addDrink(Drink drink){
        this.drinksList.add(drink);
    }
    public void addSide(Side side){
        this.sidesList.add(side);
    }

    // HELPER METHODS - TO_STRING - TO DISPLAY
    private String tacosToString(){
        String tacoString = "";

        if (this.tacoBurritosList == null){
            return tacoString;
        }
        // Call toString method from TacoBurrito class to display chosen TacoBurrito
        for (TacoBurrito tacoBurrito : this.tacoBurritosList){
            tacoString += tacoBurrito.toString() + "\n";
        }
        return tacoString;
    }
    private String drinksToString(){
        String drinkString = "";

        if (this.drinksList == null){
            return drinkString;
        }
        // Call toString method from Drink class to display chosen drinks
        for (Drink drink : this.drinksList){
            drinkString += drink.toString() + "\n";
        }
        return drinkString;
    }
    private String sidesToString(){
        String sideString = "";

        if (this.sidesList == null){
            return sideString;
        }

        for (Side side : this.sidesList){
            // Call toString method from Side class to display chosen sides
            sideString += side.toString() + "\n";
        }
        return sideString;
    }

    @Override
    public String toString() {
        // isEmpty- ""
        // isBlank- " "
        // true- isTacoEmpty
        // false- taco is not empty
        boolean isTacoEmpty = tacosToString().isBlank();
        boolean isDrinkEmpty = drinksToString().isBlank();
        boolean isSideEmpty = sidesToString().isBlank();

        // if Taco is NOT empty: =
        // if Taco is empty: ""
        return (!isTacoEmpty ? (tacosToString() + "=============================================\n") : "") +
               (!isDrinkEmpty ? (drinksToString() + "=============================================\n") : "") +
                (!isSideEmpty ?(sidesToString() + "=============================================\n") : "") +
                "Total: $" + calcTotalCost() + "\n";
    }

    @Override
    public double calcTotalCost() {
        double totalCost = 0;
        for (TacoBurrito tacoBurrito : this.tacoBurritosList){
            totalCost += tacoBurrito.calcTotalCost();
        }

        for (Drink drink : this.drinksList){
            totalCost += drink.calcTotalCost();
        }

        for (Side side : this.sidesList){
            totalCost += side.calcTotalCost();
        }

        return totalCost;

    }
}
