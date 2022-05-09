package algorithm.linear.sort;

/**
 * @author HSL
 * @date 2022-03-31 21:40
 * @desc 合并两个有序数组
 */
public class LC_88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n;
        int[] temp = new int[k];

        for (int index = 0, nums1Index = 0, nums2Index = 0; index < k; index++) {
            if (nums1Index >= m) {
                temp[index] = nums2[nums2Index++];
            } else if (nums2Index >= n) {
                temp[index] = nums1[nums1Index++];
            } else if (nums1[nums1Index] < nums2[nums2Index]) {
                temp[index] = nums1[nums1Index++];
            } else {
                temp[index] = nums2[nums2Index++];
            }
        }

        if (k >= 0) System.arraycopy(temp, 0, nums1, 0, k);
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n;
        for (int index = k - 1, nums1Index = m - 1, nums2Index = n - 1; index >= 0; index--) {
            if (nums1Index < 0) {
                nums1[index] = nums2[nums2Index--];
            } else if (nums2Index < 0) {
                break;
            } else if (nums1[nums1Index] > nums2[nums2Index]) {
                nums1[index] = nums1[nums1Index--];
            } else {
                nums1[index] = nums2[nums2Index--];
            }
        }

    }
}
// 时间复杂度：O(m+n)
// 利用数组1的剩余空间