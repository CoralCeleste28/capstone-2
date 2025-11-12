import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class UserInterface {

    Scanner scanner = new Scanner(System.in);
    Order order = new Order();
    TacoBurrito tacoBurrito = new TacoBurrito();

    public void runApp(){
        homeScreen();
    }

    private void closeApp() {
        System.out.println("Thank you for vising Chiqui's Near Me");
        scanner.close();
    }

    public void homeScreen (){
        int homescreenSelection = 0;

        do {
            System.out.printf("""
                Welcome to Chiqui's Tacos Near Me!
                Press 1 to place an order
                Press 2 to exit
                """);

            homescreenSelection = Integer.parseInt(this.scanner.nextLine());

            if (homescreenSelection == 1){
                placeAnOrder();
            } else if (homescreenSelection == 2) {
                closeApp();
            } else {
                System.out.println("Try again. PLease select a valid entry.");
                homescreenSelection = 0;
            }

        } while (homescreenSelection == 0);
    }

    private void placeAnOrder(){
        int placeAnOrderSelection = 0;

        do {
            System.out.println("""
                Please choose from the following:
                1 - Burrito
                2 - Single Taco
                3 - Three Taco Plate
                """);

            placeAnOrderSelection = Integer.parseInt(this.scanner.nextLine());

            if (placeAnOrderSelection == 1){
                this.tacoBurrito.setPlateType("Burrito");
                shellTypeForTaco(true);
            } else if (placeAnOrderSelection == 2) {
                this.tacoBurrito.setPlateType("Single Taco");
                shellTypeForTaco(false);
            } else if (placeAnOrderSelection == 3) {
                this.tacoBurrito.setPlateType("Three Taco Plate");
                shellTypeForTaco(false);
            } else {
                System.out.println("Try again. PLease select a valid entry.");
                placeAnOrderSelection = 0;
            }
        } while (placeAnOrderSelection == 0);
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
                1 - Corn
                2 - Flour
                3 - Hard Shell
                """);

    }

    private void printBurritoTortillaOptions(){
        System.out.println("""
               Choose tortilla type:
               1 - Corn
               2 - Flour
               3 - Bowl
               """);
    }
    private void addToppingsToTaco(){
        HashMap<Integer, Topping> toppingMap = new HashMap<>();
        ArrayList<Topping> toppingsForTaco = new ArrayList<>();

        int toppingChoice = 5;

        do {
            System.out.printf("""
                    Choose Toppings
                    0 - Done Adding
                    1 - Meat
                    2 - Cheese
                    3 - Regular Toppings
                    4 - Sauces
                    """);

            toppingChoice = Integer.parseInt(this.scanner.nextLine());

            if (toppingChoice == 0){
                this.tacoBurrito.setTopping(toppingsForTaco);
                break;
            }

            if (toppingChoice == 1){
                int meatChoice = 0;
                System.out.println("Choose Meat Toppings");
                System.out.println("0 - Done Adding");
                // Hashmap = Class.Method(Class.Method)
                toppingMap = Topping.toppingMenuHelper(Topping.meatToppingsList());
                meatChoice = Integer.parseInt(this.scanner.nextLine());
                if (meatChoice == 0){
                    // taken to toppings general menu
                } else {
                   Topping meatTopping = toppingMap.get(meatChoice);
                   toppingsForTaco.add(meatTopping);
                }

            } else if (toppingChoice == 2) {
                int cheeseChoice = 0;
                System.out.println("Choose Cheese Toppings");
                System.out.println("0 - Done Adding") ;
                // Creating and displaying toppings
                toppingMap = Topping.toppingMenuHelper(Topping.cheeseToppingsList());
                cheeseChoice = Integer.parseInt(this.scanner.nextLine());
                if (cheeseChoice == 0){

                } else {
                    Topping cheeseTopping = toppingMap.get(cheeseChoice);
                    toppingsForTaco.add(cheeseTopping);
                }

            } else if (toppingChoice == 3) {
                int regularToppingChoice = 0;
                System.out.println("Choose Regular Toppings");
                System.out.println("0 - Done Adding") ;
                toppingMap = Topping.toppingMenuHelper(Topping.regularToppingsList());
                regularToppingChoice = Integer.parseInt(this.scanner.nextLine());
                if (regularToppingChoice == 0){

                } else {
                    Topping regularTopping = toppingMap.get(regularToppingChoice);
                    toppingsForTaco.add(regularTopping);
                }


            } else if (toppingChoice == 4) {
                int sauceChoice = 0;
                System.out.println("Choose Sauces");
                System.out.println("0 - Done Adding") ;
                toppingMap = Topping.toppingMenuHelper(Topping.sauceToppingsList());
                sauceChoice = Integer.parseInt(this.scanner.nextLine());
                if (sauceChoice == 0){

                } else {
                    Topping sauceTopping = toppingMap.get(sauceChoice);
                    toppingsForTaco.add(sauceTopping);
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
            this.order.addTacoBurrito(this.tacoBurrito);
        }
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
        System.out.println("""
                Taco Add
                """);
    }
}
