public class Student
{
    //成员变量
    String sno;
    String sname;
    
    public Student(String sno, String sname)
    {
        this.sno = sno;
        this.sname = sname;
    }

    public String toString() {// 重写toString()方法
	return sno + ":" + sname;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
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
        return true;
    }

    @Override
    public int hashCode() {
        return this.sno.hashCode() * this.sname.hashCode();
    }

} 