import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> hashSet = new HashSet<>();
        int l = 0, r = 0;
        int tmpLength = 0;
        int maxLength = 0;

        while (r < s.length()) {
            if (!hashSet.contains(s.charAt(r))) {
                hashSet.add(s.charAt(r));
                r++;
                tmpLength++;
                if (tmpLength > maxLength)
                    maxLength = tmpLength;
            } else {
                hashSet.remove(s.charAt(l));
                l++;
                tmpLength--;
            }
        }

        return maxLength;
    }
}
// @lc code=end
