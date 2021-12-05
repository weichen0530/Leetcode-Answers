public class Solution {
    public int MinimumTotal(IList<IList<int>> triangle) {
        if(triangle.Count == 1) return triangle[0][0];
        IDictionary<Tuple<int, int>, int> memo = new Dictionary<Tuple<int,int>, int>();
        return divideConquer(triangle, 0, 0, memo);
    }
    private int divideConquer(IList<IList<int>> triangle, int x, int y, IDictionary<Tuple<int, int>, int> memo){
        if(x == triangle.Count) return 0;
        Tuple<int, int> key = new Tuple<int, int>(x,y);
        if(memo.ContainsKey(key)) return memo[key];
        int left = divideConquer(triangle, x+1, y, memo);
        int right = divideConquer(triangle, x+1, y+1, memo);
        memo.Add(key, Math.Min(left, right) + triangle[x][y]);
        return memo[key];
    }
	
	// DP Bottom To Top
	public int MinimumTotal(IList<IList<int>> triangle) {
        int n = triangle.Count;
        if(n == 1) return triangle[0][0]; 
        int[,] dp = new int[n,n];
        for(int i = 0; i < n; i++){
            dp[n-1,i] = triangle[n-1][i];
        }
        for(int i = n-2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                dp[i,j] = Math.Min(dp[i+1,j], dp[i+1,j+1])+triangle[i][j];
            }
        }
        return dp[0,0];
    }
	
	// DP Top To Bottom
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