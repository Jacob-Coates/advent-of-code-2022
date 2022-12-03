import scala.io.Source
object Third {
    def cost(c: Char) = c - (if (c.isUpper)'A' - 27 else 'a' - 1)

    def calc_cost(line: String) = get_letters(line).map(cost).sum

    def get_letters(line: String) = {
        var l = line.substring(0,line.length/2)
        var r = line.substring(line.length/2)
        l.filter(r contains _).distinct
    }

    def calc_cost(lines:Array[String]) = {
        // Get interserction of the three strings
        lines.foldLeft("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz")((x,y) => (x intersect y)).distinct
        .map(cost).sum
    }

    def part1(lines: Array[String]) = lines.map(calc_cost).sum

    def part2(lines: Array[String]) = lines.grouped(3).toArray.map(calc_cost).sum

    def main(args: Array[String]) = {
        // Get file
        val file = Source.fromFile("day3.txt")
        val lines = try file.mkString finally file.close()
        val codes = lines.split("\n")
        //Run puzzle solutions
        println(part1(codes))
        println(part2(codes))
    }
}