import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class RollBack {
//    public static List<List<Integer>> subsets(int[] nums) {
//        int len = nums.length;
//        List<List<Integer>> res = new ArrayList<>();
//        Deque<Integer> path = new ArrayDeque<>();
//
//        dfs(nums,len,0,res,path);
//
//        return res;
//    }
//
//    private static void dfs(int[] nums,int len,int level,List<List<Integer>> res,Deque<Integer> path){
//        if (level==len){
//            res.add(new ArrayList<>(path));
//            return;
//        }
//
//        dfs(nums,len,level+1,res,path);//不选当前数；
//        //选当前数；
//        path.add(nums[level]);
//        dfs(nums,len,level+1,res,path);
//        path.removeLast();
//    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> track = new ArrayDeque<>();
        trackBack(nums, res ,track, 0);
        return res;
    }

    private static void trackBack(int[] nums, List<List<Integer>> res, Deque<Integer> deque, int start) {
        res.add(new ArrayList<>(deque));
        for (int i = start; i < nums.length; i++) {
            deque.add(nums[i]);
            trackBack(nums, res, deque, i + 1);
            deque.removeLast();
        }
    }

//    public static List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> list = new ArrayList<>();
//        backtrack(list, new ArrayList<>(), nums, 0);
//        return list;
//    }
//
//    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
//        //走过的所有路径都是子集的一部分，所以都要加入到集合中
//        list.add(new ArrayList<>(tempList));
//        for (int i = start; i < nums.length; i++) {
//            //做出选择
//            tempList.add(nums[i]);
//            //递归
//            backtrack(list, tempList, nums, i + 1);
//            //撤销选择
//            tempList.remove(tempList.size() - 1);
//        }
//    }

    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        // 机器人从[0,0]坐标开始移动
        return df(m, n ,k , visited, 0, 0);
    }

//    public int dfs(int[][] path, int i, int j, int k) {
//        if (getNum(i) + get(j) > k || i < 0 || j < 0 || i > path.length - 1 || j > path[0].length - 1 || path[i][j] > 0) {
//            return 0;
//        }
//        path[i][j] = 1;
//        return dfs(path, i + 1, j, k) + dfs(path, i, j + 1, k);
//    }

    public int df(int m, int n, int k, boolean[][] visited, int x, int y){
        // 递归终止条件
        if((get(x) + get(y) > k) || x < 0 || x >= m || y < 0 || y >= n || visited[x][y]){
            return 0;
        }
        // 将该格子标记为已经访问过
        visited[x][y] = true;
        // 仅考虑向下和向右的移动方向
        return 1 + df(m, n , k, visited, x, y+1)
                + df(m, n , k, visited, x+1, y);
        // 回溯的返回过程
    }

    // 计算一个数的各个位数之和
    private int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }

    public static int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        // 特判
        if (n == 0) {
            return res;
        }

        dfs("", 0, 0, n, res);
        return res;
    }

    /**
     * @param curStr 当前递归得到的结果
     * @param left   左括号已经用了几个
     * @param right  右括号已经用了几个
     * @param n      左括号、右括号一共得用几个
     * @param res    结果集
     */
    private void dfs(String curStr, int left, int right, int n, List<String> res) {
        if (left == n && right == n) {
            res.add(curStr);
            return;
        }

        // 剪枝
        if (left < right) {
            return;
        }

        if (left < n) {
            dfs(curStr + "(", left + 1, right, n, res);
        }
        if (right < n) {
            dfs(curStr + ")", left, right + 1, n, res);
        }
    }
}
