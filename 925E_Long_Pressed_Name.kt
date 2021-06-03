/**
 * Easy 925. Long Pressed Name
 * https://leetcode.com/problems/long-pressed-name/
 *
 * 240 ms, 34.5 MB
 */
class Solution {
    fun isLongPressedName(name: String, typed: String): Boolean {
        if(name.length == typed.length) return name == typed
        
        val nameCharList = name.toCharPairs()
        val typedCharList = typed.toCharPairs()
        
        if(nameCharList.size != typedCharList.size) return false
        
        for((index, namePair) in nameCharList.withIndex()) {
            val typedPair = typedCharList[index]
            if(namePair.first != typedPair.first) return false
            if(namePair.second > typedPair.second) return false
        }
        
        return true
    }
    
    fun String.toCharPairs(): List<Pair<Char, Int>> {
        val pairs = mutableListOf<Pair<Char, Int>>()
        var curChar = this[0]
        var curCharCount = 0
        var i = 0
        while(i < this.length) {
            val c = this[i]
            if(c == curChar) {
                ++curCharCount
            } else {
                pairs.add(Pair(curChar, curCharCount))
                curCharCount = 0
                curChar = c
                continue
            }
            
            if(i == this.length - 1) {
                pairs.add(Pair(curChar, curCharCount))
            }
            
            ++i
        }
        return pairs
    }
}
