
import java.util.*;
import java.lang.*;
import java.util.Collections;

public class Car implements Comparable<Car> {

    private String CarID,
            color,
            frameID,
            engineID;
            Brand brand;
            List<Car> cars;

    public Car() {
    }

    public Car(String CarID, Brand brand, String color, String frameID, String engineID) {
        this.CarID = CarID;
        this.brand = brand;
        this.color = color;
        this.frameID = frameID;
        this.engineID = engineID;
    }

    public String getCarID() {
        return CarID;
    }

    public void setCarID(String CarID) {
        this.CarID = CarID;
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

    @Override
    public String toString() {
        return "Car{" + "CarID=" + CarID + ", brand=" + brand + ", color=" + color + ", frameID=" + frameID + ", engineID=" + engineID + '}';
    }

    public String screenString() {
        return CarID + brand.getBrandID() + color + frameID + engineID;
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
