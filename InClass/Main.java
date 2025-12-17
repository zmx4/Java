import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String s = "abc中";
        System.out.println(s.length());
        System.out.println(s.indexOf('中'));
        System.out.println(s.charAt(3));

        String s2 = "abc中";
        System.out.println(s == s2); // true
        System.out.println(s.equals(s2)); // true

        String s3 = new String("abc中");
        String s4 = new String("abc中");
        System.out.println(s3 == s4); // false
        System.out.println(s3.equals(s4)); // true

        String[] strs = "s001-钢笔-10.0-20.00".split("-");
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }

        StringBuffer sb = new StringBuffer("abc");
        sb.append("中");

        // 创建一个空的字符串
        String str1 = new String();
        // 创建一个内容为abcd的字符串
        String str2 = new String("abcd");
        // 创建一个字符数组
        char[] charArray = new char[] { 'D', 'E', 'F' };
        String str3 = new String(charArray);

        // 创建一个字节数组
        byte[] arr = new byte[] { 97, 98, 99 };
        String str4 = new String(arr);

        byte[] bytes = "中".getBytes("UTF-8"); // ASCII(0 - 127) GB2312/GBK UTF-8 Unicode
        System.out.println(bytes.length);
        for (int i = 0; i < bytes.length; i++) {
            long t1 = System.currentTimeMillis();
            printBinary(bytes[i]);
            long t2 = System.currentTimeMillis();

            System.out.println("所用时长（毫秒）：" + (t2 - t1));

            printHex(bytes[i]);
            System.out.println(bytes[i]);
        }
        String str5 = new String(bytes);

        System.out.println("a" + str1 + "b");
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str4);
        System.out.println(str5);

        // 获取当前系统属性
        Properties properties = System.getProperties();
        // 获取所有系统属性的key，返回Enumeration对象
        Enumeration propertyNames = properties.propertyNames();
        while (propertyNames.hasMoreElements()) {
            // 获取系统属性的键key
            String key = (String) propertyNames.nextElement();
            // 获取当前键key对应的值value
            String value = System.getProperty(key);
            System.out.println(key + "--->" + value);
        }

        // 下面是创建Person对象
        Person p = new Person("张三", 20);
        // 下面将变量置为null，让对象p成为垃圾
        p = null;
        // 调用方法进行垃圾回收
        System.gc();
        for (int i = 0; i < 1000000; i++) {
            // 为了延长程序运行的时间，执行空循环
        }

        Runtime rt = Runtime.getRuntime(); // 创建Runtime对象
        System.out.println("处理器的个数: " + rt.availableProcessors() + "个");
        System.out.println("空闲内存数量: " + rt.freeMemory() / 1024 / 1024 + "M");
        System.out.println("最大可用内存数量: " + rt.maxMemory() / 1024 / 1024 + "M");
        System.out.println("虚拟机中内存总量: " + rt.totalMemory() / 1024 / 1024 + "M");

        Process process = rt.exec("notepad.exe");// 得到表示进程的Process对象
        // Thread.sleep(3000); // 程序休眠3秒
        process.destroy(); // 关闭进程

        System.out.println("计算-10的绝对值: " + Math.abs(-10));
        System.out.println("求大于5.6的最小整数: " + Math.ceil(5.6));
        System.out.println("求小于-4.2的最大整数: " + Math.floor(-4.2));
        System.out.println("对-4.6进行四舍五入: " + Math.round(-4.6));
        System.out.println("求2.1和-2.1中的较大值: " + Math.max(2.1, -2.1));
        System.out.println("求2.1和-2.1中的较小值: " + Math.min(2.1, -2.1));
        System.out.println("生成一个大于等于0.0小于1.0随机值: " + Math.random());
        System.out.println("计算1.57的正弦结果: " + Math.sin(1.57));
        System.out.println("计算4的开平方的结果: " + Math.sqrt(4));

        Random random = new Random(); // 不传入种子
        // 随机产生10个[0,100)之间的整数
        for (int x = 0; x < 10; x++) {
            System.out.println(random.nextInt(100));
        }

        Random r = new Random(13); // 创建对象时传入种子
        // 随机产生10个[0,100)之间的整数
        for (int x = 0; x < 10; x++) {
            System.out.println(r.nextInt(100));
        }

    }

    public static void printBinary(byte b) throws Exception {
        for (int i = 7; i >= 0; i--) {
            // 1. 将当前要检查的位右移到最低位
            // 2. 使用按位与操作 & 1 来获取该位的值
            int bit = (b >> i) & 1;
            System.out.print(bit);
        }

        Thread.sleep(100);

        System.out.println(); // 换行
    }

    public static void printHex(byte b) {
        System.out.printf("0x%02X ", b);
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "姓名:" + this.name + "，年龄:" + this.age;
    }

    // 下面定义的finalize方法会在垃圾回收前被调用
    public void finalize() throws Throwable {
        System.out.println("对象被释放-->" + this);
    }
}
