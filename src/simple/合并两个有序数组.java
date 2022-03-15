package simple;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素
 *
 * @Author whirabbit
 * @Date 2021/7/29 20:03
 * @Version 1.0
 */
public class 合并两个有序数组 {
    public static void main(String[] args) {
        int []nums1=new int[]{1,8,9,0,0,0,0};
        int []nums2=new int[]{3,4,5,6};
        for (int i : nums1) {
            System.out.println(i);
        }
        merge(nums1,3,nums2,4);
        System.out.println("-------------");
        for (int i : nums1) {
            System.out.println(i);
        }
    }
    public static void  merge(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;
        while (m > -1 && n > -1) {
            if (nums1[m] > nums2[n]) {
                nums1[m + n + 1] = nums1[m];
                m--;
            } else {
                nums1[m + n + 1] = nums2[n];
                n--;
            }
        }
        if (n>-1){
            while (n>-1){
                nums1[n]=nums2[n];
                n--;
            }
        }
    }
}
