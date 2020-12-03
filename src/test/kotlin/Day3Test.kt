import org.junit.Assert.assertArrayEquals
import org.junit.Test
import kotlin.test.assertEquals

class Day3Test {

    val expectedEntries: List<String> = listOf(
            "..##.......",
    "#...#...#..",
    ".#....#..#.",
    "..#.#...#.#",
    ".#...##..#.",
    "..#.##.....",
    ".#.#.#....#",
    ".#........#",
    "#.##...#...",
    "#...##....#",
    ".#..#...#.#"
    )

    val expectedResult = 7L
    val expectedResult2 = 336L

    @Test
    fun testFileReading() {
        val fileEntries = Day3().getEntries("/Users/marcpoppleton/Code/AdventOfCode2020/src/test/resources/Day3.txt")
        assert(expectedEntries.containsAll(fileEntries))
    }

    @Test
    fun testMagic() {
        val fileEntries = Day3().getEntries("/Users/marcpoppleton/Code/AdventOfCode2020/src/test/resources/Day3.txt")
        val result = Day3().doMagic(fileEntries)
        assertEquals(expectedResult,result)
    }

    @Test
    fun testMagic2() {
        val fileEntries = Day3().getEntries("/Users/marcpoppleton/Code/AdventOfCode2020/src/test/resources/Day3.txt")
        val result = Day3().doMagic2(fileEntries)
        assertEquals(expectedResult2,result)
    }

}