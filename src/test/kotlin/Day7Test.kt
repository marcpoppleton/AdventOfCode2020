import org.junit.Test
import kotlin.test.assertEquals

class Day7Test {

    val expectedEntries: List<String> = listOf(
            "light red bags contain 1 bright white bag, 2 muted yellow bags.",
            "dark orange bags contain 3 bright white bags, 4 muted yellow bags.",
            "bright white bags contain 1 shiny gold bag.",
            "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.",
            "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.",
            "dark olive bags contain 3 faded blue bags, 4 dotted black bags.",
            "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.",
            "faded blue bags contain no other bags.",
            "dotted black bags contain no other bags."
    )

    val expectedResult = 4L
    val expectedResult2 = 126L

    @Test
    fun testFileReading() {
        val fileEntries = Day7().getEntries("/Users/marcpoppleton/Code/AdventOfCode2020/src/test/resources/Day7.txt")
        assert(expectedEntries.containsAll(fileEntries))
    }

    @Test
    fun testMagic() {
        val fileEntries = Day7().getEntries("/Users/marcpoppleton/Code/AdventOfCode2020/src/test/resources/Day7.txt")
        val sum = Day7().part1(fileEntries)
        assertEquals(expectedResult,sum)
    }

    @Test
    fun testMagic2() {
        val fileEntries = Day7().getEntries("/Users/marcpoppleton/Code/AdventOfCode2020/src/test/resources/Day7-2.txt")
        val sum = Day7().part2(fileEntries)
        assertEquals(expectedResult2,sum)
    }

}