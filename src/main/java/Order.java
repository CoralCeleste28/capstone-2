import java.util.ArrayList;

public class Order {

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
}
