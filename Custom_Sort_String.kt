/**
 * Custom Sort String
 *
 * 156ms 35.5MB
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
}
