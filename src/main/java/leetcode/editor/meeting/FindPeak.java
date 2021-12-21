package leetcode.editor.meeting;

/**
 * @ClassName FindPeak
 * @Description 字节面试题：找到最大值
 * @Author fangjiaxin
 * @Date 2021/12/15
 */
public class FindPeak {
    public static void main(String[] args) {
        FindPeak findPeak = new FindPeak();
        System.out.println(findPeak.findPeak(new int[]{0, 1, 2, 3, 2, 1}));
    }

    public int findPeak(int[] a) {
        int l = 0, r = a.length - 1;
        if (a.length == 1) return a[0];
        if (a.length == 2) return Math.max(a[0], a[1]);

        // 防止处理边界条件，简化判断
        while (l < r - 1) {
            int mid = (l + r) / 2;
            if (a[mid] < a[mid + 1]) {
                l = mid + 1;
            } else if (a[mid - 1] > a[mid]) {
                r = mid - 1;
            } else if (a[mid] > a[mid - 1] && a[mid] > a[mid + 1]) {
                return a[mid];
            }
        }
        return a[l];
    }
}
