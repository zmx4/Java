import java.util.HashSet;

public class Stest {
    public static void main(String[] args) {
        HashSet<Student> hset= new HashSet<Student>();
        hset.add(new Student("1", "a"));
        hset.add(new Student("2", "b"));
        hset.add(new Student("2", "b"));
        System.out.println(hset); 
        
    }
}
