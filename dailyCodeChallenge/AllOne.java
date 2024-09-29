/**
Design a data structure to store the strings' count with the ability to return the strings with minimum and maximum counts.

Implement the AllOne class:

AllOne() Initializes the object of the data structure.
inc(String key) Increments the count of the string key by 1. If key does not exist in the data structure, insert it with count 1.
dec(String key) Decrements the count of the string key by 1. If the count of key is 0 after the decrement, remove it from the data structure. It is guaranteed that key exists in the data structure before the decrement.
getMaxKey() Returns one of the keys with the maximal count. If no element exists, return an empty string "".
getMinKey() Returns one of the keys with the minimum count. If no element exists, return an empty string "".
Note that each function must run in O(1) average time complexity.

 

Example 1:

Input
["AllOne", "inc", "inc", "getMaxKey", "getMinKey", "inc", "getMaxKey", "getMinKey"]
[[], ["hello"], ["hello"], [], [], ["leet"], [], []]
Output
[null, null, null, "hello", "hello", null, "hello", "leet"]

Explanation
AllOne allOne = new AllOne();
allOne.inc("hello");
allOne.inc("hello");
allOne.getMaxKey(); // return "hello"
allOne.getMinKey(); // return "hello"
allOne.inc("leet");
allOne.getMaxKey(); // return "hello"
allOne.getMinKey(); // return "leet"
 

Constraints:

1 <= key.length <= 10
key consists of lowercase English letters.
It is guaranteed that for each call to dec, key is existing in the data structure.
At most 5 * 104 calls will be made to inc, dec, getMaxKey, and getMinKey.
**/


import java.util.HashMap;
import java.util.Map;

public class AllOne {

    private Map<String, Integer> map;
    private String max;
    private String min;
    private Integer countMax;
    private Integer countMin;

    public AllOne() {
        this.countMax = 0;
        this.countMin = Integer.MAX_VALUE;
        this.max = "";
        this.min = "";
        this.map = new HashMap<>();
    }
    
    public void inc(String key) {
        int n = map.getOrDefault(key, 0) + 1;
        map.put(key, n);
        this.updateMinMax(key);
    }
    
    public void dec(String key) {
        if (!map.containsKey(key)) return;  // Clave no existe
        int n = this.map.get(key) - 1;
        if (n > 0) {
            this.map.put(key, n);
        } else {
            this.map.remove(key);
        }
        this.updateMinMax(key);
    }

    private void updateMinMax(String key) {
        // Reset variables temporales para encontrar mínimo y máximo
        final int[] minValue = {Integer.MAX_VALUE};
        final String[] minKey = {""};
        final int[] maxValue = {Integer.MIN_VALUE};
        final String[] maxKey = {""};
        
        this.map.forEach((k, v) -> {
            if (v < minValue[0]) {
                minValue[0] = v;
                minKey[0] = k;
            }
            if (v > maxValue[0]) {
                maxValue[0] = v;
                maxKey[0] = k;
            }
        });

        // Actualiza el mínimo y el máximo
        if (minValue[0] == Integer.MAX_VALUE) {
            this.countMin = 0;
            this.min = "";
            this.countMax = 0;
            this.max = "";
        } else {
            this.countMin = minValue[0];
            this.min = minKey[0];
            this.countMax = maxValue[0];
            this.max = maxKey[0];
        }
    }
    
    public String getMaxKey() {
        return this.max;
    }
    
    public String getMinKey() {
        return this.min;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
