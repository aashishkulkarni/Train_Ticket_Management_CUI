package train_ticket;

import java.util.*;

/**
 *
 * @author Aashish Kulkarni
 */
public class importantPassengerNote {

    private String passengerNote;                   //Stores the note given by passenger

    Scanner scan = new Scanner(System.in);

    public importantPassengerNote() {
        this.passengerNote = passengerNote;
    }

    public void impNote() {

        System.out.println("");
        System.out.println("Please enter you note below: ");

        this.setIm(scan.nextLine());                           //passenger is requested to give their input here

    }

    @Override
    public String toString() {                                      //Input entered by passengers is printed 
        return "Note from Passenger : \n\n" + this.getIm();
    }
                                                                        //Getters and Setter are also included

    public String getIm() {
        return passengerNote;
    }

    public void setIm(String passengerNote) {
        this.passengerNote = passengerNote;
    }

}
