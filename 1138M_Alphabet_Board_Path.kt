/**
 * Medium 1138. Alphabet Board Path
 * https://leetcode.com/problems/alphabet-board-path/
 */
class Solution {
    val board = arrayOf("abcde", "fghij", "klmno", "pqrst", "uvwxy", "z")
    
    fun alphabetBoardPath(target: String): String {
        var result = ""
        var curX = 0
        var curY = 0
        for(c in target){
            val cPos = findPos(c)
            while(curX != cPos[0] || curY != cPos[1]){
                val diffX = cPos[0] - curX
                val diffY = cPos[1] - curY
                when{
                    diffX > 0 -> {
                        if(isOutBoard(++curX, curY)){
                            --curX
                        }else{
                            result += 'R'
                        }
                    }
                    diffX < 0 -> {
                        if(isOutBoard(--curX, curY)){
                            ++curX
                        }else{
                            result += 'L'
                        }
                    }
                }
                
                when{
                    diffY > 0 -> {
                        if(isOutBoard(curX, ++curY)){
                            --curY
                        }else{
                            result += 'D'
                        }
                    }
                    diffY < 0 -> {
                        if(isOutBoard(curX, --curY)){
                            ++curY
                        }else{
                            result += 'U'
                        }
                    }
                }
            }
            result += '!'
        }
        
        return result
    }
    
    fun findPos(c:Char):IntArray{
        board.forEachIndexed{y, row ->
            val x = row.indexOf(c)
            if(x != -1){
                return intArrayOf(x, y)
            }
        }
        return intArrayOf()
    }
    
    fun isOutBoard(x:Int, y:Int):Boolean{
        return when{
            y < 0 -> true
            y >= board.size -> true
            else -> when{
                x < 0 -> true
                x >= board[y].length -> true
                else -> false
            }
        }
    }
}
