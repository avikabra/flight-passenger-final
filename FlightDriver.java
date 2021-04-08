public class FlightDriver {
    public static void main (String []args) {

        Flight SQ121 = new Flight("Singapore", "Mumbai", "0740", "1240");
        //SQ121.shiftDepartureTime("0000");
        Passengers[] party = {
            //new FirstPassenger("mr. ayyappan", "chicken", "ice cream", "champagne"),
            new FirstPassengerWithPet("mr. a", "asian veg", "ice cream", "champagne", "snuffles", "cat"),
            new FirstPassenger(),
            new FirstPassenger("jeff", "asian non-veg", "ice cream", "apple juice"),
            new BusinessPassenger("stephen", "asian veg", "cake"),
            new BusinessPassenger("eric", "gluten-free", "cake"),
            new BusinessPassenger("avi", "european veg", "none"),
            new BusinessPassenger("arnav", "asian non-veg", "none"),
            new EconomyPassenger("chloe", "european non-veg"),
            new Passengers("turtle", "european veg", 0),
            new FirstPassenger("jason", "asian non-veg", "ice cream", "none")
        };

        party[0].assignSeat(SQ121, 0);
        party[0].randomizeMeal();
        ((FirstPassenger)(party[0])).toggleDND();
        System.out.println("Flight time: " + party[0].getFlightTime(SQ121));
        System.out.println(party[0].checkAdjacentPets(SQ121));
        System.out.println(party[0].createNewSpecies());

        party[1].assignSeat(SQ121, 0);
        ((FirstPassenger)(party[1])).toggleLimo();

        party[2].assignSeat(SQ121, 0);
        System.out.println(party[2].getSeat());
        System.out.println(party[2].equals(party[2]));
        System.out.println(party[2].equals(party[8]));

        party[3].assignSeat(SQ121, 0);
        ((BusinessPassenger)(party[3])).toggleDND();
        party[3].randomizeMeal();

        party[4].assignSeat(SQ121, 0);
        party[5].assignSeat(SQ121, 0);
        party[6].assignSeat(SQ121, 0);

        //upcasting
        party[7].assignSeat(SQ121, 0);
        System.out.println(((Passengers)(party[7])));

        party[8].assignSeat(SQ121, 0);
        party[9].assignSeat(SQ121, 0);

        /*
        FirstPassenger testPet = new FirstPassengerWithPet("mr. a", "asian veg", "ice cream", "champagne", "snuffles", "cat");
        testPet.assignSeat(SQ121, 0);
        //FirstPassenger testPet2 = new FirstPassengerWithPet("mr. b", "asian veg", "ice cream", "champagne", "snuffles", "cat");
        //testPet2.assignSeat(SQ121, 0);
        testPet.toggleLimo();
        System.out.println(testPet.checkAdjacentPets(SQ121));
        */
        
        System.out.println(SQ121);
    }
}