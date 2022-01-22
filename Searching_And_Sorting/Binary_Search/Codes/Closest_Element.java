//This code is taken from heaters question so variables are wrt to that.

public class Solution {
   private int closest(int[] heaters, int house) {
        int lb = lowerBound(heaters,house);
        if(lb == heaters.length) return heaters[lb-1];
        else if(lb == 0) return heaters[0];
        
        else if(Math.abs(house-heaters[lb]) < Math.abs(house-heaters[lb-1])) {
            return heaters[lb];
        }
        
        else return heaters[lb-1];
    }
}
}
