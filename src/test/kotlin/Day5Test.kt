import org.junit.Test
import kotlin.test.assertEquals

class Day5Test {

    val expectedEntries: List<String> = listOf(
            "BFFFBBFRRR",
            "FFFBBBFRRR",
            "BBFFBBFRLL"
    )

    val dummyPasses: List<String> = listOf(
            "FFFBBBBLRL",//122
            "FFFBBBBLRR",//123
            "FFFBBBBRLL",//124
            "FFFBBBBRRL",//126
            "FFFBBBBRRR"//127
    )

    val expectedIDsResult = listOf(567L,119L,820L)
    val expectedMaxResult = 820L

    val expectedMissingId = 125L

    @Test
    fun testFileReading() {
        val fileEntries = Day5().getEntries("/Users/marcpoppleton/Code/AdventOfCode2020/src/test/resources/Day5.txt")
        assert(expectedEntries.containsAll(fileEntries))
    }

    @Test
    fun testMagic() {
        val fileEntries = Day5().getEntries("/Users/marcpoppleton/Code/AdventOfCode2020/src/test/resources/Day5.txt")
        val ids:List<Long> = fileEntries.map { pass -> Day5().getSeatId(pass) }.toList()
        println("got ids $ids")
        assert(ids.containsAll(expectedIDsResult))
    }

    @Test
    fun testMagic2() {
        val fileEntries = Day5().getEntries("/Users/marcpoppleton/Code/AdventOfCode2020/src/test/resources/Day5.txt")
        val max = Day5().part1(fileEntries)
        assertEquals(expectedMaxResult,max)
    }

    @Test
    fun testMagic3() {
        val result = Day5().part2(dummyPasses)
        assertEquals(expectedMissingId, result)
    }


}