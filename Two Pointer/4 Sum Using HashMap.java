class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //sum against all the pairs with that sum
        HashMap<Integer,List<List<Integer>>> AB = new HashMap<>();
        
        int n = nums.length;
    //we have to store the indices of the pair and not the values to check for duplicates later
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                int sum = nums[i] + nums[j];
                List<Integer> pair = new ArrayList<>();
                pair.add(i);pair.add(j);
                if(AB.containsKey(sum) == false) {
                    List<List<Integer>> temp = new ArrayList<>();
                    AB.put(sum,temp);
                }
                AB.get(sum).add(pair);
            }
        }
        
        HashSet<List<Integer>> hs = new HashSet<>(); //to check for uniqueness
        
        for(int p=0;p<n;p++) {
            for(int q=p+1;q<n;q++) {
                int remTarget = target - nums[p] - nums[q];
                if(AB.containsKey(remTarget) == false) {
                    continue;
                }
                for(List<Integer> pair : AB.get(remTarget)) {
                    if(p != pair.get(0) && p!= pair.get(1) && q!=pair.get(0) && q!=pair.get(1)) {
                        List<Integer> quad = new ArrayList<>();
                        quad.add(nums[p]);
                        quad.add(nums[q]);
                        quad.add(nums[pair.get(0)]);
                        quad.add(nums[pair.get(1)]);
                        Collections.sort(quad);
                        hs.add(quad);
                    }
                }
            }
        }
        
        List<List<Integer>> res = new ArrayList<>();
        for(List<Integer> quad: hs) {
            res.add(quad);
        }
        
        return res;
    }
}
