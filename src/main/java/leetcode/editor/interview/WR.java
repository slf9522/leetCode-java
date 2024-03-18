package leetcode.editor.interview;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.HashSet;

public class WR {
    public static void main(String[] args) {

    }

//    public int convert(String input) {
//        if (input == null) {
//            throw new InvalidParameterException("invalid");
//        }
//        //1. validate
//        String modify = input.trim();
//        if (modify.isEmpty()) {
//            throw new InvalidParameterException("invalid");
//        }
//
//        char c = modify.charAt(0);
//        if (c != '+' && c != '-' && (c - '0' < 0 || c - '0' > 9)) {
//            throw new InvalidParameterException("invalid");
//        }
//
//        int negative = (modify.charAt(0) == '-') ? -1 : 1;
//
//        int i = 0;
//        if (c == '-' || c == '+') {
//            i = 1;
//            if (modify.length() == 1) {
//                throw new InvalidParameterException("invalid");
//            }
//        }
//
//        long res = 0;
//        for (; i < modify.length(); i++) {
//            c = modify.charAt(i);
//            if (c - '0' < 0 || c - '0' > 9) {
//                throw new InvalidParameterException("invalid");
//            }
//            res += res * 10 + (c - '0');
//
//            if (res > Integer.MAX_VALUE) {
//                throw new InvalidParameterException("long");
//            }
//        }
//
//        return (int) res * negative;
//    }

    public int[] calc(int[] nums) {
        int l = nums.length;
        int[] sum = new int[l + 1];
        int[] max = new int[l + 1];

        for (int i = 1; i < l + 1; i++) {
            sum[i] = sum[i] + nums[i - 1];
            max[i] = Math.max(max[i - 1], sum[i]);
        }

        int min = 0; // input
        for (int i = 1; i < l + 1; i++) {
//            min = Math.min(sum[i]-max[i], min);
            int tmp = sum[i] - max[i];
            if (tmp < min) {

            }
        }
        return new int[]{};
    }
}
