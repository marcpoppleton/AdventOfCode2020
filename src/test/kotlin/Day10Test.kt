import org.junit.Test
import kotlin.test.assertEquals

class Day10Test {

    val expectedEntries: List<String> = listOf(
            "16",
            "10",
            "15",
            "5",
            "1",
            "11",
            "7",
            "19",
            "6",
            "12",
            "4"
    )

    val expectedResult = 35L
    val expectedResult11 = 220L
    val expectedResult2 = 8L
    val expectedResult21 = 19208L

    @Test
    fun testFileReading() {
        val fileEntries = Day10().getEntries("/Users/marcpoppleton/Code/AdventOfCode2020/src/test/resources/Day10.txt")
        assert(expectedEntries.containsAll(fileEntries))
    }

    @Test
    fun testMagic() {
        val fileEntries = Day10().getEntries("/Users/marcpoppleton/Code/AdventOfCode2020/src/test/resources/Day10.txt")
        val sum = Day10().part1(fileEntries)
        assertEquals(expectedResult, sum)
    }

    @Test
    fun testMagic11() {
        val fileEntries = Day10().getEntries("/Users/marcpoppleton/Code/AdventOfCode2020/src/test/resources/Day10-1.txt")
        val sum = Day10().part1(fileEntries)
        assertEquals(expectedResult11, sum)
    }

    @Test
    fun testMagic2() {
        val fileEntries = Day10().getEntries("/Users/marcpoppleton/Code/AdventOfCode2020/src/test/resources/Day10.txt")
        val sum = Day10().part2(fileEntries)
        assertEquals(expectedResult2, sum)
    }

    @Test
    fun testMagic21() {
        val fileEntries = Day10().getEntries("/Users/marcpoppleton/Code/AdventOfCode2020/src/test/resources/Day10-1.txt")
        val sum = Day10().part2(fileEntries)
        assertEquals(expectedResult21, sum)
    }

}