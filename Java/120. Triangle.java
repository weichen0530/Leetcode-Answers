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
}