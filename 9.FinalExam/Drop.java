import java.util.Scanner;
/*
按以下要求编写程序：（15分） 
一球从h米高度自由落下，每次落地后反跳回原高度的一半；再落下，求它
在 第n次落地时，共经过多少米？ 
代码直接写在主方法中。
*/
public class Drop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double h = scanner.nextDouble();
        double n = scanner.nextDouble();
        scanner.close();
        double totalDistance = 0;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                totalDistance += h;
            } else {
                totalDistance += 2 * (h / Math.pow(2, i - 1));
            }
        }
        System.out.printf("%.2f\n", totalDistance);
    }
}
