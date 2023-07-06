import java.util.*;
import java.lang.*;

//(*)Sơn: Thêm class inputter để nhập vào dữ liệu theo đúng yêu cầu. Dùng như Scanner
//E.g: 
//Inputter inp = new Inputter();
//inp.inputNotBlank();
public class Inputter {
    public String inputNotBlank() {
        Scanner sc = new Scanner(System.in);
        String brandName;
        do {
            System.out.println("(*)Please input:");
            brandName = sc.nextLine().trim();
        } while (brandName.isEmpty() == true);
        return brandName;
    }
    
    public double inputPrice() {
        double price;
        do {
            try{
                System.out.println("(*)Please input price: ");
                Scanner sc = new Scanner(System.in);
                price = sc.nextDouble();
            }
            catch (Exception e) {
                price = -1;
            }    
        } while (price < 0);
        return price;
    }

//(*)Sơn: input ID which require inputing in the correct format
//Chỉ những ID nào yêu cầu phải nhập đúng format (FrameID, EngineID) mới cần sử dụng hàm này, còn lại không cần
//Format FrameID: "[fF][\\d]{4}"
//Format EngineID: "[eE][\\d]{4}"
    public String inputIDPattern (String pattern) {
        Scanner sc = new Scanner(System.in);
        String ID;
        do {
            System.out.println("(*)Please input ID:");
            ID = sc.nextLine();
        } while (ID.matches(pattern) == false);
        return ID;
    }
    
    //tmt them vao de chay thu cai menu
    public static int inputInt(String msg, int min, int max) {
        Scanner sc = new Scanner(System.in);
        if (min > max) {
            int temp = min;
            min = max;
            max = temp;
        }

        int data = Integer.MIN_VALUE;

        while (true) {
            try {
                if (msg != null) {
                    System.out.println(msg);
                }

                data = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
            }

            if (data >= min && data <= max) {
                break;
            }
        }

        return data;
    }
}
