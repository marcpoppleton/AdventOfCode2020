import com.sun.org.apache.bcel.internal.generic.NOP

class Day8 : Day {

    /*
     The input contains instructions for a program to run. It has three instructions, NOP, ACC and JMP followed by a numeric value.
     We are told that the program can fall in an infinite loop and never terminate. So we must implement a security mechanism to stop the program from looping.
     In part 1 we are asked to stop the program as soon as it is about to enter an infinite loop and return the value of the accumulator.
     */
    override fun part1(entries: List<String>): Long? {
        val program = Program(entries)
        program.run()
        return program.accumulator.toLong()
    }

    /*
    In part 2 we are told that the infinite loop is maybe due to an instruction error. Either a NOP switched to a JMP or the opposite.
    To debug the program we have to change one, and only one, JMP to NOP or NOP to JMP and the program will execute properly.
    To do so we change one by one all of the JMP instructions to NOP and run the code each time. If the program still fails to terminate properly
    we proceed to change one by one all of the NOP to JMP and run the code each time.
    As soon as a change gets the program to terminate gracefully we return the value of the accumulator.
     */
    override fun part2(entries: List<String>): Long? {
        val result = 0L
        val program = Program(entries)
        if(program.run()){
            return program.accumulator.toLong()
        }
        for(instruction in program.getAllJmp()){
            instruction.op = Op.NOP
            program.reset()
            if(program.run()){
                return program.accumulator.toLong()
            }
            instruction.op = Op.JMP
        }
        for(instruction in program.getAllNop()){
            instruction.op = Op.JMP
            program.reset()
            if(program.run()){
                return program.accumulator.toLong()
            }
            instruction.op = Op.NOP
        }

        return result
    }

    enum class Op(val string: String){
        NOP("nop"),
        ACC("acc"),
        JMP("jmp");

        companion object {
            fun getOpByName(name: String) = valueOf(name.toUpperCase())
        }
    }

    class Instruction(instruction: String) {
        var counter: Int = 0
        var op: Op = Op.getOpByName(instruction.split(" ")[0])
        var args: Int = instruction.split(" ")[1].toInt()

        override fun toString(): String {
            return "$op $args ($counter calls)"
        }
    }

    class Program(entries: List<String>) {
        private val heap = mutableListOf<Instruction>()

        var accumulator:Int=0
            private set

        init {
            entries.forEach { entry ->
                val instruction = Instruction(entry)
                println(instruction)
                heap.add(instruction)
            }
        }

        fun reset(){
            heap.forEach { instr -> instr.counter=0 }
            accumulator = 0
        }

        fun getAllNop():List<Instruction> = heap.filter { instr -> instr.op == Op.NOP }

        fun getAllJmp():List<Instruction> = heap.filter { instr -> instr.op == Op.JMP }

        fun run(): Boolean {
            var done = false

            var index = 0
            var currentOp = heap[index]
            while (currentOp.counter == 0 && !done) {
                when (currentOp.op) {
                    Op.NOP -> index++
                    Op.ACC -> {
                        accumulator += currentOp.args
                        index++
                    }
                    Op.JMP -> index += currentOp.args
                }
                currentOp.counter++
                if(index == heap.size){
                    done = true
                }else{
                    if(index<heap.size) {
                        currentOp = heap[index]
                    }else{
                        return false
                    }
                }
            }

            return done
        }
    }


}