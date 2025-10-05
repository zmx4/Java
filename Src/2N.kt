import java.util.Scanner
import kotlin.math.*

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    while (input.hasNextInt()) {
        val x = abs(input.nextInt())
        if (x !in 0..65536) {
            println("No!")
            continue
        }
        var temp = 1
        var cnt = 0
        while (temp < x) {
            temp *= 2
            cnt++
        }
        if (temp == x) println(cnt) else println("No!")
    }
}