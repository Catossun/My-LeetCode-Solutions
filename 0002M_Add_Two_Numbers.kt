/**
 * 2. Add Two Numbers
 * https://leetcode.com/problems/add-two-numbers/
 *
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val num1 = l1!!.toIntArray()
        val num2 = l2!!.toIntArray()
        val sum = num1 + num2
        return sum.toListNode()
    }
    
    fun ListNode.toIntArray(): IntArray{
        val result = mutableListOf<Int>()
        var curListNode: ListNode? = this
        while(curListNode != null){
            result.add(curListNode.`val`)
            curListNode = curListNode.next
        }
        return result.toIntArray()
    }
    
    operator fun IntArray.plus(addWith: IntArray): IntArray{
        val result = mutableListOf<Int>()
        val maxSize = Math.max(this.size, addWith.size)
        var addOne = false
        for(i in 0..maxSize-1){
            val num1 = if(i < this.size) this[i] else 0
            val num2 = if(i < addWith.size) addWith[i] else 0
            val sum = num1 + num2 + if(addOne) 1 else 0
            addOne = sum >= 10
            result.add(if(addOne) sum - 10 else sum)
        }
        if(addOne) result.add(1)
        return result.toIntArray()
    }
    
    fun IntArray.toListNode(): ListNode{
        val result = ListNode(this[0])
        var curListNode = result
        this.forEachIndexed{ index, num ->
            if(index != 0){
                curListNode.next = ListNode(this[index])
                curListNode = curListNode.next
            }
        }
        return result
    }
}
