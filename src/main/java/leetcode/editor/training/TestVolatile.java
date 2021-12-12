package leetcode.editor.training;

public class TestVolatile {

    public static boolean flag = false;

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("修改flag的线程开始");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            flag = true;
            System.out.println("修改flag的线程结束");
        }).start();

        while (true) {
            if (flag) {
                System.out.println("flag修改了，退出循环");
                break;
            }
        }
    }
}