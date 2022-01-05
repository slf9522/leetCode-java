package leetcode.editor.script;

public class TestClassLoader extends ClassLoader {
    private byte[] byteCode; //要加载类的字节码
    private String className; //要加载类的全限定名

    public TestClassLoader(String className, byte[] byteCode) {
        super(TestClassLoader.class.getClassLoader()); //调用父类构造方法，参数为父cl，此处为AppClassLoader
        this.byteCode = byteCode;
        this.className = className; //传入要加载的字节码和类名
    }

    /**
     * 此处重写findClass，没有重写loadClass，依然遵循双亲委派模型
     * 会首先尝试通过AppClassLoader及其父cl加载，加载不到将通过此方法加载
     *
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //将字节码加载进方法区
        return defineClass(className, byteCode, 0, byteCode.length);
    }

    public static void main(String[] args) throws Exception {
//        String sourceCode = "package leetcode.editor.script;\n" +
//                "\n" +
//                "import com.meituan.rc.zeus.dynamic.script.TestInterface;\n" +
//                "\n" +
//                "public class TestSourceImpl implements TestInterface {\n" +
//                "\n" +
//                "    public  String testOutput() {\n" +
//                "        return \"测试动态类的方法输出\";\n" +
//                "    }\n" +
//                "}";
//        //此处是zeus-nearline实现的编译源码方法，非jdk中方法
//        JavaStringCompiler javaStringCompiler = new JavaStringCompiler();
//        Map<String, byte[]> byteCodeMap = javaStringCompiler.compile("TestSourceImpl.java", sourceCode);
//        String className = "liutianyang.test.classloader.TestSourceImpl";
//        //为了测试类能被卸载，每次都重新实例化cl
//        TestClassLoader tcl = new TestClassLoader(className, byteCodeMap.get(className));
//        //实例化的cl加载类，符合双亲委派模型
//        Class<?> testClass = tcl.loadClass(className);
//        TestInterface testInterface = (TestInterface) testClass.newInstance();
//        System.out.println(testInterface.testOutput()); //打印测试类的方法功能
//        System.out.println("动态类的ClassLoader为：" + testClass.getClassLoader()); //打印测试类的classloader
//        //取消类对象，实例对象的引用
//        testInterface = null;
//        testClass = null;
//        //手动gc，此时由于cl对象没有被取消引用，liutianyang.test.classloader.TestSourceImpl类不会被卸载
//        System.gc();
//        System.out.println("首次尝试卸载类失败");
//        //取消对cl对象的引用
//        tcl = null;
//        //手动gc，此时liutianyang.test.classloader.TestSourceImpl类将被卸载
//        System.gc();
//        System.out.println("再次尝试卸载类成功");
    }
}