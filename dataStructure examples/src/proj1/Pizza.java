package proj1;

import java.util.ArrayList;

//Makes possible comparing different sort of Pizzas
public class Pizza implements Comparable<Pizza> {

    //Not as strings but as Enums
    enum CrustType {
        PLAIN, BUTTER, GARLIC, GARLICBUTTER, CHEESE;
    }

    enum Toppings {
        CHEESE, ONION, GREEN_PEPPER, HAM, PINEAPPLE, PEPPERONI, GROUND_BEEF, ITALIAN_SAUSAGE, ANCHOVIES;
    }

    enum SizeType {
        SMALL, MEDIUM, LARGE, XLARGE, XXXLARGE, PARTY;
    }

    private CrustType crust;
    private ArrayList<Toppings> toppings;
    private SizeType size;


    //Creating a Pizza starting with crust Plain,  a list of toppings, and a size.
    public Pizza(CrustType crust, ArrayList<Toppings> toppings, SizeType size) {
        this.crust = CrustType.PLAIN;
        this.toppings = toppings;
        this.size = size;
    }

    // Pizza(crust, toppings, size) Constructor, initialize the fields to the values passed in by the client
    public Pizza(CrustType crust, SizeType size) {
        this.crust = crust;
        toppings = new ArrayList<>();
        this.size = size;
    }


    //Here are Getters and Setters for each of the field name
    public CrustType getCrust() {
        return crust;
    }

    public void setCrust(CrustType crust) {
        this.crust = crust;
    }

    public ArrayList<Toppings> getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList<Toppings> toppings) {
        this.toppings = toppings;
    }

    public SizeType getSize() {
        return size;
    }

    public void setSize(SizeType size) {
        this.size = size;
    }

    //This method will be used to add the toppings to a Pizza object
    public void addTopping(Toppings topping) {
        toppings.add(topping);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        //This will be the output using StringBuilder connecting multiple strings together ofered form toString
        // it will indicate the crust type
        //Starting new line that will show the different toppings
        builder.append("This pizza has a ").append(crust).append(" crust and the following toppings:\n");

        //Makes sure the list of toppings is empty
        if (toppings.isEmpty()) {
            // 0 toppings appears this message
            builder.append("none\n");
        } else {
            // if this is not there it will not show any of the toppings this line will add each topping to the StringBuilder
            for (Toppings topping : toppings) {
                //Creates the list of topping showing each of them in a new line
                builder.append(topping).append("\n");

            }
        }
        return builder.toString();
    }

    @Override

    public boolean equals(Object obj) {
        //Checks if the object are the same if they are not the same turns true
        if (this == obj) {
            return true;
        }
        // Checks for equality by comparing the crust and the number of toppings, and if either of these attributes is not equal, it will return false
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        //Taking one object comparing it to another pizza
        Pizza otherPizza = (Pizza) obj;
        //Proving if both toppings and crust are equal for both pizzas
        return crust == otherPizza.crust && toppings.size() == otherPizza.toppings.size();
    }

    @Override
    public int compareTo(Pizza otherPizza) {
        //Pizza 1 = Pizza 2 toppings and crust return 0
        if (this.equals(otherPizza)) {
            return 0;
            //Pizza 1 = Pizza 2 toppings, but Pizza 1 > Pizza 2 crust still returns -1
        } else if (toppings.size() < otherPizza.toppings.size()) {
            return -1;
            //Pizza 1 > Pizza 2 toppings
        } else if (toppings.size() > otherPizza.toppings.size()) {
            return 1;
            //Pizza 1 = Pizza 2 toppings but Pizza A > Pizza B crust returns 1
        }// else if (this.crust.compareTo(otherPizza.crust) > 0) {
        //  return 1;
        // } else {
        // Compare the crusts but in reverse from the crust enum staring from Cheese as teh highest and ending with plain
        return Integer.compare(otherPizza.crust.ordinal(), this.crust.ordinal());
    }


}