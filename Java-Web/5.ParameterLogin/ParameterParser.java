import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ParameterParser {
    private Map<String, String> params;
    public ParameterParser(String param){
        params = new HashMap<>();

        Arrays.stream(param.split("&"))
                .map(s -> s.split("="))
                .filter(arr -> arr.length == 2)
                .forEach(arr -> params.put(arr[0], arr[1]));
    } 
    public String get(String key){
        return params.get(key);
    }
}
