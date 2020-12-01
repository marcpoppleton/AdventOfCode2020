import java.io.File
import kotlin.math.exp

class Day1 {

    fun main(args: Array<String>) {
        if (args.size != 2) {
            println("Usage is java -jar advent.jar 1 absolute_path_to_input_file")
            println("For example:")
            println("java -jar advent.jar 1 /tmp/day1.txt")
            return
        }
        try {
            val entries = getEntries(args[1])
            val start = System.currentTimeMillis()
            val part1 = doMagicWith2(2020, entries)
            val end = System.currentTimeMillis()
            val start2 = System.currentTimeMillis()
            val part2 = doMagicWith3(2020, entries)
            val end2 = System.currentTimeMillis()
            println("Magic with 2 is : $part1 in ${end - start} millis")
            println("Magic with 3 is : $part2 in ${end2 - start2} millis")
        }catch(e:java.io.FileNotFoundException){
            println("${args[1]} is not a valid file.")
        }
    }

    /*
    We need to find in an array a pair of int whose sum equals a given value.
    The function starts by dropping all values above the target value and sorts them.
    It then iterates the values twice. When a matching couple is found it stops and returns the product of both.
     */
    fun doMagicWith2(expected: Int, entries: IntArray): Int {
        //sort out the damn entries, we don't need any above the sum target value
        val culled = entries.filter { i -> i < expected }.sorted()
        culled.forEach { one ->
            culled.forEach lit2@{ two ->
                val sum = one + two
                //if matching pair is found or tested pair sum is above target value, we can stop iterating
                if (expected > sum) return@lit2
                if (expected == sum) {
                    return one * two
                }
            }
        }
        return -1
    }

    /*
    Does exactly the same stuff as the other function, but with 3 entries, so 3 iterators.
     */
    fun doMagicWith3(expected: Int, entries: IntArray): Int {
        val culled = entries.filter { i -> i < expected }.sorted()
        culled.forEach { one ->
            culled.forEach { two ->
                culled.forEach lit3@{ three ->
                    val sum = one + two + three
                    if (sum > expected) return@lit3
                    if (sum == expected) {
                        return one * two * three
                    }
                }
            }
        }
        return -1
    }

    fun getEntries(filename: String): IntArray = File(filename).readLines().map { line -> line.toInt() }.toIntArray()

}