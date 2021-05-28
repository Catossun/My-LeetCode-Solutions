/**
 * Easy 8. String to Integer (atoi)
 * https://leetcode.com/problems/string-to-integer-atoi/
 */
class Solution {
    fun myAtoi(s: String): Int {
        val INT_MAX = 2147483647
        val INT_MIN = -2147483648
        
        var isPositive = true
        var readCount = 0
        var result = 0L
        
        loop@ for(c in s){
            when(c){
                ' ', '"' -> {
                    if(readCount >= 1){
                        break@loop
                    } else {
                        continue@loop
                    }
                }
                '+' -> {
                    isPositive = true
                    readCount++
                    if(readCount > 1){
                        break@loop
                    }
                }
                '-' -> {
                    isPositive = false
                    readCount++
                    if(readCount > 1){
                        break@loop
                    }
                }
                in '0'..'9' -> {
                    readCount++
                    val num = (c - '0').toInt()
                    result *= 10
                    result += if(isPositive) num else -num
                    if(result > INT_MAX){
                        result = INT_MAX.toLong()
                        break@loop
                    } else if(result < INT_MIN){
                        result = INT_MIN.toLong()
                        break@loop
                    }
                }
                else -> break@loop
            }
        }
        
        return result.toInt()
    }
}
