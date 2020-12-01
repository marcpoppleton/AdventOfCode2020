import org.junit.Assert.assertArrayEquals
import org.junit.Test
import kotlin.test.assertEquals

class Day1Test {

    val expectedEntries:IntArray = intArrayOf(
        1721,
        979,
        366,
        299,
        675,
        1456
    )

    val expectedResultFor2 = 514579
    val expectedResultFor3 = 241861950

    @Test
    fun testFileReading() {
        val fileEntries = Day1().getEntries("/Users/marcpoppleton/Code/AdventOfCode2020/src/test/resources/Day1.txt")
        assertArrayEquals(expectedEntries,fileEntries)
    }

    @Test
    fun test2Entries() {
        val fileEntries = Day1().getEntries("/Users/marcpoppleton/Code/AdventOfCode2020/src/test/resources/Day1.txt")
        val result = Day1().doMagicWith2(2020,fileEntries)
        assertEquals(expectedResultFor2,result)
    }    @Test

    fun test3Entries() {
        val fileEntries = Day1().getEntries("/Users/marcpoppleton/Code/AdventOfCode2020/src/test/resources/Day1.txt")
        val result = Day1().doMagicWith3(2020,fileEntries)
        assertEquals(expectedResultFor3,result)
    }
}