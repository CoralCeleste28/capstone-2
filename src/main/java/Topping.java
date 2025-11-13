import java.util.ArrayList;
import java.util.HashMap;

public class Topping {
    // Declare variables
    String name;
    double price;

    public Topping(){

    }

    public Topping(String name, double price){
        this.name = name;
        this.price = price;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static ArrayList<Topping> meatToppingsList(boolean isExtra){
        ArrayList<Topping> meatToppings = new ArrayList<>();
        meatToppings.add(new Topping(isExtra ? "Extra Carne Asada" : "Carne Asada", isExtra ? 0.50 : 1.00));
        meatToppings.add(new Topping(isExtra ? "Extra Al Pastor" : "Al Pastor", isExtra ? 0.50 : 1.00));
        meatToppings.add(new Topping(isExtra ? "Extra Carnitas" : "Carnitas", isExtra ? 0.50 : 1.00));
        meatToppings.add(new Topping(isExtra ? "Extra Pollo" : "Pollo", isExtra ? 0.50 : 1.00));
        meatToppings.add(new Topping(isExtra ? "Extra Chorizo" : "Chorizo", isExtra ? 0.50 : 1.00));
        meatToppings.add(new Topping(isExtra ? "Extra Pescado" : "Pescado", isExtra ? 0.50 : 1.00));
        return meatToppings;
    }

    public static ArrayList<Topping> cheeseToppingsList(boolean isExtra){
        ArrayList<Topping> cheeseToppings = new ArrayList<>();
        cheeseToppings.add(new Topping(isExtra ? "Extra Queso Fresco" : "Queso Fresco", isExtra ? 0.30 : .75));
        cheeseToppings.add(new Topping(isExtra ? "Extra Oaxaca" : "Oaxaca", isExtra ? 0.30 : .75));
        cheeseToppings.add(new Topping(isExtra ? "Extra Cojita" : "Cojita", isExtra ? 0.30 : .75));
        cheeseToppings.add(new Topping(isExtra ? "Extra Cheddar" : "Cheddar", isExtra ? 0.30 : .75));
        return cheeseToppings;
    }

    public static ArrayList<Topping> sauceToppingsList(boolean isExtra){
        ArrayList<Topping> saucesToppings = new ArrayList<>();
        saucesToppings.add(new Topping(isExtra ? "Extra Salsa Verde" : "Salsa Verde", .0));
        saucesToppings.add(new Topping(isExtra ? "Extra Salsa Rojo" : "Salsa Rojo", .0));
        saucesToppings.add(new Topping(isExtra ? "Extra Chipotle Sauce" : "Chipotle", .0));
        saucesToppings.add(new Topping(isExtra ? "Extra Habanero Sauce" : "Habanero", .0));
        saucesToppings.add(new Topping(isExtra ? "Extra Mild Sauce" : "Mild", .0));
        saucesToppings.add(new Topping(isExtra ? "Extra Hot Sauce" : "Hot", .0));
        return saucesToppings;
    }

    public static ArrayList<Topping> regularToppingsList(boolean isExtra){
        ArrayList<Topping> regularToppings = new ArrayList<>();
        regularToppings.add(new Topping(isExtra ? "Extra Lettuce" : "Lettuce", .0));
        regularToppings.add(new Topping(isExtra ? "Extra Cilantro" : "Cilantro", .0));
        regularToppings.add(new Topping(isExtra ? "Extra Onion" : "Onion", .0));
        regularToppings.add(new Topping(isExtra ? "Extra Tomatoes" : "Tomatoes", .0));
        regularToppings.add(new Topping(isExtra ? "Extra Jalapenos" : "Jalapenos", .0));
        regularToppings.add(new Topping(isExtra ? "Extra Radishes" : "Radishes", .0));
        regularToppings.add(new Topping(isExtra ? "Extra Pico De Gallo": "Pico De Gallo", .0));
        regularToppings.add(new Topping(isExtra ? "Extra Guacamole" : "Guacamole", .0));
        regularToppings.add(new Topping(isExtra ? "Extra Corn" : "Corn", .0));
        return regularToppings;
    }

    // change computer code to legible english
    @Override
    public String toString() {
        return this.name + " - $" + this.price;
    }
}
