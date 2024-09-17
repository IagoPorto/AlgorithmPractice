class Solution {
    public int lengthOfLongestSubstring(String s) {

        int maxLength = 0;
        StringBuilder substring = new StringBuilder();

        for (int end = 0; end < s.length(); end++) {

            while (substring.indexOf(Character.toString(s.charAt(end))) != -1) {
                substring.deleteCharAt(0);
            }

            substring.append(Character.toString(s.charAt(end)));
            System.out.println(substring);
            maxLength = Math.max(maxLength, substring.length());

        }

        return maxLength;

    }
}
