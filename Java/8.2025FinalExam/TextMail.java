public class TextMail implements Playable{
    private String content;
    
    public TextMail(String content) {
        this.content = content;
    }

    @Override
    public void play(){
        System.out.println(content);
    }
}