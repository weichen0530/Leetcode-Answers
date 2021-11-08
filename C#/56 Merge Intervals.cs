public class Solution {
    public int[][] Merge(int[][] intervals) {
        if(intervals == null || intervals.Length < 2) return intervals;
        Array.Sort(intervals, (arr1, arr2) => arr1[0].CompareTo(arr2[0]));
        List<int[]> res = new List<int[]>();
        int[] currInterval = intervals[0];
        res.Add(currInterval);
        foreach(int[] i in intervals){
            if(i[0] <= currInterval[1]){
                currInterval[1] = Math.Max(i[1], currInterval[1]);
            }else{
                currInterval = i;
                res.Add(currInterval);
            }
        }
        return res.ToArray();
    }
}