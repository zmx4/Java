
import java.util.ArrayList;

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
