import java.io.File

class Day2:Day {

    override fun main(args: Array<String>) {
        if (args.size != 2) {
            println("Usage is java -jar advent.jar 2 absolute_path_to_input_file")
            println("For example:")
            println("java -jar advent.jar 2 /tmp/day2.txt")
            return
        }
        super.main(args)
    }

    /*
    We need to find the number of passwords containing a given number of occurrence of a char.
    Each line contains 2 decimal values, a character and a password.
    Using a regex we extract all the useful values and then check if the given char is between the boundaries and return the number of times a password is valid.
     */
    override fun part1(entries: List<String>): Long {
        var result = 0L
        val regex = "(\\d+)-(\\d+) (.): (.+)".toRegex()
        entries.map { entrie ->
            val ruleElements = regex.find(entrie)?.groupValues
            ruleElements?.let {
                val min = it.component2().toInt()
                val max = it.component3().toInt()
                val char = it.component4().toCharArray().component1()
                val pwd = it.component5()
                val occurrence  = pwd.filter { letter -> letter == char }.count()
                if(occurrence in min..max)result ++
            }
        }
        return result
    }

    /*
    Turns out the 2 decimals are indexes in the password. To be valid a password must contain only one occurrence of the given char at one of the given indexes.
    Using XOR we can determine if the password is valid or not.
     */
    override fun part2(entries: List<String>): Long {
        var result = 0L
        val regex = "(\\d+)-(\\d+) (.): (.+)".toRegex()
        entries.map { entrie ->
            val ruleElements = regex.find(entrie)?.groupValues
            ruleElements?.let {
                val index1:Int = it.component2().toInt()
                val index2:Int = it.component3().toInt()
                val char = it.component4().toCharArray().component1()
                val pwd = it.component5()
                if((pwd[index1-1] == char).xor(pwd[index2-1] == char))result ++
            }
        }
        return result
    }
}