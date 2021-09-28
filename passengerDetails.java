package train_ticket;

/**
 *
 * @author Aashish Kulkarni
 */
import java.util.*;

public class passengerDetails {
                                                         //Basic passenger information is required while booking tickets, variables here store passenger details

    protected String passengerFirstName;
    protected String passengerLastName;
    protected int passengerAge;
    protected String passengerGender;
    protected String passengerCitizenship;

    public passengerDetails() {
        this.passengerFirstName = passengerFirstName;
        this.passengerAge = passengerAge;
        this.passengerGender = passengerGender;
        this.passengerCitizenship = passengerCitizenship;

        this.passengerLastName = passengerLastName;
    }

                                                         //Getters and Setters are also implemented
    public String getPassengerLastName() {
        return passengerLastName;
    }

    public void setPassengerLastName(String passengerLastName) {
        this.passengerLastName = passengerLastName;
    }

    public String getPassengerFirstName() {
        return passengerFirstName;
    }

    public void setPassengerFirstName(String passengerFirstName) {
        this.passengerFirstName = passengerFirstName;
    }

    public int getPassengerAge() {
        return passengerAge;
    }

    public void setPassengerAge(int passengerAge) {
        this.passengerAge = passengerAge;
    }

    public String getPassengerGender() {
        return passengerGender;
    }

    public void setPassengerGender(String passengerGender) {
        this.passengerGender = passengerGender;
    }

    public String getPassengerCitizenship() {
        return passengerCitizenship;
    }

    public void setPassengerCitizenship(String passengerCitizenship) {
        this.passengerCitizenship = passengerCitizenship;
    }

}
