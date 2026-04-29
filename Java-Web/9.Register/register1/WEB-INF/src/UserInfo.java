import java.util.*;
public class UserInfo {
    private String username;
    private String password;
    private List<String> hobbies;

    public UserInfo(String username, String password,String[] hobbies) {
        this.username = username;
        this.password = password;
        this.hobbies = Arrays.asList(hobbies);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }
}
