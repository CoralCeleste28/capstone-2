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

    public static ArrayList<Topping> meatToppingsList(){
        ArrayList<Topping> meatToppings = new ArrayList<>();
        meatToppings.add(new Topping("Carne Asada", 1.00));
        meatToppings.add(new Topping("Al Pastor", 1.00));
        meatToppings.add(new Topping("Carnitas", 1.00));
        meatToppings.add(new Topping("Pollo", 1.00));
        meatToppings.add(new Topping("Chorizo", 1.00));
        meatToppings.add(new Topping("Pescado", 1.00));
        return meatToppings;
    }

    public static ArrayList<Topping> cheeseToppingsList(){
        ArrayList<Topping> cheeseToppings = new ArrayList<>();
        cheeseToppings.add(new Topping("Queso Fresco", .75));
        cheeseToppings.add(new Topping("Oaxaca", .75));
        cheeseToppings.add(new Topping("Cojita", .75));
        cheeseToppings.add(new Topping("Cheddar", .75));
        return cheeseToppings;
    }

    public static ArrayList<Topping> sauceToppingsList(){
        ArrayList<Topping> saucesToppings = new ArrayList<>();
        saucesToppings.add(new Topping("Salsa Verde", .0));
        saucesToppings.add(new Topping("Salsa Rojo", .0));
        saucesToppings.add(new Topping("Chipotle", .0));
        saucesToppings.add(new Topping("Habanero", .0));
        saucesToppings.add(new Topping("Mild", .0));
        saucesToppings.add(new Topping("Extra Hot", .0));
        return saucesToppings;
    }

    public static ArrayList<Topping> regularToppingsList(){
        ArrayList<Topping> regularToppings = new ArrayList<>();
        regularToppings.add(new Topping("Lettuce", .0));
        regularToppings.add(new Topping("Cilantro", .0));
        regularToppings.add(new Topping("Onion", .0));
        regularToppings.add(new Topping("Tomatoes", .0));
        regularToppings.add(new Topping("Jalapenos", .0));
        regularToppings.add(new Topping("Radishes", .0));
        regularToppings.add(new Topping("Pico De Gallo", .0));
        regularToppings.add(new Topping("Guacamole", .0));
        regularToppings.add(new Topping("Corn", .0));
        return regularToppings;
    }

    // change computer code to legible english
    @Override
    public String toString() {
        return this.name + " - " + this.price;
    }
}
