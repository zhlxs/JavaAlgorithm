package algorithm.linear.sort;

/**
 * @author HSL
 * @date 2022-04-04 23:23
 * @desc 移动零
 */
public class LC_283 {

    public void mvZeros(int[] nums) {
        // 双指针的解法
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }

        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
