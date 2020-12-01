import java.io.File

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
            doMagicWith2(2020, entries)
            doMagicWith3(2020, entries)
        }catch(e:java.io.FileNotFoundException){
            println("${args[1]} is not a valid file.")
        }
    }

    /*
    We need to find in an array a pair of int whose sum equals a given value.
    The function starts by dropping all values above the target value and sorts them.
    It then iterates the values starting from both ends. We a matching couple is found it stops and returns the product of both.
     */
    fun doMagicWith2(sum: Int, entries: IntArray): Int {
        //sort out the damn entries, we don't need any above the sum target value
        val culled = entries.filter { i -> i < sum }.sorted()
        //convenient boolean used later
        var match = false
        var answer = -1
        culled.asReversed().forEach lit1@{ big ->
            //no need to carry on if matching pair is found
            if (match) return@lit1
            culled.forEach lit2@{ small ->
                //if matching pair is found or tested pair sum is above target value, we can stop iterating
                if ((match)||(big + small > sum)) return@lit2
                if (big + small == sum) {
                    println("$big + $small = $sum. Product is ${big * small}")
                    answer = big * small
                    match = true
                }
            }
        }
        return answer
    }

    /*
    Does exactly the same stuff as the other function, but with 3 entries, so 3 iterators.
     */
    fun doMagicWith3(sum: Int, entries: IntArray): Int {
        val culled = entries.filter { i -> i < sum }.sorted()
        var match = false
        var answer = -1
        culled.asReversed().forEach lit1@{ big ->
            if (match) return@lit1
            culled.asReversed().forEach lit2@{ middle ->
                if (match) return@lit2
                culled.forEach lit3@{ small ->
                    if ((match)||(big + middle + small > sum)) return@lit3
                    if (big + middle + small == sum) {
                        println("$big + $middle + $small = $sum. Product is ${big * middle * small}")
                        answer = big * middle * small
                        match = true
                    }
                }
            }

        }
        return answer
    }

    fun getEntries(filename: String): IntArray = File(filename).readLines().map { line -> line.toInt() }.toIntArray()

}