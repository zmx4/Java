
import java.util.ArrayList;
/*
现有若干老师和学生混合参加元旦晚会，需要对他们进行
排队以确定演出顺序，排队规则如下：按年龄排序（升序），
如果年龄相同，则按性别排序（女士优先于男士）。请基于接
口技术，编程模拟这一场景。
*/
public class PersonTest {
    public static void main(String[] args) {
        ArrayList<Person> al = new ArrayList<Person>();
        al.add(new Person("qwq1", true, 25));
        al.add(new Person("qwq2", false, 25));
        al.add(new Person("qwq3", true, 26));
        

        for(Person person:al){
            System.out.println(person);
        }
    }
}
