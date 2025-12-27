
import java.util.ArrayList;

public class MailBox {
    private String owner;// 拥有者
    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    private ArrayList<Playable> mails;// 邮件集合
    public MailBox(String owner) {
        this.owner = owner;
        this.mails = new ArrayList<>();
    }
    public void readAll(){ // 
        for(Playable mail:mails){
            mail.play();
        }
    }
    public void addMail(Playable mail){
        this.mails.add(mail);
    }
}
