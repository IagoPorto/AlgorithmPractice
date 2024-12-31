class Solution {
    public boolean isSubsequence(String s, String t) {
        int sIndex = 0;
        int tIndex = 0;
        int sLen = s.length();
        int tLen = t.length();
        while(sIndex < sLen && tIndex < tLen){
            if(s.charAt(sIndex) == t.charAt(tIndex)){
                sIndex++;
            }
            
            tIndex++;
        }

        return sIndex == sLen;
    }
}
