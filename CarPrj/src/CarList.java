
import java.io.*;
import java.util.*;

public class CarList extends ArrayList<Car> {

//Duc Anh
    
    public Car searchID(String carID) {
        for (Car car : this) {
            if (car.getCarID().equals(carID)) {
                return car;
            }
        }
        System.out.println("Car not found by ID.");
        return null;
    }
    
    public void searchByID() {
        Inputter inp = new Inputter();
        System.out.println("Input the ID of the car that needs to be found:");
        Car result = searchID(inp.inputNotBlank());
        if (result == null) ;
        else System.out.println(result);
    }
    
    public Car searchFrame(String fID) {
        for (Car car : this) {
            if (car.getFrameID().equals(fID)) {
                return car;
            }
        }
        System.out.println("Car not found by Frame");
        return null;
    }
    public void searchByFrame() {
        Inputter inp = new Inputter();
        System.out.println("Input the ID of the car that needs to be found:");
        Car result = searchFrame(inp.inputNotBlank());
        if (result == null) ;
        else System.out.println(result);
    }

    public Car searchEngine(String eID) {
        for (Car car : this) {
            if (car.getEngineID().equals(eID)) {
                return car;
            }
        }
        System.out.println("Car not found by Engine");
        return null;
    }
    
    public void searchByEngine() {
        Inputter inp = new Inputter();
        System.out.println("Input the ID of the car that needs to be found:");
        Car result = searchEngine(inp.inputNotBlank());
        if (result == null) ;
        else System.out.println(result);
    }

//Duc Anh
    public void listCars() {
        Collections.sort(this);
        int size = this.size();
        for (int i = 0; i < size; i++) {
            Car c = this.get(i);
            System.out.println(c.screenString());
        }
    }

//Khanh
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

//Khanh
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
