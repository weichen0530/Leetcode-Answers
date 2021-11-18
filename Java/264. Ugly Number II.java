class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        Set<Long> seen = new HashSet<Long>();
        heap.add(1L);
        seen.add(1L);
        int[] factors = new int[]{2,3,5};
        long currUgly = 1, newUgly;
        for(int i = 1; i <= n; i++){
            currUgly = heap.poll();
            for(int factor:factors){
                newUgly = currUgly * factor;
                if(!seen.contains(newUgly)){
                    heap.add(newUgly);
                    seen.add(newUgly);
                }
            }
        }
        return (int)currUgly;
    }
	
	// dynamic programming
	public int nthUglyNumber(int n) {
        if(n <= 0) return -1;
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for(int i = 1; i < n; i++){
            dp[i] = Math.min(Math.min(dp[p2]*2, dp[p3]*3), dp[p5]*5);
            if(dp[i] == dp[p2]*2) p2++;
            if(dp[i] == dp[p3]*3) p3++;
            if(dp[i] == dp[p5]*5) p5++;
        }
        return dp[n-1];
    }
}