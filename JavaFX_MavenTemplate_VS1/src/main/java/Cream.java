// Cream.java
public class Cream extends CoffeeDecorator {
    private double cost = 0.50;
    
    public Cream(Coffee specialCoffee) {
        super(specialCoffee);
    }
    
    public double makeCoffee() {
        return specialCoffee.makeCoffee() + addCream();
    }
    
    private double addCream() {
        System.out.println(" + cream: $0.50");
        return cost;
    }
}