public class Dynamic {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaaabaaaaaaa"));
    }

    public static String longestPalindrome(String s) {
       int len = s.length();
       boolean[][] dp = new boolean[len][len];
       String ans = "";

       for (int nowLen = 0; nowLen < len; nowLen++) {
           for (int i = 0; i + nowLen < len; i++) {
               int j = i + nowLen;
               if (nowLen == 0) {
                   dp[i][j] = true;
               } else if (nowLen == 1) {
                   dp[i][j] = (s.charAt(i) == s.charAt(j));
               } else {
                   dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
               }
               if (ans.length() < j - i + 1 && dp[i][j]) {
                   ans = s.substring(i, j + 1);
               }
           }
       }
       return ans;
    }
}
