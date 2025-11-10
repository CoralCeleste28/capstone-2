public class UserInterface {

    public void homeScreen (){
        System.out.printf("""
                Welcome to Chiqui's Tacos Near Me!
                Press 1 to place an order
                Press 2 to exit
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
