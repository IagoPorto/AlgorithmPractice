class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> numberOccurrences = new HashMap<>();
        List<Integer> ocurrences = new ArrayList<>();
        
        for(int n : arr){
            if (numberOccurrences.containsKey(n)) {
                numberOccurrences.put(n, numberOccurrences.get(n) + 1);
            } else {
                numberOccurrences.put(n, 1);
            }
        }
        for(int key : numberOccurrences.keySet()){
            if(ocurrences.contains(numberOccurrences.get(key))){
                return false;
            }
            ocurrences.add(numberOccurrences.get(key));
        }
        return true;
    }
}
