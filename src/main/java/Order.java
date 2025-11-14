import java.util.ArrayList;

public class Order implements Cost{

    ArrayList<TacoBurrito> tacoBurritos;
    ArrayList<Drink> drinks;
    ArrayList<Side> sides;

    public Order(){
        // Initializing arraylist
        this.tacoBurritos = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.sides = new ArrayList<>();
    }

    public void addTacoBurrito(TacoBurrito tacoBurrito) {
        // Adds a tacoBurrito to the tacoBurritos arraylist
        this.tacoBurritos.add(tacoBurrito);
    }

    public void addDrink(Drink drink){
        this.drinks.add(drink);
    }

    public void addSide(Side side){
        this.sides.add(side);
    }

    private String tacosToString(){
        String tacoString = "";

        if (this.tacoBurritos == null){
            return tacoString;
        }
        for (TacoBurrito tacoBurrito : this.tacoBurritos){
            tacoString += tacoBurrito.toString() + "\n";
        }
        return tacoString;
    }

    private String drinksToString(){
        String drinkString = "";

        if (this.drinks == null){
            return drinkString;
        }
        for (Drink drink : this.drinks){
            drinkString += drink.toString() + "\n";
        }
        return drinkString;
    }

    private String sidesToString(){
        String sideString = "";

        if (this.sides == null){
            return sideString;
        }

        for (Side side : this.sides){
            sideString += side.toString() + "\n";
        }
        return sideString;
    }

    @Override
    public String toString() {
        boolean isTacoEmpty = tacosToString().isEmpty() || tacosToString().isBlank();
        boolean isDrinkEmpty = drinksToString().isEmpty() || drinksToString().isBlank();
        boolean isSideEmpty = sidesToString().isEmpty() || sidesToString().isBlank();

        return (!isTacoEmpty ? (tacosToString() + "=============================================\n") : "") +
               (!isDrinkEmpty ? (drinksToString() + "=============================================\n") : "") +
                (!isSideEmpty ?(sidesToString() + "=============================================\n") : "") +
                "Total: $" + calcTotalCost() + "\n";
    }

    @Override
    public double calcTotalCost() {
        double totalCost = 0;
        for (TacoBurrito tacoBurrito : this.tacoBurritos){
            totalCost += tacoBurrito.calcTotalCost();
        }

        for (Drink drink : this.drinks){
            totalCost += drink.calcTotalCost();
        }

        for (Side side : this.sides){
            totalCost += side.calcTotalCost();
        }

        return totalCost;

    }
}
