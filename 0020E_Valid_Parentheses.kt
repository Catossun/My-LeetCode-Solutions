/**
 * Easy 20. Valid Parentheses
 * https://leetcode.com/problems/valid-parentheses/
 */
class Solution {
    fun isValid(s: String): Boolean {
        if(s.length % 2 == 1) return false
        
        val maps = mapOf(
            '(' to ')',
            '[' to ']',
            '{' to '}'
        )
        
        val rightSides = mutableListOf<Char>()
        for(c in s){
            val isLeftSide = maps.keys.contains(c);
            
            if(isLeftSide){
                rightSides.add(maps[c]!!)
            }else{
                if(rightSides.size == 0) return false
                
                if(rightSides[rightSides.lastIndex] == c){
                    rightSides.removeAt(rightSides.lastIndex)
                }else{
                    return false
                }
            }
        }
        
        if(rightSides.size > 0) return false
        
        return true;
    }
}
