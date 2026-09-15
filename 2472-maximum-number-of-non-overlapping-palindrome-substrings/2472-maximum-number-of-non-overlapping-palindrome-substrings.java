class Solution {
    public int maxPalindromes(String s, int k) {
        
        int n=s.length();
        if(k==1) return n;
    
    int ans=0;

    for(int i=0;i<=n-k;i++){
        if(ck(s,i,i+k-1)){
            ans++;
            i+=k-1;
        }else if(i+k<n && ck(s,i,i+k)){
            ans++;
            i+=k;
        }
    }
    return ans;
}

    boolean ck(String s,int l,int r){
        while(l<r){
            if(s.charAt(l)!=s.charAt(r))
            return false;

            l++;
            r--;
        }
        return true;
    }
}