// Sugar.java
public class Sugar extends CoffeeDecorator {
    private double cost = 0.50;
    
    public Sugar(Coffee specialCoffee) {
        super(specialCoffee);
    }
    
    public double makeCoffee() {
        return specialCoffee.makeCoffee() + addSugar();
    }
    
    private double addSugar() {
        System.out.println(" + sugar: $0.50");
        return cost;
    }
}