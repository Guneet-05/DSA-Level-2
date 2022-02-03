class Complete{
    
   
    // Function for finding maximum and value pair
    public static int search (int arr[], int n, int x, int k) {
        //Complete the function
        
        int idx = 0;
        
        while(idx < arr.length) {
            if(arr[idx] == x) return idx;
            
            int jumpSize = ((int)Math.abs(x-arr[idx]))/k;
            if(jumpSize == 0) jumpSize++;
            
            idx += jumpSize;
        }
        
        return -1;
    }
    
    
}
