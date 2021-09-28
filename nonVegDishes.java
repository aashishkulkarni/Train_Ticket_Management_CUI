package train_ticket;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Aashish Kulkarni
 */
public class nonVegDishes {

    Scanner scan = new Scanner(System.in);

    private String foodItem;

    public void eat() {
        String diet = null;

        List<String> NonVeglist = new ArrayList<>();          //List stores complimentary Non-vegetarian food items 
        NonVeglist.add("Chicken Pizza");
        NonVeglist.add("Chicken Pasta");
        NonVeglist.add("Tuna Sushi");
        NonVeglist.add("Prawns");

        boolean boolFood = false;                 //ensures user inputs appropriate values

        while (!boolFood) {

            System.out.println(NonVeglist.toString());                //display values in list to users
            System.out.println("");
            System.out.println("Please choose your prefferred food item: ");

            try {
                diet = scan.nextLine();

                if (NonVeglist.contains(diet)) {

                    this.setFoodItem(diet);                     //If the inputted food item is available, then food item is confirmed

                    boolFood = true;

                } else {

                    throw new InputMismatchException();         //if inputted food item is not available, then error is thrown and user is requested to give input again
                }
            } catch (InputMismatchException e) {
                System.err.println(e);
                System.out.println("Invalid input... Please try again....");   //error message for incorrect input
                System.out.println("");
            }
        }

    }

    @Override
    public String toString() {
        return "Non-Veg Dish {" + " Food Item = " + this.getFoodItem() + " }";
    }

    public String getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(String foodItem) {
        this.foodItem = foodItem;
    }

}
