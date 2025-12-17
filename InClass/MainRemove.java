import java.util.*;

public class MainRemove
{
    public static void main(String[] args){
        ArrayList<String> list = new ArrayList<String>();    //创建ArrayList集合
        list.add("张三");
        list.add("李四");
        list.add("王五");        
        Iterator<String> it = list.iterator();       // 获得Iterator对象
        while (it.hasNext()) {                // 判断该集合是否有下一个元素
            Object obj = it.next();           // 获取该集合中的元素
            if ("张三".equals(obj)) {         // 判断该集合中的元素是否为张三
                // list.remove(obj);              // 删除该集合中的元素
                it.remove();
            }
        }
        System.out.println(list);
    }
}