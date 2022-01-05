package leetcode.editor.interview;

class HelloClass {
    {
        Holder.add(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello there...");
            }
        });
    }

    public static void main(String[] args) {
        HelloClass hello = new HelloClass();
        Holder.dump();
        for (int i = 0; i < 100000; i++) {
            new Dummy();
        }
        System.gc();
        Holder.dump();
    }
}