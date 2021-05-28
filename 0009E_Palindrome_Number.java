/**
 * Easy 9. Palindrome Number
 * https://leetcode.com/problems/palindrome-number/
 */
class Solution {
    public boolean isPalindrome(int x) {
        String numStr = String.valueOf(x);
        for(int i = 0; i < numStr.length() / 2; i++){
            if(numStr.charAt(i) != numStr.charAt(numStr.length() - i - 1)){
                return false;
            }
        }
        return true;
    }
}
