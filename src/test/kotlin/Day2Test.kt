import org.junit.Assert.assertArrayEquals
import org.junit.Test
import kotlin.test.assertEquals

class Day2Test {

    val expectedEntries: List<String> = listOf(
            "1-3 a: abcde",
            "1-3 b: cdefg",
            "2-9 c: ccccccccc"
    )

    val expectedResult = 2
    val expectedResult2 = 1

    @Test
    fun testFileReading() {
        val fileEntries = Day2().getEntries("/Users/marcpoppleton/Code/AdventOfCode2020/src/test/resources/Day2.txt")
        assert(expectedEntries.containsAll(fileEntries))
    }

    @Test
    fun testMagic() {
        val fileEntries = Day2().getEntries("/Users/marcpoppleton/Code/AdventOfCode2020/src/test/resources/Day2.txt")
        val result = Day2().doMagic(fileEntries)
        assertEquals(expectedResult,result)
    }

    @Test
    fun testMagic2() {
        val fileEntries = Day2().getEntries("/Users/marcpoppleton/Code/AdventOfCode2020/src/test/resources/Day2.txt")
        val result = Day2().doMagic2(fileEntries)
        assertEquals(expectedResult2,result)
    }

}