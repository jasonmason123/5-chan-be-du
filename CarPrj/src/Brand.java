import java.util.*;
import java.lang.*;

public class Brand {
    private String BrandID,
    brandName,
    soundBrand;
    private double price;

    public Brand() {
    }

    public Brand(String BrandID, String brandName, String soundBrand, double price) {
        this.BrandID = BrandID;
        this.brandName = brandName;
        this.soundBrand = soundBrand;
        this.price = price;
    }

    public String getBrandID() {
        return BrandID;
    }

    public void setBrandID(String BrandID) {
        this.BrandID = BrandID;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        if(brandName.trim().isEmpty() == false) this.brandName = brandName;
    }

    public String getSoundBrand() {
        return soundBrand;
    }

    public void setSoundBrand(String soundBrand) {
        if(soundBrand.trim().isEmpty() == false) this.soundBrand = soundBrand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >=0) this.price = price;
    }

    @Override
    public String toString() {
        return "BrandID=" + BrandID + ", brandName=" + brandName + ", soundBrand=" + soundBrand + ": price=" + price;
    }
    
    
}
