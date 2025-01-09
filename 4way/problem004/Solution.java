class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> nInNums1 = new ArrayList<>();
        List<Integer> nInNums2 = new ArrayList<>();
        Set<Integer> n1 = new HashSet<>();
        Set<Integer> n2 = new HashSet<>();

        for(int n : nums1){
            n1.add(n);
        }


        for(int n : nums2){
            n2.add(n);
        }

        for(int n : n1){
            if(!n2.contains(n)){
                nInNums1.add(n);
            }
        }

        for(int n : n2){
            if(!n1.contains(n)){
                nInNums2.add(n);
            }
        }

        result.add(nInNums1);
        result.add(nInNums2);

        return result;
    }
}
