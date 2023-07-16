import java.util.*;
import java.lang.*;

public class CarManager {

    public static void main(String[] args) {
//(*)Sơn: test method update Brand() va getUserChoice()
        Brand brand1 = new Brand("BR1", "Brand 1", "Sound 1", 1000.0);
        Brand brand2 = new Brand("BR2", "Brand 2", "Sound 2", 2000.0);
        Brand brand3 = new Brand("BR3", "Brand 3", "Sound 3", 3000.0);
        Brand brand4 = new Brand("BR4", "Toyota", "Sony", 4000.0);

        BrandList brandList = new BrandList();
        brandList.add(brand1);
        brandList.add(brand2);
        brandList.add(brand3);

        Car c1 = new Car("C01", brand1, "red", "F0001", "E0001");
        Car c2 = new Car("C02", brand2, "blue", "F0002", "E0002");
        Car c3 = new Car("C03", brand2, "grey", "F0003", "E0003");
        CarList crlst = new CarList(brandList);
        crlst.add(c1);
        crlst.add(c2);

//tmt's menu
        String[] options = {
            "List all brands",
            "Add a new brand",
            "Search a brand based on its ID",
            "Update a brand",
            "Save brands to the file, named brands.txt",
            "List all cars in ascending order of brand names",
            "List cars based on a part of an input brand name",
            "Add a car",
            "Remove a car based on its ID",
            "Update a car based on its ID",
            "Save cars to file, named cars.txt",
        };
        int choice = 0;
        Menu mn = new Menu();

        do {
            System.out.println("\nCar Manager Program");
            System.out.println("=============================MENU=============================");

            choice = mn.int_getChoice(options);

            switch (choice) {
                case 1:
                    brandList.listBrands();
                    break;
                case 2:
                    brandList.addBrand();
                    break;
                case 3:
                    brandList.searchByID();
                    break;
                case 4:
                    brandList.updateBrand();
                    break;
                case 5:
                    brandList.save();
                    break;
                case 6:
                    crlst.listCars();
                    break;
                case 7:
                    crlst.printBasedBrandName();
                    break;
                case 8:
                    crlst.addCar();
                    break;
                case 9:
                    crlst.removeCar();
                    break;
                case 10:
                    crlst.updateCar();
                    break;
                case 11:
                    crlst.save();
                    break;
                default:
                    System.out.println("PROGRAM CLOSED!");
                    break;
            }
        } while (choice > 0 && choice < 12);
    }
}
