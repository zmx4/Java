public class VoiceMail implements Playable{
    private String content;
    @Override
    public void play(){
        System.out.println(content);
    }
    public VoiceMail(String content) {
        this.content = content;
    }
}
