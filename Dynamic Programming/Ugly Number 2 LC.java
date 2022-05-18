class Solution {
    public int nthUglyNumber(int n) {
        int ptr2 = 1,ptr3 = 1,ptr5 = 1;
        List<Integer> ugly = new ArrayList<>();
        ugly.add(-1); //to fill the 0th index
        ugly.add(1); //to add the first ugly no at 1st index
        
        for(int i=2;i<=n;i++) {
            int a = ugly.get(ptr2) * 2;
            int b = ugly.get(ptr3) * 3;
            int c = ugly.get(ptr5) * 5;
            int min = Math.min(a,Math.min(b,c));
            ugly.add(min);
            if(min == a) ptr2++;
            if(min == b) ptr3++;
            if(min == c) ptr5++;
        }
        
        return ugly.get(n);
    }
}
