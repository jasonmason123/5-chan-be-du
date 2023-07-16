import java.io.*;

public class Brand {
    private String brandID,
    brandName,
    soundBrand;
    private double price;

    public Brand() {
    }

    public Brand(String brandID, String brandName, String soundBrand, double price) {
        this.brandID = brandID;
        this.brandName = brandName;
        this.soundBrand = soundBrand;
        this.price = price;
    }

    public String getBrandID() {
        return brandID;
    }

    public void setBrandID(String BrandID) {
        this.brandID = BrandID;
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
    
    public static Brand load(String brandID) {
        try (BufferedReader reader = new BufferedReader(new FileReader("brands.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String id = parts[0];
                String brandName = parts[1];
                String soundBrand = parts[2];
                double price = Double.parseDouble(parts[3]);

                if (id.equals(brandID)) {
                    return new Brand(id, brandName, soundBrand, price);
                }
            }
        } catch (IOException e) {
            System.out.println("Error occurred while loading brands: " + e.getMessage());
        }

        return null; // Brand not found
    }
    
    @Override
    public String toString() {
        return "BrandID=" + brandID + ", brandName=" + brandName + ", soundBrand=" + soundBrand + ": price=" + price;
    }

//    int compareTo(Brand brand) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
     
}
