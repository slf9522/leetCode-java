package leetcode.editor.interview;

/**
 * @ClassName PositionTarget
 * @Description //TODO
 * @Author fangjiaxin
 * @Date 2021/12/22
 */
public class PositionTarget {
    public int findPos(int[] positions, int[] speeds, int target) {
        int max = (target - positions[positions.length - 1]) / speeds[positions.length - 1];
        int res = 0;
        for (int i = positions.length - 1; i >= 0; i++) {
            int t = (target - positions[i]) / speeds[i];
            if (t < max) res++;
            max = Math.max(max, t);
        }
        return res;
    }
}
