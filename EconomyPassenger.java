import java.util.*;

public class EconomyPassenger extends Passengers{
    private int classIndex;
    private int id = 3;

    public EconomyPassenger () {
        super("john doe", "asian non-veg", 2);
        this.classIndex = 2;
    }
    
    public EconomyPassenger (String name, String meal) {
        super(name, meal, 2);
        this.classIndex = 2;
    }

    public int getID() {return id;}

    public void randomizeMeal() {
        int randInd = (int) (Math.random() * mealOptions.length);
        this.setMeal(mealOptions[randInd]);
        System.out.println("New meal: " + mealOptions[randInd]);
    }

    public String toString() {
        return (super.toString() + "(economy)");
    }

    public boolean equals(Passengers p) {
        return (
            (this.toString().equals(p.toString())) && (this.getMeal().equals(p.getMeal()))
        );
    }

    public void toggleLimo() {
        System.out.println("Error: Economy does not provide limo services");
    }

    public void toggleDND() {
        System.out.println("Error: Economy does not provide limo services");
    }
}