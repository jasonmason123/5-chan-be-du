import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Car implements Comparable<Car> {

    private String carID,
            color,
            frameID,
            engineID;
            Brand brand;

    public Car() {
    }

    public Car(String carID, Brand brand, String color, String frameID, String engineID) {
        this.carID = carID;
        this.brand = brand;
        this.color = color;
        this.frameID = frameID;
        this.engineID = engineID;
    }

    public String getCarID() {
        return carID;
    }

    public void setCarID(String CarID) {
        this.carID = CarID;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color.trim().isEmpty() == false) {
            this.color = color;
        }
    }

    public String getFrameID() {
        return frameID;
    }

    public void setFrameID(String frameID) {
        if (frameID.trim().isEmpty() == false) {
            this.frameID = frameID;
        }
    }

    public String getEngineID() {
        return engineID;
    }

    public void setEngineID(String engineID) {
        if (engineID.trim().isEmpty() == false) {
            this.engineID = engineID;
        }
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
    
    public void save() {
        String desktopPath = System.getProperty("user.home") + "/Desktop";
        String filePath = desktopPath + "/cars.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            String line = carID + "," + brand.getBrandID() + "," + color + "," + frameID + "," + engineID;
            writer.write(line);
        } catch (IOException e) {
            System.out.println("Error occurred while saving car: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "CarID=" + carID + ", brand=" + brand.getBrandID() + ", color=" + color + ", frameID=" + frameID + ", engineID=" + engineID;
    }

    public String screenString() {
    String brandName = brand.getBrandName(); // Assuming the Brand class has a getBrandName() method.

    StringBuilder sb = new StringBuilder();
    sb.append("Car ID: ").append(carID)
      .append("\nBrand: ").append(brandName)
      .append("\nColor: ").append(color)
      .append("\nFrame ID: ").append(frameID)
      .append("\nEngine ID: ").append(engineID)
      .append("\n-----------------------------------\n");

    return sb.toString();
}

    @Override
    public int compareTo(Car otherCar) {
        int d = this.getBrand().getBrandName().compareTo(otherCar.getBrand().getBrandName());
        if (d != 0) {
            return d;
        }
        return this.getCarID().compareTo(otherCar.getCarID());
    }

}
