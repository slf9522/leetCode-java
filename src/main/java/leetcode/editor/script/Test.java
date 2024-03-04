package leetcode.editor.script;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Test {
//    public static void main(String[] args) {
//        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
//        // please finish the function body here.
//        // please define the JAVA output here. For example: System.out.println(s.nextInt());
//        Scanner s = new Scanner(System.in);
//
//        int start = 300;
//        while (s.hasNext()) {
//            String input = s.next();
//            List<Integer> take = Arrays.stream(input.split(",")).map(Integer::valueOf).collect(Collectors.toList());
//            int price = take.get(0);
//            int days = take.get(1);
//            int real = take.get(2);
//
//            int money = getMoney(price, days);
//
//            if (money > price) {
//                money = price;
//            }
//
//            if (money > start){
//                System.out.println(0);
//                continue;
//            }
//
//            if (real > days) {
//                int tmp = getMoney(price,real) + real-days;
//                if(tmp>price){
//                    money = price;
//                } else {
//                    money = tmp;
//                }
//            }
//            if (real < days) {
//                start -= getMoney(price, real);
//            } else {
//                start -= money;
//            }
//            System.out.println(start);
//
//        }
//
//        System.out.println(start);
//    }
//
//    public static int getMoney(int price, int days){
//        int money = 0;
//        if (price > 100) {
//            if (days > 15) {
//                money += 15 * 5 + (days - 15) * 3;
//            } else if (days > 0) {
//                money += days * 5;
//            }
//        } else if (price < 100 && price >= 50) {
//            if (days > 15) {
//                money += 15 * 3 + (days - 15) * 2;
//            } else if (days > 0) {
//                money += days * 3;
//            }
//        } else {
//            money += days;
//        }
//        return money;
//    }

    public static void main(String[] args) {
        Test t = new Test();
        t.test(27);
    }
    public static void test(Integer input) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());
//        Scanner s = new Scanner(System.in);
//        Integer input = s.nextInt();

        input = input;
        StringBuilder sb = new StringBuilder();
        while(input > 0) {
            int index = input % 26;
            char tmp;
            if(index == 0) {
                tmp = 'z';
            } else {
                tmp = (char) ('a' + index - 1);
            }
            sb.append(tmp);
            input /= 26;
            if(tmp == 'z') input--;
        }
        sb.reverse();
        System.out.println(sb.toString());
    }
}
