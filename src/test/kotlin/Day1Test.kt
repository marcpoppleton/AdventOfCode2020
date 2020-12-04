import org.junit.Assert.assertArrayEquals
import org.junit.Test
import kotlin.test.assertEquals

class Day1Test {

    val expectedEntries:List<String> = listOf(
        "1721",
        "979",
        "366",
        "299",
        "675",
        "1456"
    )

    val expectedResultFor2 = 514579L
    val expectedResultFor3 = 241861950L

    @Test
    fun testFileReading() {
        val fileEntries = Day1().getEntries("/Users/marcpoppleton/Code/AdventOfCode2020/src/test/resources/Day1.txt")
        assert(fileEntries.containsAll(expectedEntries))
    }

    @Test
    fun test2Entries() {
        val fileEntries = Day1().getEntries("/Users/marcpoppleton/Code/AdventOfCode2020/src/test/resources/Day1.txt")
        val result = Day1().part1(fileEntries)
        assertEquals(expectedResultFor2,result)
    }    @Test

    fun test3Entries() {
        val fileEntries = Day1().getEntries("/Users/marcpoppleton/Code/AdventOfCode2020/src/test/resources/Day1.txt")
        val result = Day1().part2(fileEntries)
        assertEquals(expectedResultFor3,result)
    }
}