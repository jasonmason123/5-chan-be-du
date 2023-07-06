
import java.util.*;
import java.lang.*;

public class CarManager {

    public static void main(String[] args) {
//(*)Sơn: test method update Brand() va getUserChoice()
        Brand brand1 = new Brand("1", "Brand 1", "Sound 1", 1000.0);
        Brand brand2 = new Brand("2", "Brand 2", "Sound 2", 2000.0);
        Brand brand3 = new Brand("3", "Brand 3", "Sound 3", 3000.0);

        BrandList brandList = new BrandList();
        brandList.add(brand1);
        brandList.add(brand2);
        brandList.add(brand3);

        Car c1 = new Car("1", brand1, "red", "F0001", "E0001");
        Car c2 = new Car("2", brand2, "blue", "F0002", "E0002");
        CarList crlst = new CarList();
        crlst.add(c1);
        crlst.add(c2);
//        
//        crlst.searchByID();
        //System.out.println(crlst.searchID("1"));
        //crlst.listCars();

//        // Save the brands
//        brandList.save();
//        // Load the brands
//        BrandList loadedBrandList = BrandList.load();
//        if (loadedBrandList != null) {
//            System.out.println("Loaded Brands:");
//            for (Brand brand : loadedBrandList) {
//                System.out.println(brand);
//                System.out.println("------------------");
//            }
//        }
//
//        System.out.println();
//
//        Brand brand = loadedBrandList.get(0);
//        Car car1 = new Car("1", brand, "Red", "Frame 1", "Engine 1");
//        Car car2 = new Car("2", brand, "Blue", "Frame 2", "Engine 2");
//
//        CarList carList = new CarList();
//        carList.add(car1);
//        carList.add(car2);
//
//        // Save the cars
//        carList.save();
//
//        // Load the cars
//        CarList loadedCarList = CarList.load();
//        if (loadedCarList != null) {
//            System.out.println("Loaded Cars:");
//            for (Car car : loadedCarList) {
//                System.out.println(car);
//                System.out.println("------------------");
//            }
//        }
//        
//        Car cr = Car.load("1");
//        System.out.println(cr);
//   }
//        Brlst.addBrand();
//        Brlst.addBrand();
//(*)Sơn: updateBrand() test fail. Thieu cho nhap vao brandID
//        Brlst.updateBrand();
//(*)Sơn: getUserChoice test success
//        System.out.println(Brlst.getUserChoice());
//(*)Sơn: saveBrands() và loadBrands() test success. Tuy nhiên để tốt hơn thì saveBrands() nên có khả năng tự tạo ra file
//thay vì để người dùng phải tạo file thủ công để lưu và nên có cách thông báo người dùng khi save brand thành công
//        Brlst.saveBrands("experiment.txt");
//        Brlst.loadBrands("someshitwhat.txt");
//        for (Brand br: Brlst.loadBrands("experiment.txt")) {
//            System.out.println(Brlst);
//        }
//        Brlst.listBrands();
//        System.out.println(Brlst.searchID("B7-2018"));    
//        Brlst.updateBrand();
//tmt's menu
//    String[] options = {
//            "List all brands",
//            "Add a new brand",
//            "Search a brand based on its ID",
//            "Update a brand",
//            "Save brands to the file, named brands.txt",
//            "List all cars in ascending order of brand names",
//            "List cars based on a part of an input brand name",
//            "Add a car",
//            "Remove a car based on its ID",
//            "Update a car based on its ID",
//            "Save cars to file, named cars.txt",
//            
//        };
//
//        int choice = 0;
//
//
//        do {
//            System.out.println("\nCar Manager Program");
//            System.out.println("=========================MENU=========================");
//
//            choice = Menu.int_getChoice(options);
//
//            switch (choice) {
//                case 1:
//                    brandList.listBrands();
//                    break;
//
//                case 2:
//                    brandList.addBrand();
//                    break;
//
//                case 3:
//                    brandList.searchByID();
//                    break;
//                case 4:
//                    brandList.updateBrand();
//                    break;
//                case 5:
//                    brandList.save();
//                    break;
//                case 6:
//                    crlst.listCars();
//                    break;
//                case 7:
//                    break;
//                case 8:
////                    crlst.
//                    break;
//                case 9:
//                    break;
//                case 10:
//                    break;
//                case 11:
//                    crlst.save();
//                    break;
//                default:
//                    System.out.println("Bye!");
//                    break;
//            }
//        } while (choice > 0 && choice < 6);

        ArrayList<Object> menuOptions = new ArrayList<>();
        menuOptions.add("List all brands");
        menuOptions.add("Add a new brand");
        menuOptions.add("Search a brand based on its ID");
        menuOptions.add("Update a brand");
        menuOptions.add("Save brands to the file, named brands.txt");
        menuOptions.add("List all cars in ascending order of brand names");
        menuOptions.add("List cars based on a part of an input brand name");
        menuOptions.add("Add a car");
        menuOptions.add("Remove a car based on its ID");
        menuOptions.add("Update a car based on its ID");
        menuOptions.add("Save cars to file, named cars.txt");

//        Object selectedOption = ref_getChoice(menuOptions);
//        System.out.println("Selected option: " + selectedOption);
    }
}
