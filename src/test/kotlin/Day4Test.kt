import org.junit.Assert.assertArrayEquals
import org.junit.Test
import kotlin.test.assertEquals

class Day4Test {

    val expectedEntries: List<String> = listOf(
            "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd",
            "byr:1937 iyr:2017 cid:147 hgt:183cm",
            "",
            "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884",
            "hcl:#cfa07d byr:1929",
            "",
            "hcl:#ae17e1 iyr:2013",
            "eyr:2024",
            "ecl:brn pid:760753108 byr:1931",
            "hgt:179cm",
            "",
            "hcl:#cfa07d eyr:2025 pid:166559648",
            "iyr:2011 ecl:brn hgt:59in",
    )

    val expectedResult = 2L
    val expectedResult21 = 0L
    val expectedResult22 = 4L

    @Test
    fun testFileReading() {
        val fileEntries = Day4().getEntries("/Users/marcpoppleton/Code/AdventOfCode2020/src/test/resources/Day4.txt")
        assert(expectedEntries.containsAll(fileEntries))
    }

    @Test
    fun testMagic() {
        val fileEntries = Day4().getEntries("/Users/marcpoppleton/Code/AdventOfCode2020/src/test/resources/Day4.txt")
        val result = Day4().part1(fileEntries)
        assertEquals(expectedResult, result)
    }

    @Test
    fun testMagicInvalidData() {
        val fileEntries = Day4().getEntries("/Users/marcpoppleton/Code/AdventOfCode2020/src/test/resources/Day4-2-invalid.txt")
        val result = Day4().part2(fileEntries)
        assertEquals(expectedResult21, result)
    }

    @Test
    fun testMagicValidData() {
        val fileEntries = Day4().getEntries("/Users/marcpoppleton/Code/AdventOfCode2020/src/test/resources/Day4-2-valid.txt")
        val result = Day4().part2(fileEntries)
        assertEquals(expectedResult22, result)
    }
    @Test
    fun testMagicMixedData() {
        val fileEntries = Day4().getEntries("/Users/marcpoppleton/Code/AdventOfCode2020/src/test/resources/Day4-2.txt")
        val result = Day4().part2(fileEntries)
        assertEquals(expectedResult22, result)
    }

}