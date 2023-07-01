import java.util.*;
import java.lang.*;

public class BrandList extends ArrayList<Brand> {
    public int searchID (String bID){
        for(int i =0; i<this.size();i++){
            if(this.get(i).getBrandID().equals(bID)) return i;
        }
        return -1;
    }
    
    public void updateBrand() {
    String brandID = null;

    int pos = searchID(brandID);

    if (pos < 0) {
        System.out.println("Not found!");
    } else {
        String brandName = "The brand name is not blank";

        String soundBrand = "The sound brand is not blank";

        if (brandName.isEmpty() || soundBrand.isEmpty() || get(pos).getPrice() <= 0) {
            System.out.println("Invalid input! The brand name, sound brand, and price must not be blank, and the price must be greater than 0.");
        } else {
            Brand brand = get(pos);
            brand.setBrandName(brandName);
            brand.setSoundBrand(soundBrand);
            brand.setPrice(get(pos).getPrice());

            System.out.println("Brand updated successfully.");
        }
    }
}

}

