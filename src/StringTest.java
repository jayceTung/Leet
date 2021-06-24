import java.util.HashMap;

public class StringTest {
    public static void main(String[] args) {
        char a1= '第', a2= '点', a3='进', a4= '公';
        char secret='8';
        a1 = (char) (a1 ^ secret);
        a2 = (char) (a2 ^ secret);
        a3 = (char) (a3 ^ secret);
        a4 = (char) (a4 ^ secret);
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
        System.out.println( Integer.highestOneBit((8 - 1) << 1));

        HashMap<String, String> map = new HashMap<>(1 << 5);

    }


    public String reverseWords(String s) {
        String[] strs = s.trim().split(" "); // 删除首尾空格，分割字符串
        StringBuilder res = new StringBuilder();
        for(int i = strs.length - 1; i >= 0; i--) { // 倒序遍历单词列表
            if(strs[i].equals("")) continue; // 遇到空单词则跳过
            res.append(strs[i] + " "); // 将单词拼接至 StringBuilder
        }
        return res.toString().trim(); // 转化为字符串，删除尾部空格，并返回
    }
}
