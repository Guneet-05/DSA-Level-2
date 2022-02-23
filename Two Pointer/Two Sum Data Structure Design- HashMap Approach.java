public class TwoSum {

    HashMap<Integer,Integer> fmap = new HashMap<>();

    public void TwoSum() {
        fmap = new HashMap<>();
    } 

    public void add(int number) {
        // write your code here
        int oFreq = fmap.getOrDefault(number,0);
        fmap.put(number, oFreq+ 1);
    }

    public boolean find(int value) {
        // write your code here
        for(int key : fmap.keySet()) {
            int comp = value - key;
            int compFreq = fmap.getOrDefault(comp,0);
            if(comp == key) {
                if(compFreq >= 2) return true;
            } else {
                if(compFreq > 0) return true;
            }
            
        }

        return false;
    }
}
