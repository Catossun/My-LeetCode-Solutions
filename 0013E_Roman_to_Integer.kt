/**
 * Easy 13. Roman to Integer
 * https://leetcode.com/problems/roman-to-integer/
 */
class Solution {
    private val symbolMap = mapOf(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000
    )
    
    fun romanToInt(s: String): Int {
        var result = 0
        for(i in 0..s.length-1) {
            val curSymbol = s.get(i)
            if(i + 1 != s.length){
                val nextSymbol = s.get(i+1)
                when(curSymbol){
                    'I' -> {
                        when(nextSymbol){
                            'V', 'X' -> {
                                result -= symbolMap[curSymbol]!!
                            }
                            else -> {
                                result += symbolMap[curSymbol]!!
                            }
                        }
                    }
                    'X' -> {
                        when(nextSymbol){
                            'L', 'C' -> {
                                result -= symbolMap[curSymbol]!!
                            }
                            else -> {
                                result += symbolMap[curSymbol]!!
                            }
                        }
                    }
                    'C' -> {
                        when(nextSymbol){
                            'D', 'M' -> {
                                result -= symbolMap[curSymbol]!!
                            }
                            else -> {
                                result += symbolMap[curSymbol]!!
                            }
                        }
                    }
                    else -> {
                        result += symbolMap[curSymbol]!!
                    }
                }
            } else {
                result += symbolMap[curSymbol]!!
            }
        }
        return result
    }
}
