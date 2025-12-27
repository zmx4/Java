
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.util.HashMap;
import java.util.Map;
/*
按以下要求编写程序：（20分）
假设本地磁盘D盘根目录下有一文件order.txt，该文件
的内容为按行排列的订单明细（客户编号-客户名称-总金额）：
g001-张三-20
g002-李四-30
g003-王五-40
另一个文件paid.txt，该文件的内容为按行排列的已付款
明细（客户编号-客户名称-已付金额）：
g001-张三-15
g002-李四-20
g003-王五-10
编程完成以下要求：读取文件order.txt和paid.txt的内
容，统计每个客户的剩余应付金额，然后创建result.txt并
写入该文件（格式：客户编号-客户名称-应付金额）。
*/
public class File {
    public static void main(String[] args) {
        try {
            BufferedReader biso = new BufferedReader(new FileReader("D:\\order.txt"));
            BufferedReader bisp = new BufferedReader(new FileReader("D:\\paid.txt"));
            Map<String, Integer> hm = new HashMap<String, Integer>();
            String temp = new String();
            while ((temp = biso.readLine()) != null) {
                String[] strs = temp.split("-");
                hm.put(strs[0] + "-" + strs[1], Integer.parseInt(strs[2]));
            }
            while ((temp = bisp.readLine()) != null) {
                String[] strs = temp.split("-");
                hm.put(strs[0] + "-" + strs[1], hm.get(strs[0] + "-" + strs[1]) - Integer.parseInt(strs[2]));
            }
            biso.close();
            bisp.close();
            BufferedWriter bw = new BufferedWriter(new FileWriter("D://result.txt"));
            for (Map.Entry<String, Integer> entry : hm.entrySet()) {
                System.out.println(entry.getKey() + "-" + entry.getValue());
                bw.write(entry.getKey() + "-" + entry.getValue());
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
