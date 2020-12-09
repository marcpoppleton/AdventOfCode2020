import org.junit.Test
import kotlin.test.assertEquals

class Day9Test {

    val expectedEntries: List<String> = listOf(
            "35",
            "20",
            "15",
            "25",
            "47",
            "40",
            "62",
            "55",
            "65",
            "95",
            "102",
            "117",
            "150",
            "182",
            "127",
            "219",
            "299",
            "277",
            "309",
            "576"
    )

    val expectedResult = 127L
    val expectedResult2 = 62L

    @Test
    fun testFileReading() {
        val fileEntries = Day9().getEntries("/Users/marcpoppleton/Code/AdventOfCode2020/src/test/resources/Day9.txt")
        assert(expectedEntries.containsAll(fileEntries))
    }

    @Test
    fun testMagic() {
        val fileEntries = Day9().getEntries("/Users/marcpoppleton/Code/AdventOfCode2020/src/test/resources/Day9.txt")
        val sum = Day9().findVulnerability(5,fileEntries)
        assertEquals(expectedResult, sum)
    }

    @Test
    fun testMagic2() {
        val fileEntries = Day9().getEntries("/Users/marcpoppleton/Code/AdventOfCode2020/src/test/resources/Day9.txt")
        val sum = Day9().findSum(127,fileEntries)
        assertEquals(expectedResult2, sum)
    }

}