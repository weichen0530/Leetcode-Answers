class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        int insertIndex = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i < k; i++){
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.removeLast();
            }
            dq.offerLast(i);
        }
        for(int i = k; i < nums.length; i++){
            res[insertIndex++] = nums[dq.peek()];
            // remove all index not in the curr window
            while(!dq.isEmpty() && dq.peek() <= i-k){
                dq.removeFirst();
            }
            // remove all value that less than the curr value
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.removeLast();
            }
            dq.offer(i);
        }
        res[insertIndex] = nums[dq.peek()];
        return res;
    }
}