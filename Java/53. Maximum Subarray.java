public class Solution {
	// educative
    public int MaxSubArray(int[] nums) {
        if(nums == null || nums.Length == 0)
            return 0;
        
        int res = 0;
        int[] temp = new int[nums.Length];
        temp[0] = nums[0];
        for(int i = 1; i < nums.Length; i++){
            temp[i] = Math.Max(nums[i], nums[i] + temp[i-1]);
        }
        res = temp.Max();
        return res;
    }
	
	//leetcode
	public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        if(nums.length == 1) return nums[0];
        int maxToCurrPos = nums[0], maxSoFar = nums[0];
        for(int i = 1; i < nums.length; i++){
            maxToCurrPos = Math.max(nums[i], maxToCurrPos + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxToCurrPos);
        }
        return maxSoFar;
    }
}