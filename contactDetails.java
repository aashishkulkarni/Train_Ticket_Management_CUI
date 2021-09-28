/**
 *
 * @author Aashish Kulkarni
 */
package train_ticket;

import java.util.*;

public abstract class contactDetails {          //contactDetails is an abstract class

    private String emailID;
    private long phoneNumber;               //email ID and phone number is required to be entered by passenger

    public contactDetails() {
        this.emailID = emailID;
        this.phoneNumber = phoneNumber;
    }

    public void med1() {
                                             //Methods which are introduced here are utilised in the child-class (medicalDetails.java)
    }

    public void med2() {

    }

    public void med3() {

    }
                                         //Getters and Setters are also implemented here

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
