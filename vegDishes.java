package train_ticket;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.*;

/**
 *
 * @author Aashish Kulkarni
 */
public class vegDishes {

    private String foodItem;

    Scanner scan = new Scanner(System.in);

    public void eat() {
        String diet = null;

        List<String> vegList = new ArrayList<>();               //List stores complimentary Non-vegetarian food items 
        vegList.add("Cheese Pizza");
        vegList.add("Vegan Pasta");
        vegList.add("Garlic Bread");
        vegList.add("Pretzels");

        boolean boolFood = false;                                //ensures user inputs appropriate values

        while (!boolFood) {

            System.out.println(vegList.toString());           //display values in list to users
            System.out.println("");
            System.out.println("Please choose your prefferred food item: ");

            try {
                diet = scan.nextLine();

                if (vegList.contains(diet)) {

                    this.setFoodItem(diet);                  //If the inputted food item is available, then food item is confirmed
                    System.out.println("yes");
                    boolFood = true;

                } else {
                    System.out.println("no");
                    throw new InputMismatchException();         //if inputted food item is not available, then error is thrown and user is requested to give input again
                }
            } catch (InputMismatchException e) {
                System.err.println(e);
                System.out.println("Invalid input... Please try again....");        //error message for incorrect input
                System.out.println("");
            }
        }

    }

    @Override
    public String toString() {                                                  //returns the food item confirmed by passenger
        return "VegDish {" + " Food Item = " + this.getFoodItem() + " }";
    }

    public String getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(String foodItem) {
        this.foodItem = foodItem;
    }

}
