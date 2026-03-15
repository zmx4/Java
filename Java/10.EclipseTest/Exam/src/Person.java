import java.util.Objects;

public class Person {
	private String nema;
	private int age;
	public String getNema() {
		return nema;
	}
	public void setNema(String nema) {
		this.nema = nema;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Person(String nema, int age) {
		super();
		this.nema = nema;
		this.age = age;
	}
	@Override
	public int hashCode() {
		return Objects.hash(age, nema);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return age == other.age && Objects.equals(nema, other.nema);
	}
	
	
}
