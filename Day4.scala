import scala.io.Source
object Day4 {

    extension [A](a: Array[A]){
        def l = a.head
        def r = a.apply(1)
    }

    def overlap(line: Array[Array[String]]) = {
        val s = line.sortWith(_.l.toInt < _.l.toInt)
        if (s.l.r >= s.r.r || s.l.l==s.r.l) 1 else 0
    }
    def part1(lines: Array[Array[Array[String]]]) = lines.map(overlap).sum
    
    def overlap2(line: Array[Array[String]]) = {
        val s = line.sortWith(_.l.toInt < _.l.toInt)
        if (s.l.r.toInt >= s.r.l.toInt) 1 else 0
    }
    def part2(lines: Array[Array[Array[String]]]) = lines.map(overlap2).sum

    def main(args: Array[String]) = {
        val file = Source.fromFile("day4.txt")
        val lines = try file.mkString finally file.close()
        val codes = lines.split("\n").map(_.split(",").map(_.split("-")))
        println(part1(codes))
        println(part2(codes))
    }
}