package algorithm.linear.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HSL
 * @date 2022-04-04 23:42
 * @desc 找到数组中消失的数字
 */
public class LC_448 {

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums){
            int x  = (num -1)%n;
            nums[x] +=n;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                list.add(i + 1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {4, 4, 4, 4, 4};
        System.out.println(findDisappearedNumbers(nums));
    }
}
