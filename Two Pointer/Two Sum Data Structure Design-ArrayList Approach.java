public class TwoSum {
    
    List<Integer> data;
    boolean isSorted;
    public TwoSum() {
       data = new ArrayList<>();
       isSorted = true;
    }

    public void add(int number) {
        // write your code here
        data.add(number);
        isSorted = false;
    }

    
    public boolean find(int value) {
        // write your code here
        if(isSorted == false) {
            Collections.sort(data);
        }

        int lo = 0;
        int hi = data.size()-1;

        while(lo < hi) {
            int sum = data.get(lo) + data.get(hi);
            if(sum == value) return true;
            else if(sum < value) lo++;
            else hi--;
        }

        return false;
    }
}
