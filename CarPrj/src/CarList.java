
import java.io.*;
import java.util.*;

public class CarList extends ArrayList<Car> {

    public int searchID(String carID) {

        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getCarID().equals(carID)) {
                return i;
            }
        }
        return -1;
    }

    public int searchFrame(String fID) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getFrameID().equals(fID)) {
                return i;
            }
        }
        return -1;
    }

    public int searchEngine(String eID) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getEngineID().equals(eID)) {
                return i;
            }
        }
        return -1;
    }

    public void listCars() {
        Collections.sort(this);
        int size = this.size();
        for (int i = 0; i < size; i++) {
            Car c = this.get(i);
            System.out.println(c.screenString());
        }

    }
    
    public void save() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("cars.txt"))) {
            for (Car car : this) {
                String line = car.getCarID() + ", " + car.getBrand().getBrandID() + ", " + car.getColor() + ", " + car.getFrameID() + ", " + car.getEngineID();
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error occurred while saving cars: " + e.getMessage());
        }
    }

    public static CarList load() {
        CarList carList = new CarList();

        try {
            String projectDirectory = System.getProperty("user.dir");
            String filePath = projectDirectory + File.separator + "cars.txt";
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                String carID = parts[0];
                String brandID = parts[1];
                String color = parts[2];
                String frameID = parts[3];
                String engineID = parts[4];

                // Assuming Brand.load() is available to load the brand object
                Brand brand = Brand.load(brandID);

                Car car = new Car(carID, brand, color, frameID, engineID);
                carList.add(car);
            }
        } catch (IOException e) {
            System.out.println("Error occurred while loading cars: " + e.getMessage());
            return null;
        }

        return carList;
    }
}
