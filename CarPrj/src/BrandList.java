import java.io.*;
import java.util.*;
import java.lang.*;

public class BrandList extends ArrayList<Brand> {
    public int searchID (String bID){
        for(int i =0; i<this.size();i++){
            if(this.get(i).getBrandID().equals(bID)) return i;
        }
        return -1;
    }
//(!)Thắng: thiếu hàm để in ra brand mà người dùng đang search
    
    public void updateBrand() {
    String brandID = null;
//(!)Thắng: thiếu chỗ nhập vào BrandID
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
    
//(*)Sơn: Check brandID co bi lap hay khong
    public boolean codeNotDuplicated(String code) {
        code = code.trim().toUpperCase();
        return searchID(code) != -1;
    }
    
    public void addBrand() {
        Inputter inp = new Inputter();
        Brand newBr = new Brand();
        String newID;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Please input brand ID:");
            newID = sc.nextLine();
        } while(codeNotDuplicated(newID) == true);
        newBr.setBrandID(newID);
        
        System.out.println("Brand Name:");
        newBr.setBrandName(inp.inputNotBlank());
        
        System.out.println("Sound Brand:");
        newBr.setSoundBrand(inp.inputNotBlank());
        
        newBr.setPrice(inp.inputPrice());
        
        this.add(newBr);
        System.out.println("Brand added succesfully!");
    }
    
    public void listBrands() {
        if (this.isEmpty() == true) System.out.println("Brand list is empty!");
        else {
            for (Brand br: this)
                System.out.println(br);
        }
    }
    
//(!)Dương: updateCar khi update Brand sẽ sử dụng hàm này
    public Brand getUserChoice() {
        Menu mn = new Menu();
        Brand result = (Brand)mn.ref_getChoice(this);
        return result;
    }
    
    public void saveBrands(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Brand brand : this) {
                String line = brand.getBrandID() + "," + brand.getBrandName() + ","
                        + brand.getSoundBrand() + "," + brand.getPrice();
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error occurred while saving brands: " + e.getMessage());
        }
    }

    public List<Brand> loadBrands(String filePath) {
        List<Brand> brands = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];
                String name = data[1];
                String soundBrand = data[2];
                double price = Double.parseDouble(data[3]);

                Brand brand = new Brand(id, name, soundBrand, price);
                brands.add(brand);
            }
        } catch (IOException e) {
            System.out.println("Error occurred while loading brands: " + e.getMessage());
        }

        return brands;
    }
}

