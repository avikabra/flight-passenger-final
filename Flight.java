import java.util.*;

public class Flight{
    private Passengers[][] seats;
    private String departureTime;
    private String arrivalTime;
    private String origin;
    private String destination;

    public Flight() {
        this.departureTime = "0000";
        this.origin = "Singapore";
        this.arrivalTime = "0000";
        this.destination = "Singapore";
        
        Passengers[][] temp = new Passengers[3][];
        
        Passengers[] first = new Passengers[2];
        Passengers[] business = new Passengers[5];
        Passengers[] economy = new Passengers[10];

        temp[0] = first;
        temp[1] = business;
        temp[2] = economy;

        this.seats = temp;
    }

    public Flight(String origin, String destination, String departureTime, String arrivalTime) {
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.origin = origin;
        this.destination = destination;

        Passengers[][] temp = new Passengers[3][];
        
        Passengers[] first = new Passengers[2];
        Passengers[] business = new Passengers[5];
        Passengers[] economy = new Passengers[10];

        temp[0] = first;
        temp[1] = business;
        temp[2] = economy;

        this.seats = temp;
    }

    //get methods
    public String getDeparture() {return departureTime;}
    public String getArrival() {return arrivalTime;}
    public String getDestination() {return destination;}
    public Passengers[][] getSeats() {return seats;}

    //set methods
    public void setSeat(Passengers p, int classIndex, int seat) {
        seats[classIndex][seat] = p;
    }

    public String toString() {
        String returnS = "";
        for (int j=0; j<seats.length; j++) {
            returnS += ("Class " + (j+1) + ": [ ");
            for (int i = 0; i <seats[j].length; i++) {
                if (seats[j][i] != null) {
                    returnS += (seats[j][i].toString());
                }
                else {
                    returnS += ("EMPTY");
                }
                if (i != seats[j].length-1) returnS += (", ");
            }
            returnS += (" ]\n");
        }
        return returnS;
    }

    /*
    public void shiftDepartureTime(String d) {
        String FT = flightTime();
        String[] dtA = d.split("(?<=\\G.{2})");
        int dt = Integer.parseInt(dtA[0]) * 60 + Integer.parseInt(dtA[1]);
        String[] ftA = FT.split("(?<=\\G.{2})");
        int ft = Integer.parseInt(ftA[0]) * 60 + Integer.parseInt(ftA[1]);

        int at = dt + ft;
        if (ft >= 1440) {ft -= 1440;}

        int hours = at / 60;
        int min = at % 60;
        String[] hoursA = ("" + hours).split("(?<=\\G.{1})");
        String art = "";
        if (hoursA.length == 1) {
            art += 0 + hoursA[0];
        }
        else {
            art += hoursA[0] + hoursA[1];
        }
        String[] minA = ("" + min).split("(?<=\\G.{1})");
        if (minA.length == 1) {
            art += 0 + minA[0];
        }
        else {
            art += minA[0] + minA[1];
        }

        departureTime = d;
        arrivalTime = art;
        System.out.println("New departure time: " + departureTime);
        System.out.println("New arrival time: " + arrivalTime);

    }*/

}