/**
Given two binary strings a and b, return their sum as a binary string.

 

Example 1:

Input: a = "11", b = "1"
Output: "100"

Example 2:

Input: a = "1010", b = "1011"
Output: "10101"

 

Constraints:

    1 <= a.length, b.length <= 104
    a and b consist only of '0' or '1' characters.
    Each string does not contain leading zeros except for the zero itself.


**/

class Solution {
    public String addBinary(String a, String b) {
        String result = "";
        if(a.length() != b.length()){
            int l;
            if(a.length() < b.length()){
                l = b.length() - a.length();
                for(int i = 0; i < l; i++){
                    a = "0" + a;
                }
            }else{
                l = a.length() - b.length();
                for(int i = 0; i < l; i++){
                    b = "0" + b;
                }
            }
        }
        int c = 0;
        for(int i = (a.length() - 1); i >= 0; i--){
            int aNumber = a.charAt(i) - '0';
            int bNumber = b.charAt(i) - '0';
            int r = aNumber + bNumber + c;
            if(r > 1){
                c = 1;
                if(r == 2){
                    r = 0;
                }else{
                    r = 1;
                }
            }else{
                c = 0;
            }
            result = r + result;
        }
        if(c > 0){
            result = c + result;
        }
        return result;
    }
}
