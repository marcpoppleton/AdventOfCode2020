class Day6 : Day {

    /*
    * The input contains groups of lines corresponding to the positives answers to a set of questions.
    * We have to return the number of questions having at least one positive answer for each group
    * Knowing that an empty line means a new group, we start by concatenating the lines to build a line per group.
    * Then we collect the unique letters of the string and count them.
     */
    override fun part1(entries: List<String>): Long? {
        var result = 0L
        var currentGroup: String = ""

        for (i in entries.indices) {
            val line = entries[i]
            currentGroup = currentGroup.plus(line)
            if ((line.count() == 0) || (i == entries.indices.last)) {
                val positiveQuestions = getPositiveQuestions(currentGroup)
                result += positiveQuestions.size
                currentGroup = ""
            }
        }
        return result
    }

    /*
    * This time we have to count number of items found in ALL lines of a group.
    * To do so we get the unique positive responses for each person and, by intersecting the sets, form the response for a given group.
     */
    override fun part2(entries: List<String>): Long? {
        var result = 0L
        var newGroup = true
        var groupPositives: Set<Char> = setOf<Char>()

        for (i in entries.indices) {
            val line = entries[i]
            val positives = getPositiveQuestions(line)
            if (line.count() != 0) {
                if (newGroup) {
                    groupPositives = positives
                    newGroup = false
                } else {
                    groupPositives = groupPositives.intersect(positives)
                }
            }
            if ((line.count() == 0) || (i == entries.indices.last)) {
                result += groupPositives.size
                newGroup = true
            }
        }
        return result
    }

    /*
     * Given a String, return a set containing the unique letters used to compose the String
     */
    fun getPositiveQuestions(responses: String): Set<Char> {
        var positiveQuestions = mutableSetOf<Char>()
        responses.forEach { char ->
            positiveQuestions.add(char)
        }
        return positiveQuestions
    }


}