class Solution {
    public List<String> stringMatching(String[] w) {
        
        int n=w.length;
        List<String>v=new ArrayList<>();

        for(int i=0;i<n;++i){
            for(int j=0;j<n;j++){
                if(i!=j && w[j].contains(w[i])){
                    v.add(w[i]);
                     break;
                }
            }
        }
        return v;
    }
}