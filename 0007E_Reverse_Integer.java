/**
 * Easy 7. Reverse Integer
 * https://leetcode.com/problems/reverse-integer/
 */
class Solution {
    public int reverse(int x) {
        long n = x;
        boolean isNegative = n < 0;
        if(isNegative) n = -n;
        long rN = 0;
        while(n != 0){
            rN *= 10;
            rN += n % 10;
            n /= 10;
        }
        rN  = isNegative ? -rN : rN;
        if(rN > Integer.MAX_VALUE || rN < Integer.MIN_VALUE) return 0;
        return (int)rN;
    }
}
