import java.util.Scanner

fun main() {
    val input = Scanner(System.`in`)

    val maxNum = 20005
    val n = input.nextInt()
    val q = input.nextInt()
    val array = IntArray(maxNum)
    for (i in 0 until n) {
//            array[i] = input.nextInt()
        val num = input.nextInt()
        array[num] += 1
    }
    val perfix = IntArray(maxNum)
    for (i in 0 until maxNum) {
        perfix[i] = perfix[i - 1] + array[i]
    }
    for (i in 0 until q) {
        val l = input.nextInt()
        val r = input.nextInt()
        val ans = perfix[r] - perfix[l - 1]
        println(ans)
    }

}