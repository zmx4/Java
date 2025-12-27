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
        return name + sex + age;
    }
    
}
