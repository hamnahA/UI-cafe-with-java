// Caramel.java
public class Caramel extends CoffeeDecorator {
    private double cost = 0.75;
    
    public Caramel(Coffee specialCoffee) {
        super(specialCoffee);
    }
    
    public double makeCoffee() {
        return specialCoffee.makeCoffee() + addCaramel();
    }
    
    private double addCaramel() {
        System.out.println(" + caramel: $0.75");
        return cost;
    }
}