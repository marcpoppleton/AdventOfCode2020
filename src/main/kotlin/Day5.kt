class Day5 : Day {

    /**
     * We know that each boarding pass is a 10 char long encoding of the seat number
     * For part on we need to know what is the highest seat number scanned
     * We decode each value and return the biggest one.
     */
    override fun part1(entries: List<String>): Long? = entries.map { pass -> getSeatId(pass) }.maxOrNull()

    /**
     * We have all the boarding passes, therefore all the occupied seats.
     * We need to find the missing value in the suite of seat numbers.
     * We can calculate the expected sum of the values of this arithmetic suite.
     * The difference between the expected sum and the actual sum is our seat id.
     */
    override fun part2(entries: List<String>): Long? {
        var result = -1L
        val ids = entries.map { pass -> getSeatId(pass) }
        val max = ids.maxOrNull()
        val min = ids.minOrNull()

        max?.let {
            min?.let {
                var expectedSum = ((max + min) / 2.0) * (ids.size + 1)
                ids.forEach { expectedSum -= it }
                result = expectedSum.toLong()
            }
        }

        return result
    }

    /*
    Each boarding pass is a 10 char string
    The first 7 encode the row
    The last 3 encode the column
     */
    fun getSeatId(pass: String): Long {
        val row = getValue(pass.substring(0, 7), 0, 127)
        val col = getValue(pass.substring(7), 0, 7)
        return row * 8L + col
    }

    /*
    By iteration go down the BSP tree to find the min value
     */
    fun getValue(row: String, min: Int, max: Int): Int {
        var min_ = min
        var max_ = max
        row.forEach { c ->
            when (c) {
                'F', 'L' -> {
                    max_ = ((max_ - min_) / 2) + min_
                }
                else -> {
                    min_ = (Math.ceil((max_ - min_) / 2.0) + min_).toInt()
                }
            }
        }
        return min_
    }

}