class Day7 : Day {

    /*
     We are given a set of hare brained rules regarding bags containing other bags, recursively.
     We have to parse the file to build a structure holding all the rules.
     We are going to store in a hashmap objects containing themselves a hashmap of their parents and siblings.
     In part 1 we are asked to count the number or root parent capable of containing our bag.
     To do so we use two sets, one of bags to visit, and one of visited bags. Everytime we take a bag we add it from the visited set we add its parents to the visiting set.
     We iterate on the visiting set until it's empty.
     */
    override fun part1(entries: List<String>): Long? {
        var result = 0L
        val bags = extractRules(entries)

        val currentBag = bags["shiny gold"]
        val visiting = mutableSetOf<Bag>()
        val visited = mutableSetOf<Bag>()
        currentBag?.parents?.let {them ->
            visiting.addAll(them.keys.asSequence())
        }
        while(visiting.isNotEmpty()){
            val parent = visiting.iterator().next()
            visiting.remove(parent)
            visited.add(parent)
            parent?.parents?.let {them ->
                visiting.addAll(them.keys.asSequence())
            }
        }
        result = visited.size.toLong()
        return result
    }

    /*
    Based on the same structure as part 1 we recursively count the siblings of each bag.
     */
    override fun part2(entries: List<String>): Long? {
        val bags = extractRules(entries)
        bags.forEach {
            println("${it.value}")
        }
        val currentBag = bags["shiny gold"]
        return currentBag?.let {
            countSiblings(it)
        }?: 0L
    }

    fun countSiblings(bag:Bag):Long{
        var result = 0L
        bag.siblings.forEach { sibling ->
            result += sibling.value * (countSiblings(sibling.key)+1)
        }
        return result
    }


    fun extractRules(rules: List<String>) :HashMap<String,Bag>{
        val bags = hashMapOf<String,Bag>()

        rules.forEach { rule ->

            //light red bags contain 1 bright white bag, 2 muted yellow bags.
            val split = rule.split(" bags contain ")
            val containerName = split[0]
            var container = bags[containerName]
            if(container == null){
                container = Bag(containerName)
                bags[containerName] = container
            }
            if (split.size > 1) {
                val content = split[1]
                val splitContent = content.split(",")
                splitContent.forEach { content ->
                    val from = content.trim().indexOf(" ")
                    val to = content.trim().lastIndexOf(" ")
                    val bagName = content.trim().substring(from + 1, to)
                    if (bagName != "other") {
                        val number = content.trim().substring(0,from).toInt()
                        var bag = bags[bagName]
                        if(bag == null){
                            bag = Bag(bagName)
                            bags[bagName] = bag
                        }
                        container.siblings[bag] = number
                        bag.parents[container] = 1
                    }
                }
            }
        }
        return bags
    }


}

class Bag(val name:String){
    val parents = hashMapOf<Bag,Int>()
    val siblings = hashMapOf<Bag,Int>()
    override fun toString(): String {
        return "Bag $name is contained by any of ${parents.values} and has for siblings ${siblings.values}"
    }
}