class Solution
{
    public static class MyComparator implements Comparator<Job> {
        
        public int compare(Job obj1, Job obj2) {
            //decreasing order of profit
            if(obj1.profit == obj2.profit) return obj2.deadline - obj1.deadline;
            return obj2.profit - obj1.profit;
        }
    } 
    
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        Arrays.sort(arr,new MyComparator());
        int maxDeadLine = 0;
        
        for(int i=0;i<n;i++) {
            maxDeadLine = Math.max(maxDeadLine,arr[i].deadline);
        }
        
        boolean[] slots = new boolean[maxDeadLine];
        int maxProfit = 0;
        int jobsAllocated = 0;
        
        for(int i=0;i<n;i++) {
            //can we place ith Job
            for(int j=arr[i].deadline-1;j>=0;j--) {
                if(slots[j] == false) {
                    slots[j] = true;
                    jobsAllocated++;
                    maxProfit += arr[i].profit;
                    break;
                }
            }
        }
        
        int[] res = new int[2];
        res[0] = jobsAllocated;
        res[1] = maxProfit;
        
        return res;
    }
}
