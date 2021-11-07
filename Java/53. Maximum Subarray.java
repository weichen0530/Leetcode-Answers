public class Solution {
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
}