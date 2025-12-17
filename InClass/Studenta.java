public class Studenta implements Comparable
{
    //成员变量
    private String sno;
    private String sname;
    private int age;
    private int score;     //学生成绩 

    public Studenta(String sno, String sname) {
        this.sno = sno;
        this.sname = sname;
    }

    public Studenta(String sno, String sname, int age, int score) {
        this.sno = sno;
        this.sname = sname;
        this.age = age;
        this.score = score;
    }

    public String getSno() {
        return sno;
    }

    public String getSname() {
        return sname;
    }

    public int getAge() {
        return age;
    }

    public int getScore() {
        return score;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Studenta other = (Studenta) obj;
        if (sno == null) {
            if (other.sno != null)
                return false;
        } else if (!sno.equals(other.sno))
            return false;
        if (sname == null) {
            if (other.sname != null)
                return false;
        } else if (!sname.equals(other.sname))
            return false;
        if (age != other.age)
            return false;
        if (score != other.score)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        return this.sno.hashCode() * this.sname.hashCode() * this.age * this.score;
    }

    @Override
    public int compareTo(Object o) {
        
        return -1;
    }


    //成员方法
    void read()
    {
        System.out.println("大家好，我是" + sname + ",我在看书!");
    }

    void study()
    {
        score++;
    }
    
} 