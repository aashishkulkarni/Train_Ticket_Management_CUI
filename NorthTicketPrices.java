package train_ticket;

/**
 *
 * @author Aashish Kulkarni
 */
public enum NorthTicketPrices {

    Infant(20), Child(40), Adult(80), Senior(60);

    //Enum class to keep values of North Ticket Prices
    public int price;

    NorthTicketPrices(int i) {

        price = i;
    }

}
