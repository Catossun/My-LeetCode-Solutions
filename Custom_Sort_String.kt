/**
 * Custom Sort String
 * https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/609/week-2-july-8th-july-14th/3813/
 *
 * 1. 156 ms 35.5 MB
 * 2. 136 ms 33.7 MB
 */
class Solution {
    fun customSortString(order: String, str: String): String {
        val alphaCount = Array<Int>(order.length) { 0 }
        val noOrderedStr = StringBuilder()
        str.forEach {
            val index = order.indexOf(it)
            if(index != -1) {
                ++alphaCount[index]
            } else {
                noOrderedStr.append(it)
            }
        }
        
        val result = StringBuilder()
        order.forEachIndexed { index, c ->
            repeat(alphaCount[index]) {
                result.append(c)
            }
        }
        result.append(noOrderedStr.toString())
        return result.toString()
    }

    fun customSortString2(order: String, str: String): String {
        val alphaCount = IntArray(26)
        val result = StringBuilder()
        
        str.forEach {
            ++alphaCount[it - 'a']
        }
        
        order.forEach { c ->
            repeat(alphaCount[c - 'a']) {
                result.append(c)
            }
            alphaCount[c - 'a'] = 0
        }
        
        alphaCount.forEachIndexed { index, count ->
            repeat(count) {
                result.append('a' + index)
            }
        }
        
        return result.toString()
    }
}
