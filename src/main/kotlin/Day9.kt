import sun.security.util.Length

class Day9 : Day {

    /*
    * We are given a suite of values. After a given number of values, each one should be the sum of two values in the preceding n ones.
    * In part 1 we have to find the first value not meeting this condition.
     */
    override fun part1(entries: List<String>): Long {
        return findVulnerability(25,entries)
    }

    override fun part2(entries: List<String>): Long {
        val vul = findVulnerability(25,entries)
        return findSum(vul,entries)
    }

    fun findSum(target:Long,entries: List<String>):Long{
        var sum = -1L

        for(startIndex in entries.indices){
            var index = 0
            var acc = 0L
            val values = mutableSetOf<Long>()
            while (target > acc && (startIndex + index < entries.size)) {
                val value = entries[startIndex + index].toLong()
                acc += value
                values.add(value)
                index++
            }
            if(target == acc){
                val min = values.minOrNull() ?: 0L
                val max = values.maxOrNull() ?: 0L
                sum = min + max
                return sum
            }
            println("$acc")
        }

        return sum
    }

    fun findVulnerability(preambleLength: Int, entries: List<String>):Long{
        var start = 0
        var number = -1L
        var valid = true
        while (valid && (start + preambleLength < entries.size - 2)) {
            val previous = entries.subList(start, start + preambleLength)
            number = entries[start + preambleLength].toLong()
            valid = isValid(number, previous)
            start++
        }
        return number
    }

    fun isValid(number: Long, preamble: List<String>): Boolean {
        preamble.forEach { one ->
            preamble.forEach lit2@{ two ->
                val sum = one.toLong() + two.toLong()
                //if matching pair is found or tested pair sum is above target value, we can stop iterating
                if (two == one) return@lit2
                if (number > sum) return@lit2
                if (number == sum) {
                    return true
                }
            }
        }
        return false
    }


}