import java.util.Scanner
import kotlin.math.*

fun main() {
    val input = Scanner(System.`in`)
    while (input.hasNextInt()) {
        val a = input.nextInt()
        val t = input.nextInt()
        val b = input.nextInt()
        val s = input.nextInt()
        val times = max(a*t,b*s)
        println(times)
    }
}