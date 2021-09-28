 
package train_ticket;
import java.util.*;
import java.io.*;
/**
 *
 * @author Aashish Kulkarni
 */
public class trainNetwork {
    
        private String network;
        private String departCity;
        private String arrivalCity;
        private int totalTickets=0;
        private int selectNetworkNum=0;

    public trainNetwork() {
        this.network = null;
        this.departCity = departCity;
        this.arrivalCity = arrivalCity;
        this.totalTickets= 0;
        this.selectNetworkNum = 0;
        
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getDepartCity() {
        return departCity;
    }

    public void setDepartCity(String departCity) {
        this.departCity = departCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public int getSelectNetworkNum() {
        return selectNetworkNum;
    }

    public void setSelectNetworkNum(int selectNetwork) {
        this.selectNetworkNum = selectNetwork;
    }
    
    
      
    
    
}
