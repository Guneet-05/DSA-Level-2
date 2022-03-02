
class Solution{
    static int maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        // code here
        if(K > N) return 0;
        
        int sum = 0;
        for(int i=0;i<K;i++) {
            sum += Arr.get(i);
        }
        
        int maxSum = sum;
        for(int i=1;i<=N-K;i++) {
            sum = sum - Arr.get(i-1) + Arr.get(i+K-1);
            maxSum = Math.max(maxSum,sum); 
        }
        
        return maxSum;
    }
}
