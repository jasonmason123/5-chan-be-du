
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Collection;
import java.util.List;

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

    public void saveCars(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Car car : this) {
                String line = car.getCarID() + "," + car.getBrand().getBrandID() + ","
                        + car.getColor() + "," + car.getFrameID() + "," + car.getEngineID();
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error occurred while saving cars: " + e.getMessage());
        }
    }

    public List<Car> loadCars(String filePath) {
        List<Car> cars = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];
                String brandID = data[1];
                String brandName = data[2];
                String soundBrand = data[3];
                double price = Float.parseFloat(data[4]);
                Brand brand = new Brand(brandID, brandName, soundBrand, price);
                String color = data[5];
                String frameId = data[6];
                String engineId = data[7];

                Car car = new Car(id, brand, color, frameId, engineId);
                cars.add(car);
            }
        } catch (IOException e) {
            System.out.println("Error occurred while loading cars: " + e.getMessage());
        }

        return cars;
    }

    public void listCars() {
        Collections.sort(this);
        int size = this.size();
        for (int i = 0; i < size; i++) {
            Car c = this.get(i);
            System.out.println(c.screenString());
        }

    }
}
