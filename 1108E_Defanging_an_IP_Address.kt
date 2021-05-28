/**
 * Easy 1108. Defanging an IP Address
 * https://leetcode.com/problems/defanging-an-ip-address/
 */
class Solution {
    fun defangIPaddr(address: String): String {
        var result = StringBuilder()
        for(c in address){
            if(c == '.'){
                result.append("[.]")
            }else{
                result.append(c)
            }
        }
        return result.toString()
    }
}
