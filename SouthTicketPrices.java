package train_ticket;

/**
 *
 * @author Aashish Kulkarni
 */
public enum SouthTicketPrices {

    //Enum class to keep values of South Ticket Prices
    Infant(25), Child(55), Adult(95), Senior(75);

    public int price;

    SouthTicketPrices(int i) {

        price = i;
    }

}
