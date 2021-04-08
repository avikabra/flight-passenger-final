import java.util.*;

public class FirstPassenger extends Passengers{
    private String dessert;
    private String drink;
    private int classIndex;
    private boolean limoPickup;
    private boolean doNotDisturb;
    private int id = 1;
    
    private String petName;

    public FirstPassenger () {
        super("john doe", "asian non-veg", 0);
        this.dessert = "none";
        this.drink = "none";
        this.classIndex = 0;
    }
    
    public FirstPassenger (String name, String meal, String dessert, String drink) {
        super(name, meal, 0);
        this.classIndex = 0;
        this.dessert = dessert;
        this.drink = drink;
        this.limoPickup = false;
        this.doNotDisturb = false;
    }

    //get methods
    public String getDrink() {return drink;}
    public String getDessert() {return dessert;}
    public int getClassIndex() {return super.getClassIndex();}
    public int getID() {return id;}

    //set method
    public void setPetName(String p) {petName = p;}
    
    public void randomizeMeal() {
        int randInd = (int) (Math.random() * mealOptions.length);
        this.setMeal(mealOptions[randInd]);
        System.out.println("New meal: " + mealOptions[randInd]);
        randInd = (int) (Math.random() * drinkOptions.length);
        drink = drinkOptions[randInd];
        System.out.println("New drink: " + drink);
        randInd = (int) (Math.random() * dessertOptions.length);
        dessert = dessertOptions[randInd];
        System.out.println("New dessert: " + dessert);
    }

    public String toString() {
        return (super.toString() + "(first)");
    }

    public boolean equals(Passengers p) {
        return (
            (this.toString().equals(p.toString())) && (this.getMeal().equals(p.getMeal()))
        );
    }

    public void toggleLimo() {
        if (limoPickup) limoPickup = false;
        else limoPickup = true;
        System.out.println("Limo pickup status: " + limoPickup + " for " + this.getName());
    }

    public void toggleDND() {
        if (doNotDisturb) {
            doNotDisturb = false;
            System.out.println("DND is now OFF for " + this.getName());
        }
        else {doNotDisturb = true; System.out.println("DND is now ON for " + this.getName());}
    }
}