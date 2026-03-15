import java.util.Scanner

fun main() {
    val input = Scanner(System.`in`)

    val maxNum = 20005
    val n = input.nextInt()
    val q = input.nextInt()
    val array = IntArray(maxNum)
    (0 until n).forEach { _ ->
        //            array[i] = input.nextInt()
        val num = input.nextInt()
        array[num] += 1
    }
    val prefixSum = IntArray(maxNum)
    for (i in 0 until maxNum) {
        prefixSum[i] = prefixSum[i - 1] + array[i]
    }
    (0 until q).forEach { _ ->
        val l = input.nextInt()
        val r = input.nextInt()
        val ans = prefixSum[r] - prefixSum[l - 1]
        println(ans)
    }

}