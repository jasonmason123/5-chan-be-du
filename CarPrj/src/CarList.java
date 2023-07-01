
import java.util.*;
import java.lang.*;

public class CarList extends ArrayList<Car> {

    public int searchID(String carID) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getCarID().equals(carID)) {
                return i;
            }
        }
        return -1;
    }
}
