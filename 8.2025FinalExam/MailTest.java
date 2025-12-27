/*
按以下要求编写程序：(30分) 
编写一个多媒体邮件处理软件，请定义邮箱类（MailBox），
其中有： 
属性：所有者(owner)  邮件集合（mails） 
方法： 
邮件阅读(readAll) : 遍历所有邮件。 
定义邮件播放接口playable：有一个抽象方法： 
void play()，播放邮件内容。 
定义实现类： 文本邮件类(TextMail)、语音邮件(VoidMail)
实现邮件播放接口，用输出语句模拟阅读。 
请编写测试类进行测试。
*/
public class MailTest {
    public static void main(String[] args) {
        MailBox mbox = new MailBox("qwq");
        // mbox.addMail

        mbox.addMail(new VoiceMail("11111"));
        mbox.addMail(new TextMail("22222"));

        mbox.readAll();
    }

}
