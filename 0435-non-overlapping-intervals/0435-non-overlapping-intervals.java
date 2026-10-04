class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> a[1]-b[1]);
        int n=intervals.length;
        int count=0,last=intervals[0][1];
        for(int i=1;i<n;i++){
            if(last> intervals[i][0]){
                count++;
            }
            else last=intervals[i][1];
        }
        return count;
    }
}