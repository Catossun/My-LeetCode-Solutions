/**
 * Easy 762. Prime Number of Set Bits in Binary Representation
 * https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/
 *
 * 376 ms 65.9 MB
 */
 class Solution {
    fun countPrimeSetBits(left: Int, right: Int): Int {
        var count = 0
        for(i in left..right) {
            val bits = i.toString(2)
            val setBitsCount = bits.count{ it == '1' }
            if(checkIsPrime(setBitsCount)) ++count
        }
        return count
    }
    
    fun checkIsPrime(n:Int): Boolean {
        if(n == 1) return false
        for(i in 2 until n) {
            if(n % i == 0) return false
        }
        return true
    }
}
