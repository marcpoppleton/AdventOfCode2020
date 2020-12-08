class Day4:Day {

    val keys = listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid", "cid")
    val requiredKeys = listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")
    val validEyeColors = listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")

    /*
    The data set contains potential passport looking data, written on one or more line per potential passport.
    The first step consists of collecting all data regarding one potential passport on a single line
    In part one of the puzzle we only have to check if the line contains all the required fields.
    In part two fo the puzzle we also have to check that fields follow required rules.
     */
    override fun part1(entries: List<String>): Long {
        var result = 0L
        var currentScan: String = ""

        for (i in entries.indices) {
            val line = entries[i]
            currentScan = currentScan.plus(" ").plus(line)
            if ((line.count() == 0) || (i == entries.indices.last)) {
                val extractedData = extractData(currentScan)
                val check = isKindOfPassportData(extractedData)
                if (check) {
                    result++
                }
                currentScan = ""
            }
        }
        return result
    }

    /*
    The data set contains potential passport looking data, written on one or more line per potential passport.
    The first step consists of collecting all data regarding one potential passport on a single line
    In part one of the puzzle we only have to check if the line contains all the required fields.
    In part two fo the puzzle we also have to check that fields follow required rules.
     */
    override fun part2(entries: List<String>): Long {
        var result = 0L
        var currentScan: String = ""

        for (i in entries.indices) {
            val line = entries[i]
            currentScan = currentScan.plus(" ").plus(line)
            if ((line.count() == 0) || (i == entries.indices.last)) {
                val extractedData = extractData(currentScan)
                val check =
                        if (isKindOfPassportData(extractedData)) {
                            isValidPassportData(extractedData)
                        }else{
                            false
                        }
                if (check) {
                    result++
                }
                currentScan = ""
            }
        }
        return result
    }

    /**
     * Takes a string containing all the data and build a map of key/values
     */
    fun extractData(data:String):Map<String,String>{
        val result:MutableMap<String,String> = mutableMapOf()
        data.trim().split(" ").map {
            val tuple = it.split(":")
            result[tuple.first()] = tuple.component2()
        }
        return result
    }

    /**
    * If the map keyset contains all the required keys, the map is considered a valid shape
     */
    fun isKindOfPassportData(passportData: Map<String,String>): Boolean = passportData.keys.containsAll(requiredKeys)


    /**
     * For every key of the map there is a corresponding test for the value.
     * If all values follow the required condition, the map is considered a valid passport.
     * If one or more values failed to meet the conditions, the map is considered an invalid passport.
     */
    fun isValidPassportData(passportData: Map<String,String>): Boolean {
        val checks:List<Boolean> =  passportData.map {
            when (it.key) {
                "byr" -> isValidByr(it.value)
                "iyr" -> isValidIyr(it.value)
                "eyr" -> isValidEyr(it.value)
                "hgt" -> isValidHgt(it.value)
                "hcl" -> isValidHcl(it.value)
                "ecl" -> isValidEcl(it.value)
                "pid" -> isValidPid(it.value)
                "cid" -> isValidCid(it.value)
                else -> false
            }
        }
        return checks.fold(true,{sum,element -> sum && element})
    }

    fun isValidByr(byr: String): Boolean {
        return try {
            (byr.toInt() in 1920..2002)
        } catch (_: NumberFormatException) {
            false
        }
    }

    fun isValidIyr(iyr: String): Boolean {
        return try {
            (iyr.toInt() in 2010..2020)
        } catch (_: NumberFormatException) {
            false
        }
    }

    fun isValidEyr(eyr: String): Boolean {
        return try {
            (eyr.toInt() in 2020..2030)
        } catch (_: NumberFormatException) {
            false
        }
    }

    fun isValidHgt(hgt: String): Boolean {
        return when {
            hgt.endsWith("cm") -> isValidCmHgt(hgt)
            hgt.endsWith("in") -> isValidInHgt(hgt)
            else -> false
        }
    }

    fun isValidCmHgt(hgt: String): Boolean {
        return try {
            (hgt.removeSuffix("cm").toInt() in 150..193)
        } catch (_: NumberFormatException) {
            false
        }
    }

    fun isValidInHgt(hgt: String): Boolean {
        return try {
            (hgt.removeSuffix("in").toInt() in 59..76)
        } catch (_: NumberFormatException) {
            false
        }
    }

    fun isValidHcl(hcl: String): Boolean = "#[a-f0-9]{6}".toRegex().matches(hcl)

    fun isValidEcl(ecl: String): Boolean = validEyeColors.contains(ecl)

    fun isValidPid(pid: String): Boolean = "(\\d{9})".toRegex().matches(pid)

    fun isValidCid(cid: String): Boolean = true //we dont care about this one

}