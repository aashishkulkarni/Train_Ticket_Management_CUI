package train_ticket;

/**
 *
 * @author Aashish Kulkarni
 */
import java.util.*;

public class medicalDetails extends contactDetails {   //medicalDetails is a subclass of contactDetails

    private String vaccine;
    private String isolation;
    private String positive;

    public void med1() {                                //This method verifies if the passenger is vaccinated or not

        Scanner scan = new Scanner(System.in);

        boolean boolVac = false;                        //ensures users enter appropriate values

        while (!boolVac) {

            try {

                System.out.println("Are you fully vaccinated for COVID-19? (yes/no)");  //Asking passenger if they are fully vaccinated

                String a;
                a = scan.next();                //temporary variable takes input from user
                if (a.equals("yes")) {
                    this.setVaccine(a);
                    boolVac = true;

                } else if (a.equals("no")) {
                    this.setVaccine(a);
                    boolVac = true;

                } else {
                    throw new InputMismatchException();
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input...Please try again.. :" + e);         //  error message for incorrect input

            }

        }

    }

    public void med2() {

        Scanner scan = new Scanner(System.in);

        boolean boolIso = false;                    //ensures users enter appropriate values

        while (!boolIso) {

            try {

                System.out.println("Were you ever in the managed isolation facility in the last 6 months in New Zealand? (yes/no)");
                                                                   //This method verifies if the passenger was staying in managed isolation in the past or not
                String b;
                b = scan.next();                                //temporary variable takes input from user
                if (b.equals("yes")) {
                    this.setIsolation(b);
                    boolIso = true;

                } else if (b.equals("no")) {
                    this.setIsolation(b);
                    boolIso = true;

                } else {
                    throw new InputMismatchException();
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input...Please try again.. :" + e);      // error message for incorrect input

            }

        }

    }

    public void med3() {

        Scanner scan = new Scanner(System.in);

        boolean boolPos = false;                                        //ensures users enter appropriate values

        while (!boolPos) {

            try {

                System.out.println("Have you ever tested COVID positive in the past? (yes/no)");
                                                        //This method verifies if passenger had tested positive for COVID in the past
                String c;
                c = scan.next();                        //temporary variable takes input from user
                if (c.equals("yes")) {
                    this.setPositive(c);
                    boolPos = true;

                } else if (c.equals("no")) {
                    this.setPositive(c);
                    boolPos = true;

                } else {
                    throw new InputMismatchException();
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input...Please try again.. :" + e);     // error message for incorrect input

            }

        }

    }

    @Override
    public String toString() {              //returns medical information confirmed by passenger
        return "------------ Medical Details ----------\n" + "Fully Vaccinated? : " + this.getVaccine() + "\nManaged Isolation Facility? : " + this.getIsolation() + "\nEver tested COVID positive? : " + this.getPositive() + "\n--------------------------------------\n";
    }

    public String getPositive() {
        return positive;
    }

    public void setPositive(String positive) {
        this.positive = positive;
    }

    public String getVaccine() {
        return vaccine;
    }

    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }

    public String getIsolation() {
        return isolation;
    }

    public void setIsolation(String isolation) {
        this.isolation = isolation;
    }

}
