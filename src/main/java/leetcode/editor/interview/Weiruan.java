package leetcode.editor.interview;

import com.sun.tools.javac.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Weiruan
 * @Description //TODO
 * @Author fangjiaxin
 * @Date 2021/12/24
 */
public class Weiruan {
    public int findEnd(int[][] matrix, int[] start, int[] end) {
        int sx = start[0], sy = start[1];
        matrix[sx][sy] = 1;
        return findEndv2(matrix, start, end);
    }

    public int findEndv2(int[][] matrix, int[] start, int[] end) {

        int sx = start[0], sy = start[1];
        int m = matrix.length;
        int n = matrix[0].length;
        if (sx == end[0] && sy == end[1]) {
            return matrix[sx][sy];
        }

        int v1 = sy - 1 >= 0 && matrix[sx][sy - 1] != -1 && matrix[sx][sy - 1] != 0 ? matrix[sx][sy - 1] :
                Integer.MAX_VALUE;
        int v2 = sx + 1 < m && matrix[sx + 1][sy] != -1 ? matrix[sx + 1][sy] : Integer.MAX_VALUE;
        int v3 = sy + 1 < n && matrix[sx][sy + 1] != -1 ? matrix[sx][sy + 1] : Integer.MAX_VALUE;
        int v4 = sx - 1 >= 0 && matrix[sx - 1][sy] != -1 ? matrix[sx - 1][sy] : Integer.MAX_VALUE;

        matrix[sx][sy] = Math.min(Math.min(v1, v2), Math.min(v3, v4)) + 1;

        int res =Integer.MAX_VALUE;
        if (matrix[sx][sy - 1] != 0) res = Math.min(res, findEndv2(matrix, new int[]{sx, sy - 1}, end));
        if (matrix[sx + 1][sy] != 0) res = Math.min(res, findEndv2(matrix, new int[]{sx + 1, sy}, end));
        if (matrix[sx][sy + 1] != 0) res = Math.min(res, findEndv2(matrix, new int[]{sx, sy + 1}, end));
        if (matrix[sx - 1][sy] != 0) res = Math.min(res, findEndv2(matrix, new int[]{sx - 1, sy}, end));

        return res;
    }

    public static void main(String[] args) {
        List<Pair<Integer, Integer>> stack = new ArrayList<>();
        int k = 0;
        while(stack.size()>0){

        }
    }


}
