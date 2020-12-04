import java.io.File
import kotlin.math.exp

class Day1:Day {

    override fun main(args: Array<String>) {
        if (args.size != 2) {
            println("Usage is java -jar advent.jar 1 absolute_path_to_input_file")
            println("For example:")
            println("java -jar advent.jar 1 /tmp/day1.txt")
            return
        }
        super.main(args)
    }

    /*
        We need to find in an array a pair of int whose sum equals a given value.
        The function starts by dropping all values above the target value and sorts them.
        It then iterates the values twice. When a matching couple is found it stops and returns the product of both.
         */
    override fun part1(entries: List<String>):Long {
        val expected = 2020
        //sort out the damn entries, we don't need any above the sum target value
        val culled = entries.filter { i -> i.toInt() < expected }.sorted()
        culled.forEach { one ->
            culled.forEach lit2@{ two ->
                val sum = one.toInt() + two.toInt()
                //if matching pair is found or tested pair sum is above target value, we can stop iterating
                if (expected > sum) return@lit2
                if (expected == sum) {
                    return one.toLong() * two.toLong()
                }
            }
        }
        return -1
    }

    /*
    Does exactly the same stuff as the other function, but with 3 entries, so 3 iterators.
     */
    override fun part2(entries: List<String>):Long {
        val expected = 2020
        val culled = entries.filter { i -> i.toInt() < expected }.sorted()
        culled.forEach { one ->
            culled.forEach { two ->
                culled.forEach lit3@{ three ->
                    val sum = one.toInt() + two.toInt() + three.toInt()
                    if (sum > expected) return@lit3
                    if (sum == expected) {
                        return one.toLong() * two.toLong() * three.toLong()
                    }
                }
            }
        }
        return -1
    }

}