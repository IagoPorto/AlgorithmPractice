/**
You are given a positive integer array skill of even length n where skill[i] denotes the skill of the ith player. Divide the players into n / 2 teams of size 2 such that the total skill of each team is equal.

The chemistry of a team is equal to the product of the skills of the players on that team.

Return the sum of the chemistry of all the teams, or return -1 if there is no way to divide the players into teams such that the total skill of each team is equal.

 

Example 1:

Input: skill = [3,2,5,1,3,4]
Output: 22
Explanation: 
Divide the players into the following teams: (1, 5), (2, 4), (3, 3), where each team has a total skill of 6.
The sum of the chemistry of all the teams is: 1 * 5 + 2 * 4 + 3 * 3 = 5 + 8 + 9 = 22.

Example 2:

Input: skill = [3,4]
Output: 12
Explanation: 
The two players form a team with a total skill of 7.
The chemistry of the team is 3 * 4 = 12.

Example 3:

Input: skill = [1,1,2,3]
Output: -1
Explanation: 
There is no way to divide the players into teams such that the total skill of each team is equal.

 

Constraints:

    2 <= skill.length <= 105
    skill.length is even.
    1 <= skill[i] <= 1000


**/
/**
Intuition

To maximize the result from pairing players based on skill levels, we can try sorting the array and then pairing the lowest with the highest skill. This way, each pair sums to the same target value. If any pair doesn’t match this target sum, it's impossible to form the valid pairs, so we return -1.
Approach

Sort the skill array and use two pointers: one at the start and one at the end. Set the target sum with the first and last elements' sum. Move the pointers inward, checking that each pair matches the target. If they do, add the product of their skills to the result; if not, return -1.
Complexity

    Time complexity: O(N logN)

    Space complexity: O(1)

Code
**/
class Solution {
    public long dividePlayers(int[] skill) {
        
        long output = 0L;

        Arrays.sort(skill);

        int start = 0;
        int end = skill.length - 1;
        int sum = skill[start] + skill[end];

        while(start < end){
            if(skill[start] + skill[end] != sum){
                return -1;
            }

            output += skill[start] * skill[end];

            start++;
            end--;
        }

        return output;

    }
}
