import java.util.*;

public class BusinessPassenger extends Passengers{
    private String dessert;
    private int classIndex;
    private boolean doNotDisturb;
    private int id = 2;

    public BusinessPassenger () {
        super("john doe", "asian non-veg", 1);
        this.dessert = "none";
        this.classIndex = 1;
    }
    
    public BusinessPassenger (String name, String meal, String dessert) {
        super(name, meal, 1);
        this.classIndex = 1;
        this.dessert = dessert;
        this.doNotDisturb = false;
    }

    //get methods
    public String getDessert() {return dessert;}
    public int getID() {return id;}

    public void randomizeMeal() {
        int randInd = (int) (Math.random() * mealOptions.length);
        this.setMeal(mealOptions[randInd]);
        System.out.println("New meal: " + mealOptions[randInd]);
        randInd = (int) (Math.random() * dessertOptions.length);
        dessert = dessertOptions[randInd];
        System.out.println("New dessert: " + dessert);
    }

    public String toString() {
        return (super.toString() + "(business)");
    }

    public boolean equals(Passengers p) {
        return (
            (this.toString().equals(p.toString())) && (this.getMeal().equals(p.getMeal()))
        );
    }

    public void toggleLimo() {
        System.out.println("Error: Business does not provide limo services");
    }

    public void toggleDND() {
        if (doNotDisturb) {
            doNotDisturb = false;
            System.out.println("DND is now OFF for " + this.getName());
        }
        else {doNotDisturb = true; System.out.println("DND is now ON for " + this.getName());}
    }
}