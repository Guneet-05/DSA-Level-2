class Solution{
    static int m = 1000000007;
    int Maximize(int arr[], int n)
    {
        // Complete the function
        Arrays.sort(arr);
        long res = 0;
        
        for(int i=0;i<n;i++) {
            res  += (long)arr[i] * i; 
        }
        
        return (int)(res % m);
    }   
}
