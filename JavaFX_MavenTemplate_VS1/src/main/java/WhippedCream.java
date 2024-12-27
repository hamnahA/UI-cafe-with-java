// WhippedCream.java
public class WhippedCream extends CoffeeDecorator {
    private double cost = 0.75;
    
    public WhippedCream(Coffee specialCoffee) {
        super(specialCoffee);
    }
    
    public double makeCoffee() {
        return specialCoffee.makeCoffee() + addWhippedCream();
    }
    
    private double addWhippedCream() {
        System.out.println(" + whipped cream: $0.75");
        return cost;
    }
}