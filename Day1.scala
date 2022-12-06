import scala.io.Source
object Day1 {
    def main(args: Array[String]) = {
        val file = Source.fromFile("day1.txt")
        val lines = try file.mkString finally file.close()
        val input = lines.split("\n\n")

        val calories = input.map(_.split("\n").map(_.toInt).sum).sortWith(_>_)
        println(calories.head,calories.take(3).sum)
    }
}