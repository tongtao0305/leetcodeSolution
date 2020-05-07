/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        // 整数的范围是[-2^31=-2147483648，2^31-1=-2147483647]
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;

            // 如果转置后的整数超出了Integer的范围直接返回0
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;

            ans = ans * 10 + pop;
        }
        return ans;
    }

    public int reverse2(int x) {
        // 整数的范围是[-2^31=-2147483648，2^31-1=-2147483647]
        // 这种解法使用long来保存计算结果，可以避免每次循环都要进行是否溢出的判断
        long ans = 0;
        while (x != 0) {
            ans = ans * 10 + (x % 10);
            x = x / 10;
        }

        // 如果转置后的整数超出了Integer的范围直接返回0
        if (ans < Integer.MIN_VALUE || ans > Integer.MAX_VALUE)
            return 0;

        return (int)ans;
    }
}
// @lc code=end
