package train_ticket;
/**
 *
 * @author Aashish Kulkarni 
 * Student ID: 19091215 
 * Group ID: 35 
 * Project Name: Ticket Booking System for Trains
 */
import java.util.*;
import java.io.*;
import java.io.FileReader;

public class TrainTicket_main {

    public static void main(String[] args) throws InputMismatchException, IllegalStateException, NoSuchElementException, IOException {

        /*
        
        Introducing ticket values from enum class so that prices can be displayed for the customers
        
        Ticket prices for both Northern Express and Southern Express are mentioned 
         */
        NorthTicketPrices n1 = NorthTicketPrices.Infant;
        SouthTicketPrices s1 = SouthTicketPrices.Infant;

        NorthTicketPrices n2 = NorthTicketPrices.Child;
        SouthTicketPrices s2 = SouthTicketPrices.Child;

        NorthTicketPrices n3 = NorthTicketPrices.Adult;
        SouthTicketPrices s3 = SouthTicketPrices.Adult;

        NorthTicketPrices n4 = NorthTicketPrices.Senior;
        SouthTicketPrices s4 = SouthTicketPrices.Senior;

        Scanner scan = new Scanner(System.in);

        passengerDetails pd = new passengerDetails();

        contactDetails md = new medicalDetails();  //medicalDetails is a child-class of contactDetails

        paymentStructure ps = new paymentStructure();

        trainNetwork tn = new trainNetwork();

        System.out.println("");

        /**
         * Using File reader to print out a brief introduction of the train
         * booking system
         */
        File railIntrofile = new File("railIntroReader.txt");

        BufferedReader bReader = new BufferedReader(new FileReader(railIntrofile)); //printing the intro for RailNetwork NZ

        String string;
        while ((string = bReader.readLine()) != null) {
            System.out.println(string);
        }

        /*
            Printing out costs of tickets below for both Northern and Southern Express
         */
        System.out.println("Ticket costs for Northern Express:- ");
        System.out.println("Infant = $" + n1.price);
        System.out.println("Child  = $" + n2.price);
        System.out.println("Adult  = $" + n3.price);
        System.out.println("Senior = $" + n4.price);
        System.out.println("");
        System.out.println("Ticket costs for Southern Express:- ");
        System.out.println("Infant = $" + s1.price);
        System.out.println("Child  = $" + s2.price);
        System.out.println("Adult  = $" + s3.price);
        System.out.println("Senior = $" + s4.price);
        System.out.println("");

        int tempnet = 0; //variable takes temporary input for train network
        boolean netstat = false; // to ensure appropriate train network is selected

        while (!netstat) {

            try {
                System.out.println("");
                System.out.println("Choose train network for your travel: ");
                System.out.println("1. Northern Express");
                System.out.println("2. Southern Express");

                tempnet = scan.nextInt();

                if (tempnet == 1) {
                    tn.setSelectNetworkNum(tempnet); //after the input is verified, it inputs the appropriate value for the selected network
                    tn.setNetwork("Northern Express");
                    netstat = true;

                } else if (tempnet == 2) {
                    tn.setSelectNetworkNum(tempnet);    //after the input is verified, it inputs the appropriate value for the selected network
                    tn.setNetwork("Southern Express");
                    netstat = true;

                } else if (tempnet > 2) {
                    throw new InputMismatchException("Train doesn't exist..");  // invalid value inputted
                }
            } catch (InputMismatchException e) {
                System.out.println(e);
                System.out.println("Invalid train network input...Please try again.. ");  //message for invalid input

                scan.nextLine();

            }
        }

        System.out.println("");

        boolean depart = false; // to ensure appropriate city is selected
        //Depart City

        while (!depart) {
            try {
                System.out.println("");
                System.out.println("Enter the name of the city you want to depart from:");

                if ((tn.getSelectNetworkNum() == 1)) {
                    String temp;

                    temp = scan.next();

                    if (temp.equals("Auckland") || temp.equals("Wellington") || temp.equals("Tauranga") || temp.equals("Hamilton") || temp.equals("Napier") || temp.equals("Whangerai")) {
                        tn.setDepartCity(temp);  //departing city is confirmed
                        depart = true;
                    } else {
                        throw new InputMismatchException();
                    }
                } else if ((tn.getSelectNetworkNum() == 2)) {
                    String temp;

                    temp = scan.next();

                    if ((temp.equals("Christchurch") || temp.equals("Queenstown") || temp.equals("Dunedin") || temp.equals("Nelson") || temp.equals("Invercargill"))) {
                        tn.setDepartCity(temp);    //departing city is confirmed
                        depart = true;
                    } else {
                        throw new InputMismatchException();
                    }
                }

            } catch (InputMismatchException m) {

                System.out.println("Invalid city Input, please try again..: " + m); //message for invalid input

                scan.nextLine();
            }

        }

        //Arrival city
        boolean arrive = false;   // to ensure appropriate city is selected

        while (!arrive) {
            try {

                System.out.println("");

                System.out.println("Enter the name of the city you want to arrive at:");

                System.out.println("");

                if ((tn.getSelectNetworkNum() == 1)) //Northern Express
                {
                    String temp;

                    temp = scan.next();                              //takes temporary input for arrival city
                    if (!tn.getDepartCity().equals(temp)) {

                        if (temp.equals("Auckland") || temp.equals("Wellington") || temp.equals("Tauranga") || temp.equals("Hamilton") || temp.equals("Napier") || temp.equals("Whangerai")) {

                            tn.setArrivalCity(temp);           //arriving city is confirmed
                            arrive = true;
                        } else {
                            throw new InputMismatchException();
                        }

                    } else if (tn.getDepartCity().equals(temp)) {          // throws error message when users tries to set Arrival and Departing city to the same city

                        throw new InputMismatchException("Error, Arrival city and Depart City cannot be the same... Please enter Arrival City again...");
                    } else {
                        throw new InputMismatchException();
                    }

                } else if ((tn.getSelectNetworkNum() == 2)) // Southern Express
                {
                    String temp;

                    temp = scan.next();                     //takes temporary imput for arrival city
                    if (!tn.getDepartCity().equals(temp)) {

                        if ((temp.equals("Christchurch") || temp.equals("Queenstown") || temp.equals("Dunedin") || temp.equals("Nelson") || temp.equals("Invercargill"))) {

                            tn.setArrivalCity(temp);   //confirms arrival city
                            arrive = true;

                        } else {
                            throw new InputMismatchException();
                        }

                    } else if (tn.getDepartCity().equals(temp)) {      // throws error message when users tries to set Arrival and Departing city to the same city

                        throw new InputMismatchException(" Error, Arrival city and Depart City cannot be the same... Please enter Arrival City again...");
                    }

                } else {
                    throw new InputMismatchException();
                }

            } catch (InputMismatchException m) {
                System.out.println(m);
                System.out.println("Invalid city Input, please try again.. ");
            }

        }

        //Departure Date 
        /*
       Printing ticket booking information for users
       
         */
        File bookingInfoFile = new File("bookingInfoReader.txt");

        BufferedReader bookReader = new BufferedReader(new FileReader(bookingInfoFile));

        String stringBook;
        while ((stringBook = bookReader.readLine()) != null) {
            System.out.println(stringBook);   //printing booking information
        }

        int year = 2022;             //Setting year to 2022 as ticket booking has been cancelled for 2021 due to COVID-19 (mentioned in bookingInfo.txt)

        String mon = "";        //defines month of travel
        boolean boolMon = false;  //ensures that the appropriate month is selected

        while (!boolMon) {
            String tempMon;        //takes temporary input for month of travel

            System.out.println("Which month would you like to travel in? (Example. January, March, May etc.)");
            tempMon = scan.next();
            try {
                if (tempMon.equals("January") || tempMon.equals("january") || tempMon.equals("February") || tempMon.equals("february") || tempMon.equals("March") || tempMon.equals("march")
                        || tempMon.equals("April") || tempMon.equals("april") || tempMon.equals("May") || tempMon.equals("may") || tempMon.equals("June") || tempMon.equals("june")
                        || tempMon.equals("July") || tempMon.equals("july") || tempMon.equals("August") || tempMon.equals("august") || tempMon.equals("September") || tempMon.equals("september")
                        || tempMon.equals("October") || tempMon.equals("october") || tempMon.equals("November") || tempMon.equals("november") || tempMon.equals("December") || tempMon.equals("december")) {

                    mon = tempMon;            //if the value entered by the user is appropriate, then the value is stored in original variable
                    boolMon = true;
                } else {
                    throw new InputMismatchException();
                }

            } catch (InputMismatchException e) {
                System.out.println(e);
                System.out.println("Invalid month input, please try again....\n");       // error statement for invalid input

            }

        }

        System.out.println("");
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println(" PLEASE NOTE: Our luxury trains only run on the 2nd, 10th, 19th and 27th of every month in a year..       ");
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println("");

        boolean boolDate = false;       //ensures that the appropriate date is selected
        String bookingDate = "0";       //original variable for booking date

        while (!boolDate) {
            System.out.println("Please input the date of travel in '" + mon + "' : ");
            String tempDate;              //takes temporary input for date
            tempDate = scan.next();
            try {
                if (tempDate.equals("2") || tempDate.equals("2nd") || tempDate.equals("10") || tempDate.equals("10th") || tempDate.equals("19") || tempDate.equals("19th") || tempDate.equals("27") || tempDate.equals("27th")) {

                    bookingDate = tempDate;          //if given date is appropriate, then the value is stored in original variable
                    boolDate = true;
                } else {

                    throw new InputMismatchException();

                }

            } catch (InputMismatchException e) {
      
                System.out.println("Invalid date input, please try again.... : "+e);     // error statement for invalid input
                System.out.println("");
            }

        }

        System.out.println("Travel date booked for : " + bookingDate + " " + mon + " " + year); //Printing the selected booking date

        boolean boolTick = false;                   //to ensure appropriate value is enteres for tickets
        int setTick;                             //temporary variable takes input for number of tickets

        while (!boolTick) {
            System.out.println("");
            System.out.println("How many tickets do you want to book?");
            try {

                setTick = scan.nextInt();

                if (setTick > 0) {
                    tn.setTotalTickets(setTick);          //number of tickets confirmed
                    boolTick = true;
                } else {
                    throw new InputMismatchException("Number of tickets cannot be zero or less than zero...");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please try again....: " + e);      // error statement for invalid input

                scan.nextLine();

            }
        }

        /*
            
            Introducing PrintWriters to make the passenger tickets  available for
            passengers to view or to take a print out while travelling.
            
            Passenger medical details and food choice of passenger are also
            available for passenger to view or print.
            
            Values inputted from the users are stored in the '.txt' file
            
         */
        PrintWriter ticket = null;
        PrintWriter medicalWrite = null;
        PrintWriter food = null;

        ticket = new PrintWriter(new FileOutputStream("passengerTicketsWriter.txt"));
        medicalWrite = new PrintWriter(new FileOutputStream("medicalWriter.txt"));
        food = new PrintWriter(new FileOutputStream("foodWriter.txt"));
        ticket.print("-----------------" + "\n");
        ticket.print("| RailNetwork NZ |" + "\n");
        ticket.print("-----------------" + "\n");
        ticket.println("");
        ticket.println("Train Network: " + tn.getNetwork() + "\n");
        ticket.println("Departure city: " + tn.getDepartCity() + "\n");
        ticket.println("Arrival city: " + tn.getArrivalCity() + "\n");
        ticket.println("Date of travel: " + bookingDate + " " + mon + " " + year);
        ticket.println("\n");
        ticket.println("Ticket Details: " + "\n");
        ticket.println("_______________" + "\n");
        medicalWrite.println(".......................... Passenger Medical Information ..........................");
        food.println("---------- Food and Beverages ------------");

        for (int i = 0; i < tn.getTotalTickets(); i++) {

            int j = i + 1;
            // taking passenger details which are essential for travelling
            System.out.println("Please enter details for Passenger " + j + " : ");
            ticket.println("\n");
            ticket.println("Passenger " + j + ": \n");
            ticket.println("===========" + "\n");
            //Passenger Name

            System.out.println("");
            System.out.println("First Name: ");
            pd.setPassengerFirstName(scan.next());
            System.out.println("");
            ticket.println("");
            System.out.println("Last Name: ");
            pd.setPassengerLastName(scan.next());

            ticket.println("First Name: " + pd.getPassengerFirstName() + "\n");
            ticket.println("Last Name: " + pd.getPassengerLastName() + "\n");

            medicalWrite.println("First Name: " + pd.getPassengerFirstName() + "\n");
            medicalWrite.println("Last Name: " + pd.getPassengerLastName() + "\n");

            food.println("First Name: " + pd.getPassengerFirstName() + "\n");
            food.println("Last Name: " + pd.getPassengerLastName() + "\n");

            //----------------- Age --------------------
            /*
                Ticket costs are set based on passenger's age.
                
             */
            boolean boolAge = false;                        //ensure appropriate age is entered

            while (!boolAge) {
                System.out.println("");
                System.out.println("Age: ");

                try {

                    pd.setPassengerAge(scan.nextInt());         //passenger age is inputted

                    if (pd.getPassengerAge() >= 0 && pd.getPassengerAge() < 200) {
                        ticket.println("Age: " + pd.getPassengerAge() + "\n");

                        if (pd.getPassengerAge() >= 65) {                   //Passengers equal to and above the age of 65 are in 'Senior' category 

                            if (tn.getNetwork() == "Northern Express") {
                                ps.setNetworkCost(n4.price);
                            } else if (tn.getNetwork() == "Southern Express") {
                                ps.setNetworkCost(s4.price);
                            }

                        } else if (pd.getPassengerAge() <= 64 && pd.getPassengerAge() >= 16) {     //Passengers between the age of 65 and 16 are in 'Adult' category 

                            if (tn.getNetwork() == "Northern Express") {
                                ps.setNetworkCost(n3.price);
                            } else if (tn.getNetwork() == "Southern Express") {
                                ps.setNetworkCost(s3.price);
                            }

                        } else if (pd.getPassengerAge() <= 15 && pd.getPassengerAge() >= 6) {      //Passengers between the age of 15 and 6 are in 'Child' category 

                            if (tn.getNetwork() == "Northern Express") {
                                ps.setNetworkCost(n2.price);
                            } else if (tn.getNetwork() == "Southern Express") {
                                ps.setNetworkCost(s2.price);
                            }

                        } else if (pd.getPassengerAge() <= 5 && pd.getPassengerAge() >= 0) {      //Passengers equal to and below the age of 5 are in 'Infant' category 

                            if (tn.getNetwork() == "Northern Express") {
                                ps.setNetworkCost(n1.price);
                            } else if (tn.getNetwork() == "Southern Express") {
                                ps.setNetworkCost(s1.price);
                            }

                        }

                        boolAge = true;
                    } else {
                        boolAge = false;
                        throw new InputMismatchException();

                    }

                } catch (InputMismatchException e) {
                    System.out.println("Invalid age input...Please try again.. :" + e);
                    scan.nextLine();
                } catch (Exception e) {                                                   // error statement for invalid input
                    System.out.println("Error...Please try again..:" + e);
                    scan.nextLine();
                }

            }

            ps.Membership(pd.getPassengerAge());

            //-------- Gender -----------
            boolean boolGender = false;           //to ensure user enters appropriate input

            while (!boolGender) {

                try {

                    System.out.println("Gender (Male,Female,Other): ");

                    String tempInput;                                   //takes temporary input from user
                    tempInput = scan.next();

                    if (tempInput.equals("Male") || tempInput.equals("male") || tempInput.equals("Female") || tempInput.equals("female") || tempInput.equals("other") || tempInput.equals("Other")) {
                        pd.setPassengerGender(tempInput);               //is the user entered input is appropriate, then the input is accepted
                        boolGender = true;
                    } else {
                        boolGender = false;

                        throw new InputMismatchException();
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid gender input...Please try again.. :" + e);
                } catch (Exception e) {                                                  // error statement for invalid input
                    System.out.println("error...Please try again..:" + e);
                }
            }

            ticket.println("Gender: " + pd.getPassengerGender() + "\n");

            //----------------------------------
            boolean boolNZ = false;                  //to ensure user enters appropriate input
            String nzc;

            while (!boolNZ) {
                System.out.println("Is this passenger a New Zealand citizen? (yes/no) : ");

                try {
                    nzc = scan.next();                       //if user inputs 'yes', then citizenship is set to New Zealand
                    if (nzc.equals("yes")) {
                        pd.setPassengerCitizenship("New Zealand");
                        ps.setcitizenshipCost(0);
                        boolNZ = true;
                    } else if (nzc.equals("no")) {              //if user inputs 'no', then the users is requested to enter their country of citizenhip

                        System.out.println("Please enter passenger's country of citizenship: ");

                        String s;
                        scan.nextLine();
                        s = scan.nextLine();
                        pd.setPassengerCitizenship(s);
                        ps.citizenshipStatus(pd.getPassengerCitizenship());
                        boolNZ = true;
                    } else {
                        throw new InputMismatchException("Please enter either 'yes' or 'no'...");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid citizenship input...Please try again.. :" + e);
                    scan.nextLine();
                } catch (Exception e) {                                                       // error statement for invalid input
                    System.out.println("Error...Please try again..:" + e);
                }
            }

            ticket.println("Citizenship: " + pd.getPassengerCitizenship() + "\n");

            System.out.println("");
            System.out.println("-------------------- Contact Details --------------------");
            System.out.println("");

            System.out.println("Please enter your email ID: ");
            md.setEmailID(scan.next());                                         //user enters email id
            ticket.println("Email ID: " + md.getEmailID() + "\n");

            boolean boolPhone = false;                              //ensures user enters proper input

            while (!boolPhone) {

                System.out.println("Please enter your phone number: ");

                try {
                    md.setPhoneNumber(scan.nextLong());                     //phone number inputted
                    if (md.getPhoneNumber() > 0) {

                        ticket.println("Phone Number: " + md.getPhoneNumber() + "\n");
                        boolPhone = true;
                    } else {
                        throw new InputMismatchException("Please enter appropriate values..");
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Invalid input...Please try again.. :" + e);             //error message for incorrect input
                    scan.nextLine();
                }

            }

            System.out.println("");
            System.out.println("----------------------- Medical Details -----------------------");   //-------> medical details

            System.out.println("To ensure your safety, we shall ask you some questions to keep you safe during travel.");
            System.out.println("");

            md.med1();
            md.med2();
            md.med3();

            medicalWrite.println("" + md.toString());                   //medical details printed in medicalWriter.txt
            medicalWrite.println("________________________________________________________________");
            medicalWrite.println("");

            System.out.println("---------- Food and Beverages ------------");

            String drink = null;

            System.out.println("\nThe items below are complimentary - \n");
            System.out.println("Menu:");

            Set<String> set = new HashSet<String>();            //Set used to storing beverages
            set.add("Coffee");
            set.add("Lemonade");
            set.add("Pepsi");
            set.add("Redbull");
            int z = 0;
            boolean boolDrink = false;

            while (!boolDrink) {

                System.out.println(set.toString());
                System.out.println("");
                System.out.println("Please choose your prefferred beverage: ");

                if (z == 0) {
                    scan.nextLine();                     //To ensure proper spacing after user gives their first input
                    z++;
                }

                try {
                    drink = scan.nextLine();

                    if (set.contains(drink)) {
                                                            //If the user inputs the drink provided in the menu, then accept the input

                        food.println("Beverage: " + drink);
                        boolDrink = true;

                    } else {
                                                                //If user inputs incorrect input, throw exception and ask user to give input again
                        throw new InputMismatchException();
                    }
                } catch (InputMismatchException e) {
                     
                    System.out.println("Invalid beverage input... Please try again.... : "+e);             // error statement for invalid input
                    System.out.println("");
                }
            }

            vegDishes veg = new vegDishes();                 //Vegetarian/Vegan dishes
            nonVegDishes nonVeg = new nonVegDishes();       //Vegetarian/Vegan dishes
            boolean des = false;                           //Ensure user enters proper input
            String desFood;                               //Takes temporary input from user

            while (!des) {
                try {
                    System.out.println("");
                    System.out.println("Would you like to eat Vegetarian/Vegan? (yes or no)");
                    desFood = scan.next();
                    if (desFood.equals("yes")) {                //If inputted food item is there on the menu, then the input is accepted
                        System.out.println("\nThe items below are complimentary - \n");
                        System.out.println("Menu:");
                        veg.eat();
                        food.println(veg.toString());
                        des = true;

                    } else if (desFood.equals("no")) {           //If user inputs incorrect input, throw exception and ask user to give input again
                        nonVeg.eat();
                        food.println(nonVeg.toString());
                        des = true;
                    } else {
                        throw new InputMismatchException();
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid food item input...Please try again... : " + e);    // error statement for invalid input
                }

            }

            food.println("----------------------------------");

            System.out.println("----------------------------------------------------");

            System.out.println(md.toString());

            ps.TotalCost();                                 //Calculates total cost for the passenger
            int temp = ps.getMembershipCost() + ps.getNetworkCost() + ps.getcitizenshipCost();
            System.out.println("Cost for Passenger " + (i + 1) + " : $ " + temp);
            System.out.println("---------------------------------------------------------------------------------\n");
            ticket.println("---------------------------------------------------------------" + "\n");

        }

        importantPassengerNote imn = new importantPassengerNote();
        boolean boolNote = false;                           //Ensure user enters proper input
        String impNot;                               //Takes temporary input from user

        while (!boolNote) {
            try {
                System.out.println("");
                System.out.println("Is there anything important/essential you want the staff at RailNetwork NZ to note about your travel? : (yes/no)");
                impNot = scan.next();
                if (impNot.equals("yes")) {                //If user says 'yes', implement imn.impNote() which takes in input for passengers

                    imn.impNote();
                    ticket.println(imn.toString());
                    boolNote = true;
                    ticket.println("");
                    ticket.println("---------------------------------------------------------------" + "\n");
                } else if (impNot.equals("no")) {           //If user inputs incorrect input, throw exception and ask user to give input again

                    boolNote = true;
                } else {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input...Please try again... : " + e);    // error statement for invalid input
            }

        }

        System.out.println("");
        System.out.println("================= TOTAL TICKET COST ================= ");
        ticket.println("================= TOTAL TICKET COST ================= ");
        ticket.println("Total number of tickets booked: " + tn.getTotalTickets());
        System.out.println("Total number of tickets booked: " + tn.getTotalTickets());

        System.out.println(ps.toString());                  //To print sum total payment to required to be made

        System.out.println("Tickets are ready in 'passengerTicketsWriter.txt' ");
        System.out.println("Medical Information is in 'medicalWriter.txt' ");
        System.out.println("Select Beverages and Food items in 'foodWriter.txt' ");
        ticket.println("" + ps.toString());                  //print payment details in 'passengerTickets.txt'
        ticket.println("");
        ticket.println("Have a safe journey! :)");

        ticket.close();
        medicalWrite.close();                               //close PrintWriters
        food.close();

        File thankYouFile = new File("thankYouReader.txt");
        //PrintReader implemented to thank user for using the booking system

        BufferedReader thankYouReader = new BufferedReader(new FileReader(thankYouFile)); //printing the intro for RailNetwork NZ

        String stringThanks;
        while ((stringThanks = thankYouReader.readLine()) != null) {
            System.out.println(stringThanks);
        }

    }

}
