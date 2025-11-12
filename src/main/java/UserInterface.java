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
                tacoBurrito.setPlateType("Burrito");
                shellTypeForTaco(true);
            } else if (placeAnOrderSelection == 2) {
                tacoBurrito.setPlateType("Single Taco");
                shellTypeForTaco(false);
            } else if (placeAnOrderSelection == 3) {
                tacoBurrito.setPlateType("Three Taco Plate");
                shellTypeForTaco(false);
            } else {
                System.out.println("Try again. PLease select a valid entry.");
                placeAnOrderSelection = 0;
            }
        } while (placeAnOrderSelection == 0);
    }

    private void shellTypeForTaco(boolean isBurrito){
        int shellTypeForTacoChoice = 0;

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
            this.tacoBurrito.setShellType("Hard Shell");
            if (isBurrito == true) {
                this.tacoBurrito.setShellType("Bowl");
            }
        } else {
            System.out.println("Try again. PLease select a valid entry.");
            shellTypeForTacoChoice = 0;
        }
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

    private void meats(){
        System.out.println("""
                Choose meat: 
                1 - Carne Asada
                2 - Al Pastor
                3 - Carnitas
                4 - Pollo
                5 - Chorizo
                6 - Pescado 
                """);
    }

    private void toppings(){
        System.out.printf("""
         Choose Toppings
         1 - Queso Fresco
         2 - Oaxaca
         3 - Cotija
         4 - Cheddar
         
         
         """);
    }

    public void orderScreen(){
    System.out.printf("""
                Please choose from the following:
                1 - Add Taco
                2 - Add Drink
                3 - Add Chips and Salsa
                4 - Check Out
                0 - Cancel Order
                """);
    }

    public void checkOut(){
        System.out.printf("""
                Please choose from the following:
                1 - Confirm Order
                0 - Cancel Order
                """);
    }


}
