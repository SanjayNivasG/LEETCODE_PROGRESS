class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        
        int []c=new int[2001];
        boolean []seen= new boolean[1001];

        for(int k:arr){
            c[k+1000]++;
        }

        for(int i=0;i<2001;i++){
            if(c[i]>0){
                if(seen[c[i]]){
                    return false;
                }
                seen[c[i]]=true;
            }
        }
        return true;
    }
}