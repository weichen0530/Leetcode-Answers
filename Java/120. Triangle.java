class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        Map<Pair<Integer, Integer>,Integer> memo = new HashMap<Pair<Integer, Integer>, Integer>();
        return divideConquer(triangle, 0, 0, memo);
    }
    
    private int divideConquer(List<List<Integer>> triangle, int x, int y, Map<Pair<Integer, Integer>,Integer> memo){
        if(x == triangle.size()) return 0;
        Pair<Integer, Integer> key = new Pair<Integer, Integer>(x,y);
        if(memo.containsKey(key)) return memo.get(key);
        int left = divideConquer(triangle, x+1, y, memo);
        int right = divideConquer(triangle, x+1, y+1, memo);
        memo.put(key, Math.min(left, right) + triangle.get(x).get(y));
        return memo.get(key);
    }
	
	// DP Bottom To Top
	// only one situation 
	public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 1) return triangle.get(0).get(0);
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            dp[n-1][i] = triangle.get(n-1).get(i);
        }
        for(int i = n-2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
	
	// DP Top To Bottom
	// Need to Handle 3 cases
	// left most nodes
	// right most nodes
	// regular nodes
	public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 1) return triangle.get(0).get(0);
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for(int i = 1; i < n; i++){
            dp[i][0] = dp[i-1][0] + triangle.get(i).get(0);
            dp[i][i] = dp[i-1][i-1] + triangle.get(i).get(i);
        }
        if(n > 2){
            for(int i = 2; i <n ; i++){
                for(int j = 1; j <= i-1; j++){
                    dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + triangle.get(i).get(j);
                }
            }
        }
        int result = dp[n-1][0];
        for(int i = 1; i < n; i++){
            result = Math.min(result, dp[n-1][i]);
        }
        return result;
    }
}