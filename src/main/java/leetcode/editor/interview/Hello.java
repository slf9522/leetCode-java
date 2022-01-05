package leetcode.editor.interview;

class Hello {
    {
        Holder.add(() -> {
            System.out.println("hello");
        });
    }

    public static void main(String[] args) {
        Hello hello = new Hello();
        Holder.dump();
        for (int i = 0; i < 100000; i++) {
            new Dummy();
        }
        System.gc();
        Holder.dump();
    }
}