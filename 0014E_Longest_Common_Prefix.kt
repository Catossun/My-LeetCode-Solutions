/**
 * Easy 14. Longest Common Prefix
 * https://leetcode.com/problems/longest-common-prefix/
 */
class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        if(strs.size == 1) return strs[0]
        
        val firstStr = strs[0]
        if(firstStr.length == 0) return firstStr
        
        var prefix = ""
        for(c:Char in firstStr){
            prefix += c
            if(strs.all{it.startsWith(prefix)}){
                continue
            }else{
                prefix = prefix.substring(0, prefix.length - 1)
                break
            }
        }
        return prefix
    }
}
