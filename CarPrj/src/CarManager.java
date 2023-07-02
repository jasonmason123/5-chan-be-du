import java.util.*;
import java.lang.*;

public class CarManager {
    public static void main(String[] args) {
//(*)Sơn: test method update Brand() va getUserChoice()
        BrandList Brlst = new BrandList();
        CarList Crlst = new CarList();
        
        Brlst.addBrand();
        Brlst.addBrand();
//(*)Sơn: updateBrand() test fail. Thieu cho nhap vao brandID
        Brlst.updateBrand();
        
        System.out.println(Brlst);
//(*)Sơn: getUserChoice test success
        System.out.println(Brlst.getUserChoice());
    }
}
