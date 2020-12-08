import java.io.File

class Day3:Day {

    val tree:Char = "#".toCharArray()[0]

    override fun part1(entries: List<String>): Long = countTreesDownSlope(entries,3,1)

    override fun part2(entries: List<String>): Long {
        val slope1 = countTreesDownSlope(entries,1,1)
        val slope2 = countTreesDownSlope(entries,3,1)
        val slope3 = countTreesDownSlope(entries,5,1)
        val slope4 = countTreesDownSlope(entries,7,1)
        val slope5 = countTreesDownSlope(entries,1,2)
        return slope1 * slope2 * slope3 * slope4 * slope5

    }

    /*
    We need to find the number of occurrences of # in a string array, given a specific line and index jump.
    Each line contains a fixed number of characters. We have two parameters, right and down.
    Right give the value to increment the index, down the number of lines to jump.
    If the incremented index is above the biggest index of the line, we shift the index from the start by the difference
     */
    fun countTreesDownSlope(entries: List<String>, right:Int, down:Int): Long {
        var trees = 0L
        var currentIndex = 0
        for (i in down until entries.size step down) {
            currentIndex += right
            if (currentIndex > entries[i].length-1) {
                currentIndex -= entries[i].length
            }
            if (entries[i][currentIndex] == tree) {
                trees++
            }
        }
        return trees
    }
}