public class Solution {
    /**
     * @param nums: an array of Integer
     * @param target: an integer
     * @return: [num1, num2] (index1 < index2)
     */
    public int[] twoSum7(int[] nums, int target) {
        // write your code here
        int left = 0;
        int right= 1;

        while(left < nums.length && right<nums.length) {
            if(left == right) {
                if(target < 0) {
                   left++;
                } else {
                    right++;
                }
            }

            if(nums[right] - nums[left] == target) {
                int min = Math.min(nums[left],nums[right]);
                int max = Math.max(nums[left],nums[right]);
                return new int[]{min,max};
            } else if(nums[right] - nums[left] < target) {
                right++;
            } else {
                left++;
            }
        }

        return null;

    }
}
