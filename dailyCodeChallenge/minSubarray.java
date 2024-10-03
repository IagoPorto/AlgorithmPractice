/**
Given an array of positive integers nums, remove the smallest subarray (possibly empty) such that the sum of the remaining elements is divisible by p. It is not allowed to remove the whole array.

Return the length of the smallest subarray that you need to remove, or -1 if it's impossible.

A subarray is defined as a contiguous block of elements in the array.

 

Example 1:

Input: nums = [3,1,4,2], p = 6
Output: 1
Explanation: The sum of the elements in nums is 10, which is not divisible by 6. We can remove the subarray [4], and the sum of the remaining elements is 6, which is divisible by 6.

Example 2:

Input: nums = [6,3,5,2], p = 9
Output: 2
Explanation: We cannot remove a single element to get a sum divisible by 9. The best way is to remove the subarray [5,2], leaving us with [6,3] with sum 9.

Example 3:

Input: nums = [1,2,3], p = 3
Output: 0
Explanation: Here the sum is 6. which is already divisible by 3. Thus we do not need to remove anything.

 

Constraints:

    1 <= nums.length <= 105
    1 <= nums[i] <= 109
    1 <= p <= 109


**/
/**
El algoritmo calcula la suma total del array y su resto al dividir por p. 
Si el resto es cero, no se necesita eliminar nada. Si no, utiliza un HashMap para 
almacenar las sumas de prefijos y sus índices. Al recorrer el array, se calcula la suma 
acumulada y se determina un target que representa el valor necesario para que la suma 
restante sea divisible por p. Si este target se encuentra en el mapa, se actualiza la 
longitud mínima del subarray a eliminar. Finalmente, se devuelve la longitud más corta
encontrada, o -1 si no es posible eliminar un subarray que logre la divisibilidad.
**/
class Solution {
    public int minSubarray(int[] nums, int p) {
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        long remainder = totalSum % p;
        if (remainder == 0) {
            return 0;
        }

        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);

        long currentSum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            long target = (currentSum % p - remainder + p) % p;

            if (map.containsKey(target)) {
                minLength = Math.min(minLength, i - map.get(target));
            }

            map.put(currentSum % p, i);
        }

        return minLength == Integer.MAX_VALUE || minLength == nums.length ? -1 : minLength;
   
    }
}
