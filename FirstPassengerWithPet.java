import java.util.*;

public class FirstPassengerWithPet extends FirstPassenger{
    private String species;
    private int classIndex = 1;
    private int id = 4;

    public FirstPassengerWithPet () {
        super("john doe", "asian non-veg", "none", "none");
        super.setPetName("unnamed");
        this.species = "unknown";
    }
    
    public FirstPassengerWithPet (String name, String meal, String dessert, String drink, String petName, String species) {
        super();
        super.setPetName(petName);
        this.species = species;
    }

    //get methods
    public String getSpecies() {return species;}
    public int getClassIndex() {return super.getClassIndex();}
    public int getID() {return id;}

    public String toString() {
        return (super.toString() + " with a " + species + " pet");
    }

    public void toggleLimo() {
        String[] acceptableSpeciesInLimo = {"dog", "cat", "turtle", "hamster"};
        boolean accSpecies = false;
        for (String s : acceptableSpeciesInLimo) {
            if (species.equals(s)) accSpecies = true;
        }
        if (accSpecies) {
            super.toggleLimo();
        } else {
            System.out.println("Your pet is not of an acceptable species. Apologies");
        }
    }

    public boolean checkAdjacentPets (Flight f) {
        Passengers[][] seats = f.getSeats();
        int seatNo = super.getSeatNo();
        this.classIndex = getClassIndex();
        if (seatNo == 0) {
            if (seats[this.classIndex][1] == null) return false;
            return (seats[this.classIndex][1].getID() == 4);
        } else if (seatNo == seats[this.classIndex].length - 1) {
            if (seats[this.classIndex][
                seats[this.classIndex].length - 2] == null) return false;
            return (seats[this.classIndex][
                seats[this.classIndex].length - 2
            ].getID() == 4);
        } else {
            if (seats[this.classIndex][seatNo + 1] == null) {
                if (seats[this.classIndex][seatNo - 1] == null) {
                    return false;
                } else {
                    return (seats[this.classIndex][seatNo - 1].getID() == 4);
                }
            } else if (seats[this.classIndex][seatNo - 1] == null) {
                return (seats[this.classIndex][seatNo + 1].getID() == 4);
            } else {
                return (
                    seats[this.classIndex][seatNo + 1].getID() == 4 ||
                    seats[this.classIndex][seatNo - 1].getID() == 4
                );
            }
        }
    }

    public String createNewSpecies() {
        String[] alphabet = "abcdefghijklmnopqrstuvwxyz".split("(?<=\\G.{1})");
        Scanner scan = new Scanner(System.in);
        System.out.println("How many letters do you want your species to have?");
        int n = scan.nextInt();
        String returnS = "";
        int randInd;
        for (int i = 0; i < n; i++) {
            randInd = (int) (Math.random() * alphabet.length);
            returnS += alphabet[randInd];
        }
        species = returnS;
        return returnS;
    }

}
