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
}