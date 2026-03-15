import java.util.*;

public class MainHashMap {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>(); // 创建HashMap对象
		map.put("1", "张三"); // 存储键和值
		map.put("2", "李四");
		map.put("3", "王五");
		map.put("4", "王五");
		map.put("4", "赵六");
		System.out.println("1：" + map.get("1")); // 根据键获取值
		System.out.println("2：" + map.get("2"));
		System.out.println("3：" + map.get("3"));
		System.out.println("4：" + map.get("4"));
		
		Set<String> keys = map.keySet();
		Iterator<String> it = keys.iterator();
		while(it.hasNext()){
			String str = it.next();
			System.out.println(str+":"+map.get(str));
		}
	}
}
