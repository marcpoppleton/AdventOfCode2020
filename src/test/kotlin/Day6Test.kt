import org.junit.Test
import kotlin.test.assertEquals

class Day6Test {

    val expectedEntries: List<String> = listOf(
            "abc",
            "",
            "a",
            "b",
            "c",
            "",
            "ab",
            "ac",
            "",
            "a",
            "a",
            "a",
            "a",
            "",
            "b"
    )

    val expectedResult = 11L
    val expectedResult2 = 6L

    @Test
    fun testFileReading() {
        val fileEntries = Day6().getEntries("/Users/marcpoppleton/Code/AdventOfCode2020/src/test/resources/Day6.txt")
        assert(expectedEntries.containsAll(fileEntries))
    }

    @Test
    fun testMagic() {
        val fileEntries = Day6().getEntries("/Users/marcpoppleton/Code/AdventOfCode2020/src/test/resources/Day6.txt")
        val sum = Day6().part1(fileEntries)
        assertEquals(expectedResult,sum)
    }

    @Test
    fun testMagic2() {
        val fileEntries = Day6().getEntries("/Users/marcpoppleton/Code/AdventOfCode2020/src/test/resources/Day6.txt")
        val sum = Day6().part2(fileEntries)
        assertEquals(expectedResult2,sum)
    }

}