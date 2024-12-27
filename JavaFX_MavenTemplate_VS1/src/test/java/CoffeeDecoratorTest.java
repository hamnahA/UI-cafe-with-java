import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CoffeeDecoratorTest {

    @Test
    void testBasicCoffeePrice() {
        Coffee coffee = new BasicCoffee();
        assertEquals(4.50, coffee.makeCoffee(), 0.01, "Basic coffee should cost $4.50");
    }

    @Test
    void testCoffeeWithExtraShot() {
        Coffee coffee = new ExtraShot(new BasicCoffee());
        assertEquals(5.70, coffee.makeCoffee(), 0.01, "Coffee with extra shot should cost $5.70");
    }

    @Test
    void testCoffeeWithCream() {
        Coffee coffee = new Cream(new BasicCoffee());
        assertEquals(5.00, coffee.makeCoffee(), 0.01, "Coffee with cream should cost $5.00");
    }

    @Test
    void testCoffeeWithSugar() {
        Coffee coffee = new Sugar(new BasicCoffee());
        assertEquals(5.00, coffee.makeCoffee(), 0.01, "Coffee with sugar should cost $5.00");
    }

    @Test
    void testCoffeeWithCaramel() {
        Coffee coffee = new Caramel(new BasicCoffee());
        assertEquals(5.25, coffee.makeCoffee(), 0.01, "Coffee with caramel should cost $5.25");
    }

    @Test
    void testCoffeeWithWhippedCream() {
        Coffee coffee = new WhippedCream(new BasicCoffee());
        assertEquals(5.25, coffee.makeCoffee(), 0.01, "Coffee with whipped cream should cost $5.25");
    }

    @Test
    void testComplexCoffeeOrder() {
        Coffee coffee = new WhippedCream(new Caramel(new ExtraShot(new BasicCoffee())));
        assertEquals(7.20, coffee.makeCoffee(), 0.01, "Complex coffee order total should be correct");
    }

    @Test
    void testAllAddOns() {
        Coffee coffee = new WhippedCream(
                         new Caramel(
                           new Sugar(
                             new Cream(
                               new ExtraShot(
                                 new BasicCoffee())))));
        assertEquals(8.20, coffee.makeCoffee(), 0.01, "Coffee with all add-ons should total correctly");
    }

    @Test
    void testMultipleExtraShots() {
        Coffee coffee = new ExtraShot(new ExtraShot(new BasicCoffee()));
        assertEquals(6.90, coffee.makeCoffee(), 0.01, "Coffee with two extra shots should cost $6.90");
    }

    @Test
    void testMultipleCreamAndSugar() {
        Coffee coffee = new Sugar(new Cream(new Sugar(new Cream(new BasicCoffee()))));
        assertEquals(6.50, coffee.makeCoffee(), 0.01, "Coffee with double cream and sugar should cost $6.50");
    }
}