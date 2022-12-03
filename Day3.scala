import scala.io.Source
object Day3 {
    def cost(c: Char) = c - (if (c.isUpper)'A' - 27 else 'a' - 1)

    def calc_cost(line: String) = 
        var l = line.substring(0,line.length/2)
        var r = line.substring(line.length/2)
        l.filter(r contains _).distinct.map(cost).sum

    def calc_cost(lines:Array[String]) = lines.reduce(_ intersect _).distinct.map(cost).sum

    def part1(lines: Array[String]) = lines.map(calc_cost).sum

    def part2(lines: Array[String]) = lines.grouped(3).toArray.map(calc_cost).sum

    def main(args: Array[String]) = {
        val file = Source.fromFile("day3.txt")
        val lines = try file.mkString finally file.close()
        val codes = lines.split("\n")
        println(part1(codes))
        println(part2(codes))
    }
}