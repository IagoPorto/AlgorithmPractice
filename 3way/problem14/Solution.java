class Solution {
    public int maxVowels(String s, int k) {
        List<Boolean> str = new ArrayList<>();
        int count = 0;
        int max = Integer.MIN_VALUE;
        for(char c : s.toCharArray()){
            str.add(this.isVowel(c));
        }
        for(int i = 0; i < k; i ++){
            if(str.get(i)){
                count++;
            }
        }

        max = count;

        for(int i = k; i < str.size(); i++){
            if(str.get(i - k)){
                count--;
            }
            if(str.get(i)){
                count++;
            }
            max = Math.max(max, count);
        }

        return max;
    }

    private boolean isVowel(char c) {
        char lowerChar = Character.toLowerCase(c);
        return lowerChar == 'a' || lowerChar == 'e' || lowerChar == 'i' ||   
               lowerChar == 'o' || lowerChar == 'u';
    }
}
