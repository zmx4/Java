import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class Program {
    public static void main(String[] args) {
        Random random = new Random();
        final HashSet<Studenta> hs = new HashSet<Studenta>();
        for(int i = 1;i <= 10;i++)
        {
            hs.add(new Studenta("student" + i, "student" + i, random.nextInt(100), random.nextInt(100)));
        }
        for(Studenta student : hs)
        {
            System.out.println("ID: " + student.getSno() + " Name: " + student.getSname() + " age: " + student.getAge() + " score: " + student.getScore());
        }
        final TreeSet<Studenta> set = new TreeSet<Studenta>();
        set.addAll(hs);
        for(Studenta student : hs)
        {
            System.out.println("ID: " + student.getSno() + " Name: " + student.getSname() + " age: " + student.getAge() + " score: " + student.getScore());
        }
    }
}
