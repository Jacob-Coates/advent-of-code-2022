import scala.io.Source
object Day6 {
// Move stacks of n from each value
    def main(args: Array[String]) = {
        val file = Source.fromFile("day6.txt")
        val line = try file.mkString finally file.close()
        val code = line.toCharArray()
        println(solve(code,4))
        println(solve(code,14))
    }
    def solve(input: Array[Char],n: Int) : Int = if (input.take(n).distinct.length != input.take(n).length) 1 + solve(input.tail,n) else n
}