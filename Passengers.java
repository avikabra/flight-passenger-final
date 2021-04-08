import java.util.*;

public class Passengers extends Flight{
    private String name;
    private String meal;
    private int classIndex;
    private int seatNumber;
    private int id;

    public static String[] mealOptions = {
        "asian veg", "asian non-veg", "european veg", "european non-veg", "gluten-free", "chicken"
    };
    public static String[] drinkOptions = {
        "champagne", "apple juice", "none"
    };
    public static String[] dessertOptions = {
        "ice cream", "cake", "none"
    };

    public Passengers (String name, String meal, int classIndex) {
        this.name = name;
        this.meal = meal;
        this.classIndex = classIndex;
        this.id = classIndex;
    }

    public String toString() {
        return name;
    }

    public boolean equals(Passengers p) {
        return (
            this.toString().equals(p.toString())
        );
    }

    //get methods
    public String getMeal() {return meal;}
    public String getName() {return name;}
    public String getSeat() {return ("Seat no.: " + (classIndex+1) + "-" + seatNumber);}
    public int getSeatNo() {return seatNumber;}
    public int getClassIndex() {return classIndex;}
    public int getID() {return id;}

    //meal set method
    public void setMeal(String m) {
        meal = m;
    }

    public String createNewSpecies() {return "";}
    public boolean checkAdjacentPets(Flight f) {return false;}

    public void randomizeMeal() {
        int randInd = (int) (Math.random() * mealOptions.length);
        meal = mealOptions[randInd];
        System.out.println("New meal: " + meal);
    }

    public void assignSeat(Flight f, int seatNo) {
        Passengers[][] seats = f.getSeats();
        if (seats[classIndex][seatNo] == null) {
            seatNumber = seatNo;
            System.out.println("Seat Found: " + (classIndex+1) + "-" + seatNo);
            f.setSeat(this, classIndex, seatNo);
        } else {
            if (seatNo == seats[classIndex].length - 1) {
                if (classIndex == 2) {
                    System.out.println("No seat found");
                } else {
                    classIndex += 1;
                    seatNo = 0;
                    assignSeat(f, seatNo);
                }
            } else {
                assignSeat(f, seatNo+1);
            }
        }
    }
/*
    public void assignSeat(Flight f) {
        boolean isEmpty = false;
        Passengers[][] seats = f.getSeats();
        for (int i = 0; i < seats[classIndex].length; i++) {
            if (seats[classIndex][i] == null) {
                isEmpty = true;
                seatNumber = i;
                System.out.println("Seat Found: " + (classIndex+1) + "-" + i);
                f.setSeat(this, classIndex, seatNumber);
                break;
            }
        }
        if (!isEmpty) {
            if (classIndex != 2) {
                System.out.println("Class full, finding seat in lower class...");
                classIndex += 1;
                this.assignSeat(f);
            } else {
                System.out.println("No seat found");
            }
        }
    }
*/
    public String getFlightTime(Flight f) {
        String departureTime = f.getDeparture();
        String arrivalTime = f.getArrival();
        String[] dtA = departureTime.split("(?<=\\G.{2})");
        int dt = Integer.parseInt(dtA[0]) * 60 + Integer.parseInt(dtA[1]);
        String[] atA = arrivalTime.split("(?<=\\G.{2})");
        int at = Integer.parseInt(atA[0]) * 60 + Integer.parseInt(atA[1]);
        int ft = at - dt;
        if (ft < 0) {ft = 1440 + ft;}
        int hours = ft / 60;
        int min = ft % 60;
        String[] hoursA = ("" + hours).split("(?<=\\G.{1})");
        String returnS = "";
        if (hoursA.length == 1) {
            returnS += 0 + hoursA[0];
        }
        else {
            returnS += hoursA[0] + hoursA[1];
        }
        String[] minA = ("" + min).split("(?<=\\G.{1})");
        if (minA.length == 1) {
            returnS += 0 + minA[0];
        }
        else {
            returnS += minA[0] + minA[1];
        }
        return returnS;
    }
}