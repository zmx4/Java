import java.util.*;

public class MainHashSet {
   public static void main(String[] args) {
      HashSet<String> hset = new HashSet<String>(); // 创建HashSet集合
      hset.add("张三"); // 向该Set集合中添加字符串
      hset.add("李四");
      hset.add("王五");
      hset.add("李四"); // 向该Set集合中添加重复元素
      Iterator<String> it = hset.iterator(); // 获取Iterator对象
      while (it.hasNext()) { // 通过while循环，判断集合中是否有元素
         Object obj = it.next();// 如果有元素，就调用迭代器的next()方法获取元素
         System.out.println(obj);
      }

      HashSet<Student> hs = new HashSet<Student>(); // 创建HashSet集合
      Student stu1 = new Student("1", "张三"); // 创建Student对象
      Student stu2 = new Student("2", "李四");
      Student stu3 = new Student("2", "李四");
      hs.add(stu1);
      hs.add(stu2);
      hs.add(stu3);
      System.out.println(hs);
   }
}
