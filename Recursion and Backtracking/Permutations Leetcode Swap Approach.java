class Solution {
    
    public List<List<Integer>> ans = new ArrayList<>();
    
    public void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
    
    public void permute(int[] nums,int currBox) {
        if(currBox == nums.length) {
            List<Integer> curr = new ArrayList<>();
            for(int i=0;i<nums.length;i++) {
                curr.add(nums[i]);
            }
            ans.add(curr);
            return;
        }
        
        for(int i=currBox;i<nums.length;i++) {
            swap(nums,i,currBox);
            permute(nums,currBox + 1);
            swap(nums,i,currBox); //backtracking (because same array is passed)
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        permute(nums,0);
        return ans;
    }
}
