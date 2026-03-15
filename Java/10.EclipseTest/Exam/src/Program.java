import java.util.*;
import java.io.*;
public class Program {
	public static void main(String[] args) {
		Map<String,Integer> mp = new HashMap<String,Integer>(); 
		try {
			BufferedReader topay = new BufferedReader(new FileReader("D:\\order.txt"));
			Map<String,Integer> map = new HashMap<String,Integer>();
			String temp = null;
			while((temp = topay.readLine()) != null) {
				String[] strs = temp.split("-");
				map.put(strs[0]+"-"+strs[1], Integer.parseInt(strs[2]));
			}
			topay.close();
			BufferedReader paid  = new BufferedReader(new FileReader("D:\\paid.txt"));
			while((temp = paid.readLine()) != null) {
				String[] strs = temp.split("-");
				map.merge(strs[0]+"-"+strs[1], -Integer.parseInt(strs[2]), Integer::sum);
			}
			paid.close();
			BufferedWriter wr = new BufferedWriter(new FileWriter("D:\\target.txt")); 
			for(Map.Entry<String,Integer> entry:map.entrySet()) {
				wr.write(entry.getKey()+"-"+String.valueOf(entry.getValue()));
				wr.newLine();
			}
			wr.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
