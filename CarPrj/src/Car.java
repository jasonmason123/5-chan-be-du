import java.util.*;
import java.lang.*;

public class Car implements Comparable<Car> {
    
    private String CarID,
    color,
    frameID,
    engineID;
    Brand brand;

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
        this.color = color;
    }

    public String getFrameID() {
        return frameID;
    }

    public void setFrameID(String frameID) {
        this.frameID = frameID;
    }

    public String getEngineID() {
        return engineID;
    }

    public void setEngineID(String engineID) {
        this.engineID = engineID;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Car{" + "CarID=" + CarID + ", brand=" + brand + ", color=" + color + ", frameID=" + frameID + ", engineID=" + engineID + '}';
    }
    
    public String screenString() {
        return CarID + brand.getBrandID() + color + frameID + engineID;
    }

    @Override
    public int compareTo(Car o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}