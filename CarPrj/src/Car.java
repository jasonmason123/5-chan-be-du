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
            List<Car> cars;

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

    public Car searchID(String carID) {
        for (Car car : cars) {
            if (car.getCarID().equals(carID)) {
                return car;
            }
        }
        System.out.println("Car not found by ID.");
        return null;
    }
    public Car searchFrame(String fID) {
    for (Car car : cars) {
        if (car.getFrameID().equals(fID)) {
            return car;
        }
    }
    System.out.println("Car not found by Frame");
    return null;
}
    public Car searchEngine(String eID) {
    for (Car car : cars){
        if (car.getEngineID().equals(eID)) {
            return car;
        }
    }
        System.out.println("Car not found by Engine");
    return null;
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

    public static Car load(String carID) {
        try (BufferedReader reader = new BufferedReader(new FileReader("cars.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                String loadedCarID = parts[0];
                String brandID = parts[1];
                String color = parts[2];
                String frameID = parts[3];
                String engineID = parts[4];

                if (loadedCarID.equals(carID)) {
                    Brand brand = Brand.load(brandID);
                    return new Car(loadedCarID, brand, color, frameID, engineID);
                }
            }
        } catch (IOException e) {
            System.out.println("Error occurred while loading cars: " + e.getMessage());
        }

        return null; // Car not found
    }
    @Override
    public String toString() {
        return "CarID=" + carID + ", brand=" + brand + ", color=" + color + ", frameID=" + frameID + ", engineID=" + engineID;
    }

    public String screenString() {
        return carID + brand.getBrandID() + color + frameID + engineID;
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
