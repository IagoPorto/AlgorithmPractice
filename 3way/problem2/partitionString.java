class Solution {
    public int partitionString(String s) {

        int result = 0;
        List<Character> list = new ArrayList<>();

        for(Character a : s.toCharArray()){
            if(list.contains(a)){
                list = new ArrayList<>();
                result++;
            }
            list.add(a);
        }
        if(list.size() > 0){
            result++;
        }
        return result;
    }
}
