import java.lang.*;

public class Utils {
    private static final int threshold = 3;

    public static int calculate(String x, String y) {
        int[][] dp = new int[x.length() + 1][y.length() + 1];

        for (int i = 0; i <= x.length(); i++) {
            for (int j = 0; j <= y.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1]
                                    + costOfSubstitution(x.charAt(i - 1), y.charAt(j - 1)),
                            Math.min(dp[i - 1][j] + 1,
                            dp[i][j - 1] + 1));
                }
            }
        }

        return dp[x.length()][y.length()];
    }

    public static int costOfSubstitution(char x, char y){
        return x == y ? 0 : 1;
    }

    public static int LongestCommonSubString(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (a.charAt(i) == b.charAt(j)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[a.length()-1][b.length()-1];
    }



    public static void main(String[] args) {
        String a = "shieubeo";
        String b = "noobinvokerhieubeo";
        System.out.println(calculate(a, b));
        System.out.println(LongestCommonSubString(a, b));
    }


    }