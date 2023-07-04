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

        // Save the brands
        brandList.save();
        // Load the brands
        BrandList loadedBrandList = BrandList.load();
        if (loadedBrandList != null) {
            System.out.println("Loaded Brands:");
            for (Brand brand : loadedBrandList) {
                System.out.println("ID: " + brand.getBrandID());
                System.out.println("Brand Name: " + brand.getBrandName());
                System.out.println("Sound Brand: " + brand.getSoundBrand());
                System.out.println("Price: " + brand.getPrice());
                System.out.println("------------------");
            }
        }

        System.out.println();

        Brand brand = loadedBrandList.get(0);
        Car car1 = new Car("1", brand, "Red", "Frame 1", "Engine 1");
        Car car2 = new Car("2", brand, "Blue", "Frame 2", "Engine 2");

        CarList carList = new CarList();
        carList.add(car1);
        carList.add(car2);

        // Save the cars
        carList.save();

        // Load the cars
        CarList loadedCarList = CarList.load();
        if (loadedCarList != null) {
            System.out.println("Loaded Cars:");
            for (Car car : loadedCarList) {
                System.out.println("Car ID: " + car.getCarID());
                System.out.println("Brand ID: " + car.getBrand().getBrandID());
                System.out.println("Color: " + car.getColor());
                System.out.println("Frame ID: " + car.getFrameID());
                System.out.println("Engine ID: " + car.getEngineID());
                System.out.println("------------------");
            }
        }
   }
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
}