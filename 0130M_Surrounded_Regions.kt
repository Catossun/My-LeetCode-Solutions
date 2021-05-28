/**
 * Medium 130. Surrounded Regions
 * https://leetcode.com/problems/surrounded-regions/
 *
 * 4424 ms, 50.1 MB
 */
class Solution {
    fun solve(board: Array<CharArray>): Unit {
        board.forEachIndexed{ y, cols ->
            cols.forEachIndexed{ x, c ->
                val region = mutableListOf<Pair<Int, Int>>()
                val isRegion = findRegion(board, x, y, region)

                if(isRegion) {
                    region.forEach{ (x, y) ->
                        board[y][x] = 'X'
                    }
                }
            }
        }
    }
    
    fun findRegion(
        board: Array<CharArray>,
        curX: Int,
        curY: Int,
        walkedList: MutableList<Pair<Int, Int>>
    ): Boolean {
        val boardHeight = board.size
        val boardWidth = board[0].size
        
        if(curX < 0 || curX > boardWidth - 1) return false
        if(curY < 0 || curY > boardHeight - 1) return false
        
        if(walkedList.contains(curX to curY)) return true
        
        val curChar = board[curY][curX]
        
        if(curChar == 'O') {
            if(curX == 0 || curX == boardWidth - 1) return false
            if(curY == 0 || curY == boardHeight - 1) return false
            
            walkedList.add(curX to curY)
            
            val isLeftInRegion = findRegion(board, curX - 1, curY, walkedList)
            if(!isLeftInRegion) return false
            
            val isTopInRegion = findRegion(board, curX, curY - 1, walkedList)
            if(!isTopInRegion) return false

            val isRightInRegion = findRegion(board, curX + 1, curY, walkedList)
            if(!isRightInRegion) return false
            
            val isBottomInRegion = findRegion(board, curX, curY + 1, walkedList)
            if(!isBottomInRegion) return false
            
            val isInRegion = isLeftInRegion && isTopInRegion && isRightInRegion && isBottomInRegion
            
            return isInRegion
        } else {
            return true
        }
    }
}
