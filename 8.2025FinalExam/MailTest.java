public class MailTest {
    public static void main(String[] args) {
        MailBox mbox = new MailBox("qwq");
        // mbox.addMail

        mbox.addMail(new VoiceMail("11111"));
        mbox.addMail(new TextMail("22222"));

        mbox.readAll();
    }

}
