import java.util.*;
import java.lang.*;

public class CarManager {
    public static void main(String[] args) {
//(*)Sơn: test method update Brand() va getUserChoice()
        BrandList Brlst = new BrandList();
        CarList Crlst = new CarList();
        
//        Brlst.addBrand();
//        Brlst.addBrand();
        for (Brand br: Brlst.loadBrands("experiment.txt")){
            Brlst.add(br);
        }
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
        Brlst.searchByID();
    }
}
