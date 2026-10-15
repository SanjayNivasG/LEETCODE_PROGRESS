class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[]words=sentence.split(" ");
        String ans="";

        for (String word : words) {
            String rp = word;
            for (String root : dictionary) {
                if (word.startsWith(root)) {
                    if (rp.equals(word) || root.length() < rp.length()) {
                        rp = root;
                    }
                }
            }

            if (!ans.isEmpty()) {
                ans+= " ";
            }
            ans+=rp;
        }
        return ans;
    }
}