import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class UserInterface {

    Scanner scanner = new Scanner(System.in);
    Order order = new Order();
    TacoBurrito tacoBurrito = new TacoBurrito();
    Drink drink = new Drink();
    Side side = new Side();

    public void runApp(){
        homeScreen();
    }

    private void closeApp() {
        System.out.println("Thank you for vising Chiqui's Near Me");
        scanner.close();
    }

    private void homeScreen (){
        int homescreenSelection = 0;

        do {
            System.out.printf("""
                ┌──────────────────────────────────┐
                | WELCOME TO CHIQI'S TACOS NEAR ME |
                └──────────────────────────────────┘
                Please select from the following:
                1) Add taco or burrito
                2) Add drink
                3) Add side
                4) Checkout
                0) Cancel order
                """);

            homescreenSelection = Integer.parseInt(this.scanner.nextLine());

            if (homescreenSelection == 0){
                closeApp();
            } else if (homescreenSelection == 1) {
                plateTypeSelection();
            } else if (homescreenSelection == 2){
                selectDrinkFlavor();
            } else if (homescreenSelection == 3) {
                addSideToOrder();
            } else if (homescreenSelection == 4) {
                checkout();
            } else {
                System.out.println("Try again. PLease select a valid entry.");
                homescreenSelection = 0;
            }

        } while (true);
    }

    private void checkout() {
        System.out.println("Here is your order:");
        System.out.println(this.order);
    }

    private void addSideToOrder() {
        int sideSelection = 0;

        do {
            System.out.println("""
                    Please select a side:
                    1) Lime Wedges - Free
                    2) Crema - Free
                    3) Chips and Salsa - $1.50
                    """);

            sideSelection = Integer.parseInt(this.scanner.nextLine());

            this.side.setPrice(0);

            if (sideSelection == 1){
                this.side.setName("Lime Wedges");
            } else if (sideSelection == 2) {
                this.side.setName("Crema");
            } else if (sideSelection == 3) {
                this.side.setName("Chips and Salsa");
                this.side.setPrice(1.50);
            } else {
                System.out.println("Invalid entry. Please try again.");
                sideSelection = 0;
            }
        } while (sideSelection == 0);
        System.out.println("Side added: ");
        System.out.println(this.side.toString());
        this.order.addSide(this.side);
    }

    private void selectDrinkFlavor() {

        int drinkSelection = 0;

        do {
            System.out.println("""
                Please select a drink:
                1) Horchata
                2) Jamaica
                3) Tamarindo
                """);

            drinkSelection = Integer.parseInt(this.scanner.nextLine());

            if (drinkSelection == 1){
                this.drink.setFlavor("Horchata");
            } else if (drinkSelection == 2) {
                this.drink.setFlavor("Jamaica");
            } else if (drinkSelection == 3) {
                this.drink.setFlavor("Tamarindo");
            } else {
                System.out.println("Try again. PLease select a valid entry.");
                drinkSelection = 0;
            }
        } while (drinkSelection == 0);
      selectDrinkSize();
    }

    private void selectDrinkSize() {
        int drinkSizeSelection = 0;

        do {
            System.out.println("""
                    Please select a size:
                    1) Small - $2.00
                    2) Medium - $2.50
                    3) Large - $3.00
                    """);
            drinkSizeSelection = Integer.parseInt(this.scanner.nextLine());

            if (drinkSizeSelection == 1){
                this.drink.setSize("Small");
            } else if (drinkSizeSelection == 2){
                this.drink.setSize("Medium");
            } else if (drinkSizeSelection == 3) {
                this.drink.setSize("Large");
            } else {
                System.out.println("Try again. PLease select a valid entry.");
                drinkSizeSelection = 0;
            }
        } while (drinkSizeSelection == 0);
        System.out.println("Drink Added: ");
        System.out.println(this.drink.toString());
        this.order.addDrink(this.drink);
    }

    private void plateTypeSelection(){
        int plateTypeSelection = 0;

        do {
            System.out.print("""
                
                Please select from the following:
                1) Burrito
                2) Single Taco
                3) Three Taco Plate
                """);

            plateTypeSelection = Integer.parseInt(this.scanner.nextLine());

            if (plateTypeSelection == 1){
                this.tacoBurrito.setPlateType("Burrito");
                shellTypeForTaco(true);
            } else if (plateTypeSelection == 2) {
                this.tacoBurrito.setPlateType("Single Taco");
                shellTypeForTaco(false);
            } else if (plateTypeSelection == 3) {
                this.tacoBurrito.setPlateType("Three Taco Plate");
                shellTypeForTaco(false);
            } else {
                System.out.println("Try again. PLease select a valid entry.");
                plateTypeSelection = 0;
            }
        } while (plateTypeSelection == 0);
    }

    private void shellTypeForTaco(boolean isBurrito){
        int shellTypeForTacoChoice = 0;

        do {
            if (isBurrito == true) {
                printBurritoTortillaOptions();
            } else {
                printTacoTortillaOptions();
            }

            shellTypeForTacoChoice = Integer.parseInt(this.scanner.nextLine());

            if (shellTypeForTacoChoice == 1){
                this.tacoBurrito.setShellType("Corn");
            } else if (shellTypeForTacoChoice == 2) {
                this.tacoBurrito.setShellType("Flour");
            } else if (shellTypeForTacoChoice == 3) {
                if (isBurrito == true) {
                    this.tacoBurrito.setShellType("Bowl");
                }  else {
                    this.tacoBurrito.setShellType("Hard Shell");
                }
            } else {
                System.out.println("Try again. PLease select a valid entry.");
                shellTypeForTacoChoice = 0;
            }
        } while (shellTypeForTacoChoice == 0);

        addToppingsToTaco();

    }

    private void printTacoTortillaOptions(){
        System.out.println("""
                
                Choose tortilla type:
                1) Corn
                2) Flour
                3) Hard Shell""");

    }

    private void printBurritoTortillaOptions(){
        System.out.println("""
               
               Choose tortilla type:
               1) Corn
               2) Flour
               3) Bowl""");
    }

    private void addToppingsToTaco(){
        // Creating empty hashmap named toppingMap
        // In the hashmap there is integer and topping section
        HashMap<Integer, Topping> toppingMap = new HashMap<>();
        // Creating an array list named toppingsForTacoArrayList with NULL Toppings- It will be filled with toppings
        ArrayList<Topping> toppingsForTacoArrayList = new ArrayList<>();

        int toppingChoice = 5;

        do {
            System.out.printf("""
                    
                    Choose Toppings
                    0) Done Adding
                    1) Meat
                    2) Cheese
                    3) Regular Toppings
                    4) Sauces
                    """);

            toppingChoice = Integer.parseInt(this.scanner.nextLine());

            if (toppingChoice == 0){
                int extraToppingsChoice = 0;

                do {
                    System.out.println("""
                        Would you like to add extra toppings?
                        1) Si
                        2) No
                        """);

                    extraToppingsChoice = Integer.parseInt(this.scanner.nextLine());

                    if(extraToppingsChoice == 1){
                        this.tacoBurrito.setToppings(addExtraToppings(toppingsForTacoArrayList, toppingMap));
                    } else if (extraToppingsChoice == 2) {
                        this.tacoBurrito.setToppings(toppingsForTacoArrayList);
                    } else {
                        System.out.println("Invalid selection. Please try again.");
                        extraToppingsChoice = 0;
                    }
                } while (extraToppingsChoice == 0);

                // Break loop to deepFried
                break;
            }

            if (toppingChoice == 1){
                int meatChoice = 0;
                System.out.println(" ");
                System.out.println("Choose Meat Toppings");
                System.out.println("0) Done Adding");
                // Hashmap = Class.Method(Class.Method)
                // Inserting meatToppingList into toppingMenuHelper.
                // toppingMenuHelper fills out the topping map hash map and displays it to the user
                toppingMap = toppingMenuHelper(Topping.meatToppingsList(false));
                meatChoice = Integer.parseInt(this.scanner.nextLine());
                if (meatChoice == 0){
                    // taken to toppings general menu
                } else {
                    if (toppingMap.get(meatChoice) == null){
                        System.out.println("Invalid Selection. Please Try Again.");
                        // Goes back to the beginning of the loop
                        continue;
                    }
                    // Gets topping info (name and price)
                   Topping meatTopping = toppingMap.get(meatChoice);
                    // Adds meat topping to topppingsForTacoArrayList
                   toppingsForTacoArrayList.add(meatTopping);
                }

            } else if (toppingChoice == 2) {
                int cheeseChoice = 0;
                System.out.println(" ");
                System.out.println("Choose Cheese Toppings");
                System.out.println("0) Done Adding") ;
                // Creating and displaying toppings
                toppingMap = toppingMenuHelper(Topping.cheeseToppingsList(false));
                cheeseChoice = Integer.parseInt(this.scanner.nextLine());
                if (cheeseChoice == 0){

                } else {
                    if (toppingMap.get(cheeseChoice) == null){
                        System.out.println("Invalid Selection. Please Try Again.");
                        continue;
                    }
                    Topping cheeseTopping = toppingMap.get(cheeseChoice);
                    toppingsForTacoArrayList.add(cheeseTopping);
                }

            } else if (toppingChoice == 3) {
                int regularToppingChoice = 0;
                System.out.println(" ");
                System.out.println("Choose Regular Toppings");
                System.out.println("0) Done Adding") ;
                toppingMap = toppingMenuHelper(Topping.regularToppingsList());
                regularToppingChoice = Integer.parseInt(this.scanner.nextLine());
                if (regularToppingChoice == 0){

                } else {
                    if (toppingMap.get(regularToppingChoice) == null){
                        System.out.println("Invalid Selection. Please Try Again.");
                        continue;
                    }
                    Topping regularTopping = toppingMap.get(regularToppingChoice);
                    toppingsForTacoArrayList.add(regularTopping);
                }


            } else if (toppingChoice == 4) {
                int sauceChoice = 0;
                System.out.println(" ");
                System.out.println("Choose Sauces");
                System.out.println("0) Done Adding") ;
                toppingMap = toppingMenuHelper(Topping.sauceToppingsList());
                sauceChoice = Integer.parseInt(this.scanner.nextLine());
                if (sauceChoice == 0){

                } else {
                    if (toppingMap.get(sauceChoice) == null){
                        System.out.println("Invalid Selection. Please Try Again.");
                        continue;
                    }
                    Topping sauceTopping = toppingMap.get(sauceChoice);
                    toppingsForTacoArrayList.add(sauceTopping);
                }

            } else {
                System.out.println("Try again. PLease select a valid entry.");
                toppingChoice = 0;
            }
        } while (true);

        if (this.tacoBurrito.getPlateType().contains("Taco")){
            addDeepFriedToTaco();
        } else {
            this.tacoBurrito.setDeepFried(false);
            System.out.println(" ");
            System.out.println();
            System.out.println("Burrito Added");
            System.out.println(this.tacoBurrito.toString());
            System.out.println(" ");
            this.order.addTacoBurrito(this.tacoBurrito);
        }
    }

    private ArrayList<Topping> addExtraToppings(ArrayList<Topping> toppingsForTacoArrayList, HashMap<Integer,Topping> toppingMap) {
        int extraToppingChoice = 0;

        do {
            System.out.printf("""
                    
                    Choose Toppings
                    0) Done Adding
                    1) Meat
                    2) Cheese
                    3) Regular Toppings
                    4) Sauces
                    """);
            if (extraToppingChoice == 0){
                break;
            }
            if (extraToppingChoice == 1){
                int meatChoice = 0;
                System.out.println(" ");
                System.out.println("Choose Meat Toppings");
                System.out.println("0) Done Adding");
                // Hashmap = Class.Method(Class.Method)
                // Inserting meatToppingList into toppingMenuHelper.
                // toppingMenuHelper fills out the topping map hash map and displays it to the user
                toppingMap = toppingMenuHelper(Topping.meatToppingsList(true));
                meatChoice = Integer.parseInt(this.scanner.nextLine());
                if (meatChoice == 0){
                    // taken to toppings general menu
                } else {
                    if (toppingMap.get(meatChoice) == null){
                        System.out.println("Invalid Selection. Please Try Again.");
                        // Goes back to the beginning of the loop
                        continue;
                    }
                    // Gets topping info (name and price)
                    Topping meatTopping = toppingMap.get(meatChoice);
                    // Adds meat topping to topppingsForTacoArrayList
                    toppingsForTacoArrayList.add(meatTopping);
                }

            } else if (extraToppingChoice == 2) {
                int cheeseChoice = 0;
                System.out.println(" ");
                System.out.println("Choose Cheese Toppings");
                System.out.println("0) Done Adding") ;
                // Creating and displaying toppings
                toppingMap = toppingMenuHelper(Topping.cheeseToppingsList(true));
                cheeseChoice = Integer.parseInt(this.scanner.nextLine());
                if (cheeseChoice == 0){

                } else {
                    if (toppingMap.get(cheeseChoice) == null){
                        System.out.println("Invalid Selection. Please Try Again.");
                        continue;
                    }
                    Topping cheeseTopping = toppingMap.get(cheeseChoice);
                    toppingsForTacoArrayList.add(cheeseTopping);
                }

            } else if (extraToppingChoice == 3) {
                int regularToppingChoice = 0;
                System.out.println(" ");
                System.out.println("Choose Regular Toppings");
                System.out.println("0) Done Adding") ;
                toppingMap = toppingMenuHelper(Topping.regularToppingsList());
                regularToppingChoice = Integer.parseInt(this.scanner.nextLine());
                if (regularToppingChoice == 0){

                } else {
                    if (toppingMap.get(regularToppingChoice) == null){
                        System.out.println("Invalid Selection. Please Try Again.");
                        continue;
                    }
                    Topping regularTopping = toppingMap.get(regularToppingChoice);
                    toppingsForTacoArrayList.add(regularTopping);
                }


            } else if (extraToppingChoice == 4) {
                int sauceChoice = 0;
                System.out.println(" ");
                System.out.println("Choose Sauces");
                System.out.println("0) Done Adding") ;
                toppingMap = toppingMenuHelper(Topping.sauceToppingsList());
                sauceChoice = Integer.parseInt(this.scanner.nextLine());
                if (sauceChoice == 0){

                } else {
                    if (toppingMap.get(sauceChoice) == null){
                        System.out.println("Invalid Selection. Please Try Again.");
                        continue;
                    }
                    Topping sauceTopping = toppingMap.get(sauceChoice);
                    toppingsForTacoArrayList.add(sauceTopping);
                }

            } else {
                System.out.println("Try again. PLease select a valid entry.");
                extraToppingChoice = 0;
            }

        } while (true);
        return toppingsForTacoArrayList;
    }

    private void addDeepFriedToTaco() {
        int deepFriedChoice = 0;
        do {
            System.out.println("""
                
                Would you like your taco deep fried?
                1) Yes
                2) No
                """);
            deepFriedChoice = Integer.parseInt(this.scanner.nextLine());

            if (deepFriedChoice == 1){
                this.tacoBurrito.setDeepFried(true);
            } else if (deepFriedChoice == 2){
                this.tacoBurrito.setDeepFried(false);
            } else {
                System.out.println("Invalid Entry. Please try again.");
                deepFriedChoice = 0;
            }
        } while (deepFriedChoice == 0);

        this.order.addTacoBurrito(this.tacoBurrito);
        System.out.println("Taco Added: ");
        System.out.println(this.tacoBurrito);
    }

    // THIS HASHMAP STARTS EMPTY AND THIS METHOD FILLS IT OUT ACCORDING TO THE USERINPUT
    // HashMap has two sections: Integer and Topping (Key and Value) named toppingMenuHelper
    // The parameter is ONE of the arraylists in the topping class
    public HashMap<Integer, Topping> toppingMenuHelper(ArrayList<Topping> selectedToppingList){
        // New hash map with NULL integers and Toppings named toppingMap
        HashMap<Integer,Topping > toppingMap = new HashMap<>();
        int index = 1;

        // For each topping in toppingList
        for (Topping topping : selectedToppingList){
            // The if statement handles the pricing of the topping according to teh plate chosen
            if (this.tacoBurrito.getPlateType().equalsIgnoreCase("Single Taco")){
                // Topping price for taco is already set
            } else if (this.tacoBurrito.getPlateType().equalsIgnoreCase("Three Taco Plate")) {
                topping.setPrice(topping.getPrice() * 2);
            } else if (this.tacoBurrito.getPlateType().equalsIgnoreCase("Burrito")) {
                topping.setPrice(topping.getPrice() * 3);
            }
            // The toString method displays the topping name and the price
            System.out.println(index + ") " + topping.toString());
            // Sets each index to a topping as a key and a value
            toppingMap.put(index, topping);
            index ++;
        }
        return toppingMap;
    }
}
