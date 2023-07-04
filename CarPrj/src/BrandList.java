
import java.io.*;
import java.util.*;

public class BrandList extends ArrayList<Brand> {

    //tmt
    public Brand searchID(String bID) {
        for (Brand brand : this) {
            if (brand.getBrandID().equals(bID)) {
                return brand;
            }
        }
        return null; // Brand not found
    }
    
    public void searchByID() {
        Inputter inp = new Inputter();
        System.out.println("Input the ID of the brand that needs to be found:");
        Brand result = searchID(inp.inputNotBlank());
        if (result == null) System.out.println("(!)Brand not found!");
        else System.out.println(result);
    }

    //tmt
    public void updateBrand() {
        //Scanner scanner = new Scanner(System.in);
        Inputter inp = new Inputter();
        // Receive brandID
        System.out.print("Enter the brand ID:\n");
        String brandID = inp.inputNotBlank();

        // Pos = searchID(brandID);
        Brand pos = searchID(brandID);

        if (pos == null) {
            System.out.println("(!)Brand not found!");
        } else {
            System.out.println("New brand name:");
            String brandName = inp.inputNotBlank();
            pos.setBrandName(brandName);
            System.out.println("New sound brand name:");
            String soundBrand = inp.inputNotBlank();
            pos.setSoundBrand(soundBrand);
            System.out.println("New price:");
            double Price = inp.inputPrice();
            pos.setPrice(Price);
            System.out.println("Update successful!");

//            if (brandName.isEmpty() || soundBrand.isEmpty() || pos.getPrice() <= 0) {
//                System.out.println("Invalid input! The brand name, sound brand, and price must not be blank, and the price must be greater than 0.");
//            } else {
//                System.out.print("Enter the new brand name: ");
//                brandName = scanner.nextLine();
//                // The brand name is not blank
//                if (!brandName.isEmpty()) {
//                    pos.setBrandName(brandName);
//                }
//
//                // Receive new soundBrand
//                System.out.print("Enter the new sound brand: ");
//                soundBrand = scanner.nextLine();
//                // The sound brand is not blank
//                if (!soundBrand.isEmpty()) {
//                    pos.setSoundBrand(soundBrand);
//                }
//
//                // Receive new price
//                System.out.print("Enter the new price: ");
//                double price = scanner.nextDouble();
//                // Price > 0
//                if (price > 0) {
//                    pos.setPrice(price);
//                }
//            }
        }
    }

//(*)Sơn: Check brandID co bi lap hay khong
    public boolean codeNotDuplicated(String code) {
        code = code.trim().toUpperCase();
        return searchID(code) != null;
    }

    public void addBrand() {
        Inputter inp = new Inputter();
        Brand newBr = new Brand();
        String newID;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Please input brand ID:");
            newID = sc.nextLine();
        } while (codeNotDuplicated(newID) == true);
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
        if (this.isEmpty() == true) {
            System.out.println("Brand list is empty!");
        } else {
            for (Brand brand : this) {
                System.out.println(brand);
            }
        }
    }

//(!)Dương: updateCar khi update Brand sẽ sử dụng hàm này
    public Brand getUserChoice() {
        Menu mn = new Menu();
        Brand result = (Brand) mn.ref_getChoice(this);
        return result;
    }
    
    public void save() {
        String desktopPath = System.getProperty("user.home") + "/Desktop";
        String filePath = desktopPath + "/brands.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Brand brand : this) {
                String line = brand.getBrandID() + "," + brand.getBrandName() + "," + brand.getSoundBrand() + "," + brand.getPrice();
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error occurred while saving brands: " + e.getMessage());
        }
    }

    public static BrandList load() {
        String desktopPath = System.getProperty("user.home") + "/Desktop";
        String filePath = desktopPath + "/brands.txt";
        BrandList brandList = new BrandList();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String id = parts[0];
                String brandName = parts[1];
                String soundBrand = parts[2];
                double price = Double.parseDouble(parts[3]);

                Brand brand = new Brand(id, brandName, soundBrand, price);
                brandList.add(brand);
            }
        } catch (IOException e) {
            System.out.println("Error occurred while loading brands: " + e.getMessage());
            return null;
        }

        return brandList;
    }
}
