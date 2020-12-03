import java.io.File

class Day3 {

    val tree:Char = "#".toCharArray()[0]

    fun main(args: Array<String>) {
        if (args.size != 2) {
            println("Usage is java -jar advent.jar 3 absolute_path_to_input_file")
            println("For example:")
            println("java -jar advent.jar 3 /tmp/day3.txt")
            return
        }
        try {
            val entries = getEntries(args[1])
            val start = System.currentTimeMillis()
            val part1 = doMagic(entries)
            val end = System.currentTimeMillis()
            val start2 = System.currentTimeMillis()
            val part2 = doMagic2(entries)
            val end2 = System.currentTimeMillis()
            println("Magic part 1 is : $part1 in ${end - start} millis")
            println("Magic part 2 is : $part2 in ${end2 - start2} millis")
        } catch (e: java.io.FileNotFoundException) {
            println("${args[1]} is not a valid file.")
        }
    }

    fun doMagic(entries: List<String>): Long = countTreesDownSlope(entries,3,1)

    fun doMagic2(entries: List<String>): Long {
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

    fun getEntries(filename: String): List<String> = File(filename).readLines()

}