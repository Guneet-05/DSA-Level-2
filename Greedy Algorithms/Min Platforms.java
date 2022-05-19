class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dept[], int n)
    {
        // add your code here

        Arrays.sort(arr);
        Arrays.sort(dept);

        int platforms = 0, maxPlatforms = 0, i = 0, j = 0;

        while(i < arr.length) {
            if(arr[i] <= dept[j]) {
                i++;
                platforms++;
            } else if(arr[i] > dept[j]) {
                j++;
                platforms--;
            }
          
          maxPlatforms = Math.max(platforms,maxPlatforms);

        }

        return maxPlatforms;
    }
    
}
