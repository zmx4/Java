public class Request {
    private String target;
    private String param;
    
    public Request(String requestString) {
        String getString = requestString.split(" ")[1];
        target = getString.split("\\?")[0];
        param = getString.split("\\?").length > 1 ? getString.split("\\?")[1] : "";
    }

    public String getTarget() {
        return target;
    }
    public String getParam() {
        return param;
    }

}
