class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        
        HashMap<String,String>map=new HashMap<>();

        for(List<String>x:knowledge)
            map.put(x.get(0),x.get(1));

            StringBuilder sb=new StringBuilder();

            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='('){
                    int j=s.indexOf(')',i);
                    String k=s.substring(i+1,j);

                    sb.append(map.getOrDefault(k,"?"));
                    i=j;
            }else {
                sb.append(s.charAt(i));
            }
    }
            return sb.toString();
}
}