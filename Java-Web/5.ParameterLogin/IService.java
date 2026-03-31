import java.io.*;

public interface IService {
    public void process(String param, BufferedReader br, BufferedWriter bw) throws Exception;
}
