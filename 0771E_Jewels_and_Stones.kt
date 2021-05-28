/**
 * Easy 771. Jewels and Stones
 * https://leetcode.com/problems/jewels-and-stones/
 */
class Solution {
    fun numJewelsInStones(J: String, S: String): Int {
        var count = 0
        for(s in S){
            for(j in J){
                if(s == j){
                    ++count
                    break
                }
            }
        }
        return count
    }
}