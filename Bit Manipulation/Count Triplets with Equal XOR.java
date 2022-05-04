class Solution {
    public int countTriplets(int[] arr) {
        int count = 0;
        
        for(int i=0;i<arr.length;i++) {
            int xor = arr[i];
            for(int k=i+1;k<arr.length;k++) {
                xor = xor ^ arr[k];
                if(xor == 0) {
                    count += (k-i); //these are the number of triplets
                }
            }
        }
        
        return count;
    }
}
