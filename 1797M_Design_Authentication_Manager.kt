/**
 * Medium 1797. Design Authentication Manager
 * https://leetcode.com/problems/design-authentication-manager/
 *
 * 792 ms, 97.1 MB
 *
 * Your AuthenticationManager object will be instantiated and called as such:
 * var obj = AuthenticationManager(timeToLive)
 * obj.generate(tokenId,currentTime)
 * obj.renew(tokenId,currentTime)
 * var param_3 = obj.countUnexpiredTokens(currentTime)
 */
 class AuthenticationManager(private val timeToLive: Int) {
    private val livedToken = mutableMapOf<String, Int>()

    fun generate(tokenId: String, currentTime: Int) {
        livedToken[tokenId] = currentTime
    }

    fun renew(tokenId: String, currentTime: Int) {
        refreshLivedTokenState(currentTime)
        if(livedToken.containsKey(tokenId)) {
            livedToken.set(tokenId, currentTime)
        }
    }

    fun countUnexpiredTokens(currentTime: Int): Int {
        refreshLivedTokenState(currentTime)
        return livedToken.size
    }

    private fun refreshLivedTokenState(currentTime: Int) {
        livedToken.filter { it.value + timeToLive <= currentTime}
            .forEach { livedToken.remove(it.key) }
    }
}
