/**
 * Easy 1446. Consecutive Characters
 * https://leetcode.com/problems/consecutive-characters/
 */
class Solution {
    fun maxPower(s: String): Int {
        var max = 1
        var count = 1
        var lastAlpha = ' '
        for(c in s){
            if(c == lastAlpha){
                max = Math.max(max, ++count)
            }else{
                count = 1
            }
            lastAlpha = c
        }
        return max
    }
}
