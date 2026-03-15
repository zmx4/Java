import java.util.concurrent.CopyOnWriteArrayList;
import java.util.List;

public class MutiThreadTest1 {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new CopyOnWriteArrayList<>();

        Thread t1 = new Thread(()->{
            for(int i=0;i<1000;i++){
                list.add(i);
            }
        });

        Thread t2 = new Thread(()->{
            for(int i=1000;i<2000;i++){
                list.add(i);
            }
        });

        t1.start();
        t2.start();

        // 等待两个线程都执行完毕
        t1.join();
        t2.join();

        System.out.println(list.size());
        for(Integer item : list){
            System.out.println(item);
        }
    }
}