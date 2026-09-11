class Solution {
    public int totalNumbers(int[] digits) {
        
        int []f=new int[10];
        for(int k:digits){
            f[k]++;
        }

        int ct=0;
        for(int i=1;i<=9;i++){
            if(f[i]==0) continue;
            f[i]--;

            for(int j=0;j<=9;j++){
                if(f[j]==0) continue;
                f[j]--;

                for(int p=0;p<=8;p+=2){
                    if(f[p]>0){
                        ct++;
                    }
                }
                f[j]++;
            }
            f[i]++;
        }
        return ct;
    }
}