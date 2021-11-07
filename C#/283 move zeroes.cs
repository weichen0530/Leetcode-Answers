public class Solution {
    public void MoveZeroes(int[] nums) {
        if(nums == null || nums.Length == 0) return;
        int zeroIndex = 0, searchIdx = 0;
        while(searchIdx < nums.Length){
            if(nums[searchIdx] == 0){
                searchIdx++;
            }else{
                nums[zeroIndex++] = nums[searchIdx++];
            }
        }
        for(int i = zeroIndex; i < nums.Length; i++){
            nums[i] = 0;
        }
    }
}