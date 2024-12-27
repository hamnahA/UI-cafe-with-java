import java.time.Duration;
import java.util.Random;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;


public class CoffeeController {
    private Coffee currentOrder;

    @FXML
    private TextArea orderDisplay;
    
    @FXML
    private Button newOrderBtn;
    
    @FXML
    private Button deleteOrderBtn;
    
    @FXML
    private Button completeOrderBtn;

    @FXML
public void initialize() {
    // Disable buttons until there's an order
    deleteOrderBtn.setDisable(true);
    completeOrderBtn.setDisable(true);
    
    // Force the size of the TextArea
    orderDisplay.setPrefWidth(500);
    orderDisplay.setPrefHeight(250);
     orderDisplay.setMaxWidth(500);
     orderDisplay.setMaxHeight(250);
}

    @FXML
    private void handleNewOrder() {
        currentOrder = new BasicCoffee();
        updateDisplay();
        deleteOrderBtn.setDisable(false);
        completeOrderBtn.setDisable(false);
         // Clear all the images from the animationPane
    animationPane.getChildren().clear();
           
    }

    @FXML
    private void handleDeleteOrder() {
        currentOrder = null;
        orderDisplay.clear();
        deleteOrderBtn.setDisable(true);
        completeOrderBtn.setDisable(true);
        animationPane.getChildren().clear();
        clearImages();


    }

    // @FXML
    // private void handleExtraShot() {
    //     if (currentOrder != null) {
    //         currentOrder = new ExtraShot(currentOrder);
    //         updateDisplay();
    //     }
    // }

    @FXML
    private void handleCream() {
        if (currentOrder != null) {
            currentOrder = new Cream(currentOrder);
            updateDisplay();
            addImage("drink.png");
        }
    }

    @FXML
    private void handleSugar() {
        if (currentOrder != null) {
            currentOrder = new Sugar(currentOrder);
            updateDisplay();
            addImage("sugar.png");

        }
    }

    @FXML
    private void handleCaramel() {
        if (currentOrder != null) {
            currentOrder = new Caramel(currentOrder);
            updateDisplay();
            addImage("syrup.png");

        }
    }

    @FXML
    private void handleWhippedCream() {
        if (currentOrder != null) {
            currentOrder = new WhippedCream(currentOrder);
            updateDisplay();
            addImage("pastry.png");

        }
    }

    @FXML
    private void handleCompleteOrder() {
        if (currentOrder != null) {
            orderDisplay.appendText("\nOrder completed! Thank you!");
            currentOrder = null;
            deleteOrderBtn.setDisable(true);
            completeOrderBtn.setDisable(true);
            clearImages();

        }
    }

    private void updateDisplay() {
        if (currentOrder != null) {
            orderDisplay.setText("Order Details:\n");  // Keep the header
            orderDisplay.clear();
            
            // Capture System.out to get the itemized order
            java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
            java.io.PrintStream ps = new java.io.PrintStream(baos);
            java.io.PrintStream old = System.out;
            System.setOut(ps);
    
            // Get the order total and capture the printed output
            double cost = currentOrder.makeCoffee();
            System.setOut(old);
            
            // Format the display with the itemized order and a clear total at the bottom
            String itemizedOrder = baos.toString();
            orderDisplay.setText(itemizedOrder +
            
                               "------------------------" +
                               "\nTotal: $" + String.format("%.2f", cost));
        }
    }
    @FXML
    private Pane animationPane;
    private Random random = new Random();
    private int imageCount = 0;
private final int imageSize = 50; 
private final int padding = 10; // Set the desired padding between images

private void addImage(String imageName) {
    try {
        // Print to check if we're finding the image
        System.out.println("Looking for image: " + imageName);
        var stream = getClass().getResourceAsStream("/" + imageName);
        if (stream == null) {
            System.out.println("Could not find image!");
            return;
        }
        
        ImageView imageView = new ImageView(new Image(stream));
        imageView.setFitWidth(imageSize);
        imageView.setFitHeight(imageSize);
        
        // Calculate the position based on the image count
        double x = padding + ((imageSize + padding) * (imageCount % 3));
        double y = padding + ((imageSize + padding) * (imageCount / 3));
        imageView.setX(x);
        imageView.setY(y);
        
        animationPane.getChildren().add(imageView);
        System.out.println("Image added at position: " + x + ", " + y);
        
        imageCount++;
    } catch (Exception e) {
        System.out.println("Error loading image: " + e.getMessage());
        e.printStackTrace();
    }
}
    @FXML
    private void handleExtraShot() {
        if (currentOrder != null) {
            currentOrder = new ExtraShot(currentOrder);
            updateDisplay();
            addImage("red-beans.png");
        }
    }
    private void clearImages() {
        animationPane.getChildren().clear();
        imageCount = 0;
    }
}