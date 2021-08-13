import java.text.SimpleDateFormat;
import java.util.*;

public class StringTest {
    public static void main(String[] args) {
        char a1 = '第', a2 = '点', a3 = '进', a4 = '公';
        char secret = '8';
        a1 = (char) (a1 ^ secret);
        a2 = (char) (a2 ^ secret);
        a3 = (char) (a3 ^ secret);
        a4 = (char) (a4 ^ secret);
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
        System.out.println(Integer.highestOneBit((8 - 1) << 1));

        HashMap<String, String> map = new HashMap<>(1 << 5);

        ArrayList<String> list = new ArrayList<>();
        list.add("111");
        list.add("112");
        list.add("113");
        list.add("114");
        list.add("115");
        list.add("116");
        list.add("115");
        list.add("115");
        list.remove("114");

        System.out.println("sdasd" + getLeftTime(1625074135000l));
    }

    // 精确到毫秒
    public static long getLeftTim(long leftTime) {
        long start = System.currentTimeMillis();
        //需要计算运行天数时，计算差值
        long days = (start - leftTime) / (1000 * 60 * 60 * 24);
        //运行天数从1开始计数
        long runningDays = days + 1;
        //判断是否跨天，若跨天，运行天数还要+1
        long probableEndMillis = start + (1000 * 60 * 60 * 24) * days;
        if (new Date(probableEndMillis).getDay() != new Date(leftTime).getDay()) {
            runningDays++;
        }
        return runningDays;
    }

    public static long getLeftTime(long end) {
        if (end == -1)
            return -1;
        if (end == 0)
            return 0;
        long start = System.currentTimeMillis();
        long DAY = 1000 * 60 * 60 * 24;
        int day = (int) ((start - end) / DAY);
        long more = end % DAY;
        if (more > 0) {
            day++;
        }
        if (day > 0) {
            return day;
        } else {
            return 1;
        }
    }

    public String reverseWords(String s) {
        String[] strs = s.trim().split(" "); // 删除首尾空格，分割字符串
        StringBuilder res = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) { // 倒序遍历单词列表
            if (strs[i].equals("")) continue; // 遇到空单词则跳过
            res.append(strs[i] + " "); // 将单词拼接至 StringBuilder
        }
        return res.toString().trim(); // 转化为字符串，删除尾部空格，并返回
    }

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        HashSet<Character> set = new HashSet<Character>();
        for (char c : chars) {
            set.add(c);
        }
        return set.size();
    }

    public int lengthOfLongestSubstring1(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, start = 0;
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)) {
                start = Math.max(map.get(ch) + 1, start);
            }
            max = Math.max(max, end - start + 1);
            map.put(ch, end);
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0, max = 0, length = s.length();
        while (i < length && j < length) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }
}
