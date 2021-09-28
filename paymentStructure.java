package train_ticket;

/**
 *
 * @author Aashish Kulkarni
 */
import java.util.*;

public class paymentStructure implements methodTypes {

    private int membershipCost;     //to define cost of membership
    private int networkCost;        // to find the train network used by customer
    private int totalTickets;       //total number of tickets booked
    private int sumTotal;           // total cost
    private int citizenshipCost;    //cost for non-NZ citizens 

    passengerDetails pd = new passengerDetails(); //Use this to inter-link with the variables

    trainNetwork tn = new trainNetwork();

    public paymentStructure() {
        this.membershipCost = membershipCost;
        this.networkCost = networkCost;
        this.totalTickets = totalTickets;
        this.citizenshipCost = citizenshipCost;
        this.sumTotal = sumTotal;

    }
                                                                 //Enum values required to set membership cost based on age
    NorthTicketPrices n1 = NorthTicketPrices.Infant;
    SouthTicketPrices s1 = SouthTicketPrices.Infant;

    NorthTicketPrices n2 = NorthTicketPrices.Child;
    SouthTicketPrices s2 = SouthTicketPrices.Child;

    NorthTicketPrices n3 = NorthTicketPrices.Adult;
    SouthTicketPrices s3 = SouthTicketPrices.Adult;

    NorthTicketPrices n4 = NorthTicketPrices.Senior;
    SouthTicketPrices s4 = SouthTicketPrices.Senior;

    public void Membership(int age) {

        if (age >= 65) {
            this.setMembershipCost(100);
        } else if (age <= 64 && age >= 16) {
            this.setMembershipCost(150);
        } else if (age <= 15 && age >= 6) {
            this.setMembershipCost(70);
        } else if (age <= 5 && age >= 0) {
            this.setMembershipCost(30);
        }

    }

    @Override
    public void citizenshipStatus(String stat) {         // Passengers who don't hold New Zealand Citizenship are required to pay extra

        if (stat.equals("New Zealand")) {

            this.setcitizenshipCost(0);

        } else {
            this.setcitizenshipCost(150);
        }

    }

    /**
     * All the costs are added up in 'TotalCost()' method, they are then stored
     * in 'sumTotal'.
     */
    @Override
    public void TotalCost() {

        this.sumTotal = sumTotal + this.getMembershipCost() + this.getNetworkCost() + this.getcitizenshipCost();

        this.setSumTotal(this.sumTotal);
        System.out.println("");

    }

    @Override
    public String toString() {                                             //Total sum cost is printed using 'toString()' method
        return "Total Sum Cost: " + "$ " + this.getSumTotal() + "/-";
    }

    public int getMembershipCost() {
        return membershipCost;
    }

    public void setMembershipCost(int membershipCost) {
        this.membershipCost = membershipCost;
    }

    public int getNetworkCost() {
        return networkCost;
    }

    public void setNetworkCost(int networkCost) {
        this.networkCost = networkCost;
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public int getSumTotal() {
        return sumTotal;
    }

    public void setSumTotal(int sumTotal) {
        this.sumTotal = sumTotal;
    }

    public int getcitizenshipCost() {
        return citizenshipCost;
    }

    public void setcitizenshipCost(int citizenshipCost) {
        this.citizenshipCost = citizenshipCost;
    }

}
