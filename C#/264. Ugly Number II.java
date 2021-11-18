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
}