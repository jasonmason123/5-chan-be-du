import java.util.*;
import java.lang.*;

public class Menu {
    public int int_getChoice (ArrayList options) {
        int response;
        for (int i=0; i<options.size(); i++) {
            System.out.println((i+1) + "-" + options.get(i));
        }
        System.out.println("Please choose an option 1..." + options.size() + ":");
        Scanner sc = new Scanner(System.in);
        response = sc.nextInt();
        return response;
    }
    
    public Object ref_getChoice (ArrayList options) {
        int response;
        do {
            response = int_getChoice(options);
        } while (response < 0 || response > options.size());
        return options.get(response-1);
    }
}
