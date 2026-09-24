class Solution {
    public int[][] merge(int[][] intervals) {

       Arrays.sort(intervals,(a,b) -> a[0]-b[0]);

       ArrayList<int[]> l=new ArrayList<>();

        int st=intervals[0][0];
        int end=intervals[0][1];

        for(int i=1;i<intervals.length;i++){

            if(intervals[i][0]<=end){
                end=Math.max(end,intervals[i][1]);
            }else{
                l.add(new int[]{st,end});

                st=intervals[i][0];
                end=intervals[i][1];
            }
        }
            l.add(new int[]{st,end});

            return l.toArray(new int[l.size()][]);
    }
}