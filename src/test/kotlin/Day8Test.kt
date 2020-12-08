import org.junit.Test
import kotlin.test.assertEquals

class Day8Test {

    val expectedEntries: List<String> = listOf(
            "nop +0",
            "acc +1",
            "jmp +4",
            "acc +3",
            "jmp -3",
            "acc -99",
            "acc +1",
            "jmp -4",
            "acc +6"
    )

    val expectedResult = 5L
    val expectedResult2 = 8L

    @Test
    fun testFileReading() {
        val fileEntries = Day8().getEntries("/Users/marcpoppleton/Code/AdventOfCode2020/src/test/resources/Day8.txt")
        assert(expectedEntries.containsAll(fileEntries))
    }

    @Test
    fun testMagic() {
        val fileEntries = Day8().getEntries("/Users/marcpoppleton/Code/AdventOfCode2020/src/test/resources/Day8.txt")
        val sum = Day8().part1(fileEntries)
        assertEquals(expectedResult, sum)
    }

    @Test
    fun testMagic2() {
        val fileEntries = Day8().getEntries("/Users/marcpoppleton/Code/AdventOfCode2020/src/test/resources/Day8.txt")
        val sum = Day8().part2(fileEntries)
        assertEquals(expectedResult2, sum)
    }

}