/*
现有若干老师和学生混合参加元旦晚会，需要对他们进行
排队以确定演出顺序，排队规则如下：按年龄排序（升序），
如果年龄相同，则按性别排序（女士优先于男士）。请基于接
口技术，编程模拟这一场景。
*/
public class Person implements Comparable<Person>{
    private String name; // 名字
    private boolean sex; // 是否是女性
    private int age; // 年龄
    public Person(String name, boolean sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
    @Override
    public int compareTo(Person o) {
        // return -1;
        if(this.age == o.age){
            if(this.sex == true){
                return -1;
            }
            return 1;
        }
        if(this.age > o.age)return -1;
        return 1;
    }
    @Override
    public String toString(){
        return name + (sex ? "女" : "男") + age;
    }
    
}
