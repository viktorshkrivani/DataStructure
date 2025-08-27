package proj1;

public class PizzaDemo {
    public static void main(String[] args) {
        System.out.println("--------------------------------------------------------------------" + "\n" );
        Pizza one = new Pizza(Pizza.CrustType.PLAIN, Pizza.SizeType.LARGE);
        one.addTopping(Pizza.Toppings.GREEN_PEPPER);
        one.addTopping(Pizza.Toppings.ANCHOVIES);


        Pizza two = new Pizza();
        two.addTopping(Pizza.Toppings.ONION);


        System.out.println("Pizza 1: " + one);
        System.out.println("Pizza 2: " + two);

        System.out.println("Are First Pizza equal to the Second Pizza? " + one.equals(two));
        System.out.println("What is the difference between the First Pizza with the Second one? " + one.compareTo(two)+ "\n");
        System.out.println("--------------------------------------------------------------------" + "\n" );


        Pizza three = new Pizza(Pizza.CrustType.BUTTER, Pizza.SizeType.XLARGE);
        three.addTopping(Pizza.Toppings.CHEESE);
        three.addTopping(Pizza.Toppings.ANCHOVIES);
        three.addTopping(Pizza.Toppings.ITALIAN_SAUSAGE);

        Pizza four = new Pizza(Pizza.CrustType.BUTTER, Pizza.SizeType.XXXLARGE);
        four.addTopping(Pizza.Toppings.ANCHOVIES);
        four.addTopping(Pizza.Toppings.ONION);
        four.addTopping(Pizza.Toppings.CHEESE);

        System.out.println("Pizza 3: " + three);
        System.out.println("Pizza 4: " + four);


        System.out.println("Are Third Pizza equal to the Fourth Pizza? " + three.equals(four));
        System.out.println("What is the difference between the Third Pizza with the Fourth one? " + three.compareTo(four)+ "\n");
        System.out.println("--------------------------------------------------------------------" + "\n" );

        Pizza five = new Pizza(Pizza.CrustType.CHEESE, Pizza.SizeType.PARTY);
        five.addTopping(Pizza.Toppings.PINEAPPLE);
        five.addTopping(Pizza.Toppings.GROUND_BEEF);

        Pizza six = new Pizza(Pizza.CrustType.GARLIC, Pizza.SizeType.SMALL);
        six.addTopping(Pizza.Toppings.CHEESE);
        six.addTopping(Pizza.Toppings.PEPPERONI);

        System.out.println("Pizza 5: " + five);
        System.out.println("Pizza 6: " + six);

        System.out.println("Are Fifth Pizza equal to the Sixth Pizza? " + five.equals(six));
        System.out.println("What is the difference between the Fifth Pizza with the Six one? " + five.compareTo(six)+ "\n");
        System.out.println("--------------------------------------------------------------------" + "\n" );












    }
}