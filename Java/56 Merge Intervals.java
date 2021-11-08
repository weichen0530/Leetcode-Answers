class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length < 2) return intervals;
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        List<int[]> res = new ArrayList();
        int[] currInterval = intervals[0];
        res.add(currInterval);
        for(int[] i : intervals){
            if(i[0] <= currInterval[1]){
                currInterval[1] = Math.max(i[1], currInterval[1]);
            }else{
                currInterval = i;
                res.add(currInterval);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}