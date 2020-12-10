class Day10 : Day {

    /*
    We are given a set of number. We want to know how many numbers are at 1 degree of seperation and how many are at 3.
    We start by sorting the numbers then for each number we check if the previous one is 1 or 3 steps bellow.
    Once all numbers explored, we return the product of the two sums.
     */
    override fun part1(entries: List<String>): Long {
        return buildChain(entries)
    }

    /*
    * We have to find the number of successful paths from 0 to max value of our list of inputs.
    * We cannot compute all possibilities and check them one by one, but we can build a tree with the provided data.
    * Walking down the tree we can check if some paths are successful or not.
    * To avoid loosing time checking child nodes we store for each explored node the number of successful child node.
    * Before exploring a child node we check if we already have a value for it or not. If we don't, we explore the child and store the value.
     */
    override fun part2(entries: List<String>): Long {
        sortedEntries = entries.map { it.toLong() }.sorted()
        return walkPath()
    }

    fun buildChain(entries: List<String>): Long {
        var jolts1 = 0L
        var jolts3 = 1L
        var baseJolt = 0L
        val sortiedEntries = entries.sortedBy { it.toLong() }
        for (i in sortiedEntries.indices) {
            val current = sortiedEntries[i].toLong()
            when (current - baseJolt) {
                1L -> jolts1++
                3L -> jolts3++
            }
            baseJolt = current
        }
        return jolts1 * jolts3
    }

    lateinit var sortedEntries: List<Long>
    val knownValuesIndex = hashMapOf<Int,Long>()

    fun walkPath(index: Int = -1): Long {
        var currentVal: Long = if (index == -1) {
            0L
        } else {
            sortedEntries[index]
        }
        if (currentVal == sortedEntries.last()) {
            return 1
        } //we have reached the bottom leaf

        if(knownValuesIndex.containsKey(index)){
            return knownValuesIndex.getOrDefault(index,0)
        }
        var result = 0L
        for(i in index+1 until sortedEntries.size){
            if(sortedEntries[i] - currentVal <= 3){
                result += walkPath(i)
            }
        }
        knownValuesIndex[index] = result
        return result
    }

}